package DP_Java.CourseManagement;

import DP_Java.Manager;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CourseManagement extends Manager {


    public void persist() {
        Course1 course = new Course1();
        CoursePK coursePK = new CoursePK();
        coursePK.setTitle("Computer Science");
        coursePK.setTutor("Prof. Harry Barry");

        course.setId(coursePK);
        course.setTotalStudents(20);
        course.setRegisteredStudents(12);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            System.out.println(course);
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persist2() {
        Course2 course = new Course2("Financial Risk Management", "Harry Barry");
        course.setTotalStudents(20);
        course.setRegisteredStudents(12);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            System.out.println(course);
        }catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persist3() {
        Course3 course = new Course3("Adam Smith", "Database Management");
        course.setRegisteredStudents(12);
        course.setTotalStudents(20);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
            System.out.println(course);
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }
}
