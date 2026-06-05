package org.bll;

import java.util.List;
import org.dao.TopicDao;
import org.entity.Topic;

public class TopicBLL {
    private final TopicDao topicDAO = new TopicDao();

    public Topic getOrCreateTopic(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("Topic title cannot be empty");
        }
        title = title.trim();
        Topic topic = topicDAO.findByTitle(title);
        if (topic == null) {
            topic = new Topic();
            topic.setTpTitle(title);
            topic.setTpParent(0);
            topic.setTpStatus(1);
            boolean ok = topicDAO.insert(topic);
            if (!ok) {throw new RuntimeException("Cannot create topic");}
        }
        return topic;
    }

    public List<Topic> getAllTopics() {
        return topicDAO.getAll();
    }
}