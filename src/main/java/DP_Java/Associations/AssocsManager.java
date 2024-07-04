package DP_Java.Associations;

import DP_Java.Associations.Cars.*;
import DP_Java.Associations.Cinema.Actor;
import DP_Java.Associations.Cinema.Actorbi;
import DP_Java.Associations.Cinema.Movie;
import DP_Java.Associations.Cinema.Moviebi;
import DP_Java.Associations.Students.Course;
import DP_Java.Associations.Students.Student;
import DP_Java.Manager;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AssocsManager extends Manager {

    //cars
    public void persistCarEngine() {
        CarAsso car = new CarAsso();

        car.setId(1);
        car.setName("Cadillac ATS Sedan");
        car.setColor("White");

        Engine engine = new Engine();
        engine.setMake("V8 Series");
        engine.setModel("DTS");
        engine.setSize("1.6 V8 Gas");

        car.setEngine(engine);
        engine.setCar(car);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(car);
            session.save(engine);
            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistCarEngine2() {
        Engine2 e = new Engine2();
        e.setId(1);
        e.setMake("V8 Series");
        e.setModel("DTS");
        e.setSize("1.6 V8 Gas");

        Car2 car = new Car2();
        car.setId(1);
        car.setName("Cadillac ATS Sedan");
        car.setColor("White");
        car.setEngine(e);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(car);
            session.getTransaction().commit();
        }catch(HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistAnnoCarEngine() {
        CarAnnot car = new CarAnnot();
        EngineAnnot engine = new EngineAnnot();

        car.setName("Corolla");
        car.setColor("White");
        engine.setMake("V8 Series");
        engine.setModel("DTS");
        engine.setSize("1.6 V8 Gas");

        car.setEngine(engine);
        engine.setCar(car);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(car);
            session.save(engine);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveCarEngine() {
        Session session = sessionFactory.getCurrentSession();

        List cars;
        List engines;
        try {
            session.beginTransaction();
            cars = session.createQuery("from CarAsso").stream().toList();
            engines = session.createQuery("from Engine").stream().toList();

            for (int x = 0; x < cars.size(); x++) {
                System.out.println(cars.get(x) + "\n" + engines.get(x) + "\n");
            }

            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveCarEngine2() {
        Session session = sessionFactory.getCurrentSession();

        List cars;

        try {
            session.beginTransaction();
            cars = session.createQuery("from Car2").stream().toList();

            for(Object o: cars) {
                System.out.println(cars);
            }

            session.getTransaction().commit();

        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveAnnoCarEngine() {
        Session session = sessionFactory.getCurrentSession();
        List cars;
        List engines;

        try {
            session.beginTransaction();
            cars = session.createQuery("from CarAnnot").stream().toList();
            engines = session.createQuery("from EngineAnnot").stream().toList();

            for(int x = 0; x < (cars.size() + engines.size())/2; x++) {
                System.out.println(cars.get(x) + "|" + engines.get(x));
            }

            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    //Cinema

    public void persistActorMovie() {
        Movie movie = new Movie(1,"Chennai Express");
        Set<Actor> actors = new HashSet<>();

        actors.add(new Actor(1,"Sharukh", "Khan", "King Khan"));
        actors.add(new Actor(2,"Deepika", "Padukone", "Miss Chennai"));

        movie.setActors(actors);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(movie);
            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveActorMovie() {
        Session session = sessionFactory.getCurrentSession();

        List movies;

        try {
            session.beginTransaction();
            movies = session.createQuery("from Movie").stream().toList();

            for(Object o: movies) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        } catch (HibernateException HE){
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void persistBiActorMovie() {
        Moviebi movie = new Moviebi();
        movie.setId(1);
        movie.setTitle("Chennai Express");

        Set<Actorbi> actors = new HashSet<>();

        actors.add(new Actorbi(1,"Sharukh", "Khan", "King Khan"));
        actors.add(new Actorbi(2,"Deepika", "Padukone", "Miss Chennai"));
        actors.forEach(p -> p.setMovie(movie));

        movie.setActors(actors);

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(movie);
            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }

    }

    public void retrieveBiActorMovie() {
        Session session = sessionFactory.getCurrentSession();
        List movies;
        List actors;
        try{
            session.beginTransaction();
            movies = session.createQuery("from Moviebi").stream().toList();
            actors = session.createQuery("from Actorbi").stream().toList();

            for(Object o: movies) {
                System.out.println(o);
            }
            System.out.println();
            for (Object o: actors) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        }catch (HibernateException HE) {
            if(session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    //Students

    public void persistCourseStudent() {
        Course Biology = new Course(1, "Biology");
        Course Art = new Course(2, "Art");
        Course Language = new Course(3, "Language");

        Student Mark = new Student(1, "Mark");
        Student Thomas = new Student(2, "Thomas");
        Student Jude = new Student(3, "Jude");

        Biology.setStudents(new HashSet<>(List.of(Mark, Thomas)));
        Art.setStudents(new HashSet<>(List.of(Thomas, Jude)));
        Language.setStudents(new HashSet<>(List.of(Jude, Mark)));

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            session.save(Mark);
            session.save(Thomas);
            session.save(Jude);
            session.save(Biology);
            session.save(Art);
            session.save(Language);
            session.getTransaction().commit();
        } catch (HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }

    public void retrieveCourseStudent() {
        Session session = sessionFactory.getCurrentSession();

        List courses;
        List students;

        try{
            session.beginTransaction();
            courses = session.createQuery("from Course").stream().toList();
            students = session.createQuery("from Student").stream().toList();

            for (Object o: courses) {
                System.out.println(o);
            }

            System.out.println();

            for(Object o: students) {
                System.out.println(o);
            }

            session.getTransaction().commit();
        }catch(HibernateException HE) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            throw HE;
        }
    }
}
