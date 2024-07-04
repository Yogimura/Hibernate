package DP_Java.EmployeeManagement;

import DP_Java.Manager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class EmployeeManagement extends Manager {

    public void putEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw he;
        }
    }

    public void getEmployees() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Employee> employees = session.createQuery("from EmployeeTPerC").stream().toList();
        session.getTransaction().commit();
        System.out.println("Employees");
        employees.forEach(System.out::println);
    }
}
