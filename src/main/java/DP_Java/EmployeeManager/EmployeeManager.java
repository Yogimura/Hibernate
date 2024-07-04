package DP_Java.EmployeeManager;

import DP_Java.Manager;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class EmployeeManager extends Manager {
    public void persistTPerC() {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            EmployeeTPerC employee = new EmployeeTPerC("Barry Bumbles");
            session.save(employee);

            ExecutiveTPerC executive = new ExecutiveTPerC("Harry Dumbles");
            executive.setRole("Director");
            session.save(executive);

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        } finally {
            session.close();
        }
    }

    public void persistTPerSC(){
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            EmployeeTPerSC employee = new EmployeeTPerSC("Barry Bumbles");
            session.save(employee);

            ExecutiveTPerSC executive = new ExecutiveTPerSC("Harry Dumbles");
            executive.setRole("Director");
            session.save(executive);

            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }finally {
            session.close();
        }
    }

    public void persistTPerCS() {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            EmployeeTPerCS employee = new EmployeeTPerCS();
            employee.setId(1);
            employee.setName("Marcos");
            employee.setRole("Janitor");
            session.save(employee);

            ExecutiveTPerCS executive = new ExecutiveTPerCS();
            executive.setId(2);
            executive.setName("John");
            executive.setBonus(50.15);
            session.save(executive);

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveTPerC() {
        Session session = sessionFactory.getCurrentSession();

        List<EmployeeTPerC> employees;
        List<ExecutiveTPerC> executives;

        try {
            session.beginTransaction();
            employees = session.createQuery("from EmployeeTPerC", EmployeeTPerC.class).stream().toList();
            executives = session.createQuery("from ExecutiveTPerC", ExecutiveTPerC.class).stream().toList();

            employees.stream().filter(p -> p.getClass() != ExecutiveTPerC.class).forEach(System.out::println);
            executives.forEach(System.out::println);
            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        } finally {
            session.close();
        }
    }

    public void retrieveTPerSC() {
        Session session = sessionFactory.getCurrentSession();

        List<EmployeeTPerSC> employees;
        List<ExecutiveTPerSC> executives;

        try {
            session.beginTransaction();
            employees = session.createQuery("from EmployeeTPerSC", EmployeeTPerSC.class).stream().toList();
            executives = session.createQuery("from ExecutiveTPerSC", ExecutiveTPerSC.class).stream().toList();

            employees.stream().filter(p -> p.getClass() != ExecutiveTPerSC.class).forEach(System.out::println);
            executives.forEach(System.out::println);

            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        } finally {
            session.close();
        }
    }

    public void retrieveTPerCS() {
        Session session = sessionFactory.getCurrentSession();
        List<EmployeeTPerCS> employees;
        List<ExecutiveTPerCS> executives;

        try {
            session.beginTransaction();
            employees = session.createQuery("from EmployeeTPerCS", EmployeeTPerCS.class).stream().toList();
            executives = session.createQuery("from ExecutiveTPerCS", ExecutiveTPerCS.class).stream().toList();

            employees.forEach(System.out::println);
            executives.forEach(System.out::println);

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }
}
