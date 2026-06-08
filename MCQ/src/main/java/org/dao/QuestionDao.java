package org.dao;

import org.entity.Question;
import org.entity.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateUtil;
import java.util.List;

public class QuestionDao {
    public boolean insert(Question a) {
        Transaction trans = null;
        // s -> .getFactory là getConnect
        try (Session s = HibernateUtil.getFactory().openSession()) {
            trans = s.beginTransaction(); // khởi động
            s.persist(a); // báo với Hibernate
            trans.commit(); // Thực hiện
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
            return false;
        }
    }

    public List<Question> getAll() {
        try (Session s = HibernateUtil.getFactory().openSession()) {
            return s.createQuery("from Question", Question.class).list();
        }
    }

    public List<Question> getByTopic(Topic topic) {
        try (Session s = HibernateUtil.getFactory().openSession()) {
            return s.createQuery(
                    "from Question q where q.topic = :topic order by q.qId",
                    Question.class)
                    .setParameter("topic", topic)
                    .list();
        }
    }
}
