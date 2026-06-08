package org.bll;

import java.util.List;
import org.dao.TopicDao;
import org.entity.Topic;

public class TopicBLL {
    private final TopicDao topicDAO = new TopicDao();
    public void createTopic(Topic topic) {
        Topic exist = getTopicByTitle(topic.getTpTitle().trim());
        if (exist != null) {
            throw new RuntimeException("Topic: " + topic.getTpTitle() + " đã tồn tại");
        }
        boolean ok = topicDAO.insert(topic);
        if (!ok) {
            throw new RuntimeException("Tạo topic thất bại");
        }
    }

    public Topic getOrCreateTopic(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("Topic title không thể để trống");
        }
        title = title.trim();
        Topic topic = getTopicByTitle(title);
        if (topic == null) {
            topic = new Topic();
            topic.setTpTitle(title);
            topic.setTpParent(0);
            topic.setTpStatus(1);
            boolean ok = topicDAO.insert(topic);
            if (!ok) {throw new RuntimeException("Tạo topic thất bại");}
        }
        return topic;
    }

    public Topic getTopicByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("Topic title không thể để trống");
        }
        return topicDAO.findByTitle(title.trim());
    }

    public List<Topic> getAllTopics() {
        return topicDAO.getAll();
    }
}