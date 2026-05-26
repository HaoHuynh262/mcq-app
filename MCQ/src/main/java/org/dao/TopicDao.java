package org.dao;

import org.entity.Question;
import org.entity.Topic;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateUtil;

import java.util.List;

public class TopicDao {
    public boolean insert(Topic a) {
        Transaction trans = null;

        try (Session s = HibernateUtil.getFactory().openSession()) {
            trans = s.beginTransaction();
            s.persist(a);
            trans.commit();
            return true;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            return false;
        }
    }

    public List<Question> getAll() {
        try (Session s = HibernateUtil.getFactory().openSession()) {
            return s.createQuery("from question", Question.class).list();
        }
    }

    public Question getById(int id) {
        try (Session s = HibernateUtil.getFactory().openSession()) {
            return s.find(Question.class, id);
        }
    }


}
