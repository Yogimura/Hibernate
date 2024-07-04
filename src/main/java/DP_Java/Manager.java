package DP_Java;

import DP_Java.EmployeeManager.*;
import DP_Java.HQL.TravelReview;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Manager extends SQLManager {
    protected SessionFactory sessionFactory = null;
    public void init() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (HibernateException HE) {
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println("Tudo mal");
            throw HE;
        }
    }

    public void prog_init() {
        Configuration config = new Configuration();
        getConfiguration(config);
        addHQL(config);

        try {
            sessionFactory = config.buildSessionFactory();
        } catch (HibernateException HE) {
            System.out.println("Tudo mal");
            throw HE;
        }
    }

    private void getConfiguration(Configuration config) {
        config.setProperty("connection.pool_size", "10");
        config.setProperty("hibernate.current_session_context_class", "thread");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/JH");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        config.setProperty("hibernate.connection.username", "root");
        config.setProperty("hibernate.connection.password", "12345");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        config.setProperty("hibernate.hbm2ddl.auto", "create");
    }

    private void addEmployeeManager(Configuration config) {
        config.addPackage("DP_Java.EmployeeManager")
                .addAnnotatedClass(EmployeeTPerC.class)
                .addAnnotatedClass(ExecutiveTPerC.class)
                .addAnnotatedClass(EmployeeTPerSC.class)
                .addAnnotatedClass(ExecutiveTPerSC.class)
                .addAnnotatedClass(EmployeeTPerCS.class)
                .addAnnotatedClass(ExecutiveTPerCS.class);
    }

    private void addFilter(Configuration config) {
        config.addPackage("DP_Java.Filter")
                .addResource("Filter.hbm.xml");
    }

    private void addHQL(Configuration config) {
        config.addPackage("DP_Java.HQL")
                .addAnnotatedClass(TravelReview.class);
    }
}
