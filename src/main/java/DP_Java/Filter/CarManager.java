package DP_Java.Filter;

import DP_Java.Manager;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CarManager extends Manager {
    public void persist() {
        Car car = new Car();
        car.setId(1);
        car.setName("gina");
        car.setColor("Green");
        car.setMake("BMW");
        car.setModel("ATS V8");

        Car car2 = new Car();
        car2.setId(2);
        car2.setName("pedro");
        car2.setColor("Blue");
        car2.setMake("Ford");
        car2.setModel("ATS V8");

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(car);
            session.save(car2);

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieve() {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Filter filter = session.enableFilter("filterByMake");
            filter.setParameter("make", "BMW");
            List<Car> results = session.createQuery("from CarAsso", Car.class).list();
            results.forEach(System.out::println);
            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }
}
