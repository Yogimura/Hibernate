package DP_Java.Types;

import DP_Java.Manager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class TypeManager extends Manager {

    public void initsd() {
        Configuration config = new Configuration().configure();
        config.registerTypeOverride(new PhoneNumberType());
    }

    public void firstLevelCache() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        int personId = 10;

        try {
            PersonType person = new PersonType();
            person.setId(personId);
            person.setFirstName("Vladimir");
            person.setLastName("De Castro");

            session.save(person);
            System.out.println(person.getNickName());
            person = session.load(PersonType.class, personId);
            person.setNickName("MK2");

            session.save(person);
            System.out.println(person.getNickName());
            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        } finally {
            session.close();
        }

    }
}
