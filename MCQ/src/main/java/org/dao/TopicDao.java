package org.dao;

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
            e.printStackTrace();
            if (trans != null) {
                trans.rollback();
            }
            return false;
        }
    }

    public List<Topic> getAll() {
        try (Session s = HibernateUtil.getFactory().openSession()) {
            return s.createQuery("from Topic", Topic.class).list();
        }
    }

    public Topic getById(int id) {
        try (Session s = HibernateUtil.getFactory().openSession()) {
            return s.find(Topic.class, id);
        }
    }

    public Topic findByTitle(String title) {
        try (Session s = HibernateUtil.getFactory().openSession()) {
            List<Topic> list = s.createQuery(
                    "from Topic t where t.tpTitle = :title",
                    Topic.class)
                    .setParameter("title", title)
                    .list();

            return list.isEmpty() ? null : list.get(0);
        }
    }
}
