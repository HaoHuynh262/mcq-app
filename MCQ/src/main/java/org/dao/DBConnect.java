package org.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBConnect {
    private static final SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure("hibernate.cfg.xmml").buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("SessionFactory Error!");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
