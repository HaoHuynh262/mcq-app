package org.bll;

import org.dao.QuestionDao;
import org.dao.TopicDao;
import org.entity.Question;
import org.entity.Topic;

public class QuestionBLL {
    private final QuestionDao questionDao = new QuestionDao();
    private final TopicBLL topicBLL = new TopicBLL();

    public void createQuestion(Question question, String topicTitle) {
        Topic topic = topicBLL.getOrCreateTopic(topicTitle);
        question.setQTopicId(topic.getTpID());
        questionDao.insert(question);
    }
}
