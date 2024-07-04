package DP_Java.Misc;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class confs {
    String user;
    String password;

    private void setConfig() {
        Configuration cfg = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect")
                .setProperty("hibernate.connection.username", user)
                .setProperty("hibernate.connection.password", password)
                .setProperty("hibernate.connection.url", "jdbc:derby:memory:JH;create=true")
                .setProperty("hibernate.order_updates", "true");
    }

    private SessionFactory sessionFactory = null;

    public void initSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private void persist() {
        Transaction tx = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            tx = session.beginTransaction();
            Course course = createCourse();
            session.save(course);
            tx.commit();
        } catch (HibernateException he) {
            if (tx != null) tx.rollback();
            throw he;
        }

    }

    private Course createCourse() {
        return new Course();
    }
}

class Course {}
