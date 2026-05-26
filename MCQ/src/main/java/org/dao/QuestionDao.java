package org.dao;

import org.entity.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.util.HibernateUtil;

public class QuestionDao {
    public boolean insert(Question a){
        Transaction trans = null;

        // s -> .getFactory là getConnect
        try (Session s = HibernateUtil.getFactory().openSession()) {
            trans = s.beginTransaction();  // khởi động
            s.persist(a);                  // báo với Hibernate
            trans.commit();                // Thực hiện
            return true;
        } catch (Exception e) {
            if (trans != null) {
                trans.rollback();
            }
            return false;
        }
    }
}
