package DP_Java.VanillaMovieManager;


import DP_Java.Manager;
import org.hibernate.Session;

import java.util.List;

public class BasicMovieManager extends Manager {

    public void persistMovie(MovieDB movie) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(movie);
        session.getTransaction().commit();
    }

    private void findMovie(int movieId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        MovieDB movie = (MovieDB)session.load(MovieDB.class, movieId);
        System.out.println("MovieDB:"+movie);
        session.getTransaction().commit();
    }

    public void findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<MovieDB> movies = session.createQuery("from MovieDB").stream().toList();
        session.getTransaction().commit();
        System.out.println("All Movies:");
        movies.forEach(System.out::println);
    }


}

