package DP_Java.CarShowroom;

import DP_Java.CarShowroom.Cars.*;
import DP_Java.CarShowroom.Showroom.*;
import DP_Java.Manager;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.*;

public class ShowroomManager extends Manager {

    public void persistLists() {
        Session session = sessionFactory.getCurrentSession();
        ShowroomList showroomList = new ShowroomList();
        showroomList.setLocation("East Croydon, Greater London");
        showroomList.setManager("Barry Larry");

        List<CarList> cars = new ArrayList<>();
        cars.add(new CarList("Toyota", "Racing Green"));
        cars.add(new CarList("Nissan", "White"));
        cars.add(new CarList("BMW", "Black"));
        cars.add(new CarList("Mercedes", "Silver"));

        showroomList.setCars(cars);

        try {
            session.beginTransaction();
            session.save(showroomList);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistSets() {
        Session session = sessionFactory.getCurrentSession();
        ShowroomSet showroomSet = new ShowroomSet();
        showroomSet.setLocation("East Croydon, Greater London");
        showroomSet.setManager("Barry Larry");

        Set<CarSet> cars = new HashSet<>();
        cars.add(new CarSet("Toyota", "Racing Green"));
        cars.add(new CarSet("Toyota", "Racing Green"));
        cars.add(new CarSet("Nissan", "White"));
        cars.add(new CarSet("BMW", "Black"));
        cars.add(new CarSet("BMW", "Black"));

        showroomSet.setCars(cars);

        try {
            session.beginTransaction();
            session.save(showroomSet);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistMaps() {
        ShowroomMap showroomMap = new ShowroomMap();
        showroomMap.setLocation("East Croydon, Greater London");
        showroomMap.setManager("Cherry Flurry");

        Map<String, CarMap> cars = new HashMap<>();
        cars.put("Barry", new CarMap("Toyota", "Racing Green"));
        cars.put("Larry", new CarMap("Nissan", "White"));
        cars.put("Harry", new CarMap("BMW", "Black"));

        showroomMap.setCars(cars);

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(showroomMap);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistArrays() {
        ShowroomArray showroomArray = new ShowroomArray();
        showroomArray.setLocation("East Croydon, Greater London");
        showroomArray.setManager("Barry Larry");
        showroomArray.setCars(new String[]{"Toyota", "BMW", "Citroen"});

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(showroomArray);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistBags() {
        ShowroomBag showroomBag = new ShowroomBag();
        showroomBag.setLocation("East Croydon, Greater London");
        showroomBag.setManager("Barry Larry");

        List<CarBag> cars = new ArrayList<>();
        cars.add(new CarBag("Toyota", "Green"));
        cars.add(new CarBag("BMW", "Black"));
        cars.add(new CarBag("Citroen", "White"));

        showroomBag.setCars(cars);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(showroomBag);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistIdBags() {
        ShowroomIdbag showroomIdbag = new ShowroomIdbag();
        showroomIdbag.setLocation("East Croydon, Greater London");
        showroomIdbag.setManager("Barry Larry");

        List<CarIdbag> cars = new ArrayList<>();
        cars.add(new CarIdbag("Toyota", "Green"));
        cars.add(new CarIdbag("BMW", "Black"));
        cars.add(new CarIdbag("Citroen", "White"));

        showroomIdbag.setCars(cars);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(showroomIdbag);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistFK() {
        Session session = sessionFactory.getCurrentSession();
        FKShowroom showroomFK = new FKShowroom();
        showroomFK.setLocation("East Croydon, Greater London");
        showroomFK.setManager("Barry Larry");

        List<FKCar> cars = new ArrayList<>();
        cars.add(new FKCar("Toyota", "Racing Green"));
        cars.add(new FKCar("Nissan", "White"));
        cars.add(new FKCar("BMW", "Black"));
        cars.add(new FKCar("Mercedes", "Silver"));

        showroomFK.setCars(cars);

        try {
            session.beginTransaction();
            session.save(showroomFK);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistJoin() {
        Session session = sessionFactory.getCurrentSession();
        ShowroomJoin showroomJoin = new ShowroomJoin();
        showroomJoin.setLocation("East Croydon, Greater London");
        showroomJoin.setManager("Barry Larry");
        Set<CarJoin> cars = new HashSet<>();
        cars.add(new CarJoin("Nissan", "White"));
        cars.add(new CarJoin("BMW", "Green"));
        cars.add(new CarJoin("Mercedes", "Orange"));

        showroomJoin.setCars(cars);

        try {
            session.beginTransaction();
            session.save(showroomJoin);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }

    }

    public void retrieveList() {
        Session session = sessionFactory.getCurrentSession();
        List showroomSets;
        try {
            session.beginTransaction();
            showroomSets = session.createQuery("from ShowroomList").stream().toList();

            for (Object list : showroomSets) {
                System.out.println(list);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveSet() {
        Session session = sessionFactory.getCurrentSession();
        List showroomSets;
        try {
            session.beginTransaction();
            showroomSets = session.createQuery("from ShowroomSet").stream().toList();

            for (Object set : showroomSets) {
                System.out.println(set);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveMap() {
        Session session = sessionFactory.getCurrentSession();
        List showroomMaps;

        try {
            session.beginTransaction();
            showroomMaps = session.createQuery("from ShowroomMap").stream().toList();

            for (Object map : showroomMaps) {
                System.out.println(map);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveArray() {
        Session session = sessionFactory.getCurrentSession();
        List showroomArrays;

        try {
            session.beginTransaction();
            showroomArrays = session.createQuery("from ShowroomArray").stream().toList();

            for (Object o : showroomArrays) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveBag() {
        Session session = sessionFactory.getCurrentSession();
        List showroomBags;

        try {
            session.beginTransaction();
            showroomBags = session.createQuery("from ShowroomBag").stream().toList();

            for (Object o : showroomBags) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveIdBag() {
        Session session = sessionFactory.getCurrentSession();
        List ShowroomIdBags;

        try {
            session.beginTransaction();
            ShowroomIdBags = session.createQuery("from ShowroomIdbag").stream().toList();

            for (Object o : ShowroomIdBags) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveFK() {
        Session session = sessionFactory.getCurrentSession();
        List ShowroomFKs;

        try {
            session.beginTransaction();
            ShowroomFKs = session.createQuery("from FK_Showroom").stream().toList();

            for (Object o : ShowroomFKs) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveJoins() {
        Session session = sessionFactory.getCurrentSession();
        List ShowroomJoins;

        try {
            session.beginTransaction();
            ShowroomJoins = session.createQuery("from Showroom_join").stream().toList();

            for(Object o: ShowroomJoins) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }
}
