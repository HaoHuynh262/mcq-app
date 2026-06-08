package org.bll;

import org.dao.QuestionDao;
import org.entity.Question;
import org.entity.Topic;
import java.util.List;

public class QuestionBLL {
    private final QuestionDao questionDao = new QuestionDao();
    private final TopicBLL topicBLL = new TopicBLL();

    public List<Question> getAllQuestions() {
        return questionDao.getAll();
    }

    public void createQuestion(Question question, String topicTitle) {
        Topic topic = topicBLL.getOrCreateTopic(topicTitle);
        question.setTopic(topic);
        questionDao.insert(question);
    }

    public Question getFirstQuestionAvailable() {
        List<Topic> topics = topicBLL.getAllTopics();
        for (Topic topic : topics) {
            Question q = getFirstQuestionByTopic(topic);
            if (q != null) {
                return q;
            }
        }
        return null;
    }
    
    public Question getFirstQuestionByTopic(Topic topic) {
        if (topic == null) {
            return null;
        }
        List<Question> questions = questionDao.getByTopic(topic);
        return questions.isEmpty()? null : questions.get(0);
    }
}
