package DP_Java.HQL;

import DP_Java.Manager;
import org.apache.commons.math3.util.Precision;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.criteria.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueriesNQueries extends Manager {
    public void retrieveAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<TravelReview> query = session.createQuery("from TravelReview", TravelReview.class);
        query.setMaxResults(100);
        query.setFirstResult(10);
        List<TravelReview> reviews = query.list();
        reviews.forEach(System.out::println);
        session.getTransaction().commit();
    }

    public void retrieveLondon() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<TravelReview> query = session.createQuery("from TravelReview as tr where tr.title=:title and tr.id=:id", TravelReview.class);
        String city = "London";
        query.setParameter("title", city);
        query.setParameter("id", 22);
        TravelReview review = query.uniqueResult();
        System.out.println(review);
        session.getTransaction().commit();
    }

    public void retrieveIn() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<String> titleList = new ArrayList<>();
        titleList.add("London");
        titleList.add("Venice");

        Query<TravelReview> query = session.createQuery("from TravelReview where title in (:titleList)", TravelReview.class);
        query.setParameterList("titleList", titleList);
        List<TravelReview> reviews = query.list();
        reviews.forEach(System.out::println);
        session.getTransaction().commit();
    }

    public void retrievePositional() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<TravelReview> query = session.createQuery("from TravelReview where title=?0 and id=?1", TravelReview.class);
        query.setParameter(0, "London");
        query.setParameter(1, 22);
        TravelReview review = query.uniqueResult();
        System.out.println(review);
        session.getTransaction().commit();
    }

    public void retrieveIterator() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<TravelReview> query = session.createQuery("from TravelReview", TravelReview.class);
        query.setMaxResults(10);
        Iterator<TravelReview> iterator = query.iterate();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        session.getTransaction().commit();
    }

    public void retrieveSelect() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<String> query = session.createQuery("SELECT tr.title from TravelReview as tr", String.class);
        query.setMaxResults(10);
        List<String> cities = query.list();
        cities.forEach(System.out::println);
        session.getTransaction().commit();
    }

    public void retrieveTuple() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Object[]> query = session.createQuery("SELECT tr.title, tr.stars from TravelReview as tr", Object[].class);
        query.setMaxResults(10);
        Iterator<Object[]> iterator = query.iterate();

        while (iterator.hasNext()) {
            Object[] r = iterator.next();
            System.out.printf("City: %s, stars: %s\n", r[0], r[1]);
        }

        session.getTransaction().commit();
    }

    public void retrieveEffectiveTuple() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<City> query = session.createQuery("SELECT new DP_Java.HQL.City(tr.title, tr.stars) from TravelReview as tr", City.class);
        query.setMaxResults(10);

        List<City> cities = query.list();
        cities.forEach(System.out::println);
        session.getTransaction().commit();
    }

    public void retrieveAggregate() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Double average = session.createQuery("SELECT avg(tr.stars) FROM TravelReview as tr", Double.class).uniqueResult();
        Float max = session.createQuery("SELECT max(tr.stars) FROM TravelReview as tr", Float.class).uniqueResult();

        System.out.println("Average: " + Precision.round(average, 2));
        System.out.println("Max: " + max);

        session.getTransaction().commit();
    }

    public void retrieveNamed() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<TravelReview> reviews = session.createNamedQuery("getAll", TravelReview.class).setMaxResults(10).list();
        TravelReview review = session.createNamedQuery("getById", TravelReview.class).setParameter("id", 1).uniqueResult();

        System.out.println(review);
        System.out.println();
        reviews.forEach(System.out::println);
        session.getTransaction().commit();
    }

    public void retrieveSQL() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        NativeQuery<TravelReview> query = session.createNativeQuery("select * from TravelReview", TravelReview.class);
        query.setMaxResults(20);
        List<TravelReview> reviews = query.list();
        reviews.forEach(System.out::println);
    }

    public void retrieveCriteria(criteriaGuide cr) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TravelReview> criteria = criteriaBuilder.createQuery(TravelReview.class);
        Root<TravelReview> root = criteria.from(TravelReview.class);

        switch (cr) {
            case ALL -> {
                criteria.select(root);
            }
            case GT -> {
                criteria.select(root).where(criteriaBuilder.gt(root.get("stars"), 3.0));
            }
            case LT -> {
                criteria.select(root).where(criteriaBuilder.lt(root.get("stars"), 3.0));
            }
            case Like -> {
                criteria.select(root).where(criteriaBuilder.like(root.get("title"), "%lla%"));
            }
            case Between -> {
                criteria.select(root).where(criteriaBuilder.between(root.get("stars"), 2.0, 4.0));
            }
            case In -> {
                criteria.select(root).where(root.get("title").in("Cacocum", "Helie"));
            }
            case Null -> {
                criteria.select(root).where(criteriaBuilder.isNull(root.get("review")));
            }
            case NotNull -> {
                criteria.select(root).where(criteriaBuilder.isNotNull(root.get("review")));
            }
        }

        Query<TravelReview> query = session.createQuery(criteria);
        query.setMaxResults(10);
        List<TravelReview> results = query.getResultList();
        results.forEach(System.out::println);

        session.getTransaction().commit();
    }

    public void retrievePredicateArray() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TravelReview> criteriaQuery = criteriaBuilder.createQuery(TravelReview.class);
        Root<TravelReview> root = criteriaQuery.from(TravelReview.class);

        Predicate[] predicates = new Predicate[2];
        predicates[0] = criteriaBuilder.isNull(root.get("review"));
        predicates[1] = criteriaBuilder.like(root.get("title"), "%lla%");
        criteriaQuery.select(root).where(predicates);

        Query<TravelReview> query = session.createQuery(criteriaQuery);
        query.setMaxResults(10);
        List<TravelReview> results = query.getResultList();
        results.forEach(System.out::println);

        session.getTransaction().commit();
    }

    public void retrievePredicateBoolean() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TravelReview> criteriaQuery = criteriaBuilder.createQuery(TravelReview.class);
        Root<TravelReview> root = criteriaQuery.from(TravelReview.class);

        Predicate greaterThanPrice = criteriaBuilder.greaterThan(root.get("stars"), 3.0);
        Predicate allYouSee = criteriaBuilder.like(root.get("title"), "%lla%");

        criteriaQuery.select(root).where(criteriaBuilder.or(greaterThanPrice, allYouSee));
        Query<TravelReview> queryOr = session.createQuery(criteriaQuery);
        queryOr.setMaxResults(10);

        criteriaQuery.select(root).where(criteriaBuilder.and(greaterThanPrice, allYouSee));
        Query<TravelReview> queryAnd = session.createQuery(criteriaQuery);
        queryAnd.setMaxResults(10);


        List<TravelReview> resultsOr = queryOr.getResultList();
        List<TravelReview> resultsAnd = queryAnd.getResultList();

        resultsOr.forEach(System.out::println);
        System.out.println("\n");
        resultsAnd.forEach(System.out::println);

        session.getTransaction().commit();
    }

    public void retrieveCriteriaSort(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TravelReview> criteriaQuery = criteriaBuilder.createQuery(TravelReview.class);
        Root<TravelReview> root = criteriaQuery.from(TravelReview.class);
        criteriaQuery.orderBy(
                criteriaBuilder.asc(root.get("title")),
                criteriaBuilder.desc(root.get("stars"))
        );

        criteriaQuery.select(root);

        Query<TravelReview> reviewQuery = session.createQuery(criteriaQuery);
        reviewQuery.setMaxResults(10);
        List<TravelReview> reviews = reviewQuery.getResultList();

        reviews.forEach(System.out::println);

        session.getTransaction().commit();
    }

    public void retrieveCriteriaAggregate() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQueryLong = criteriaBuilder.createQuery(Long.class);
        Root<TravelReview> rootLong = criteriaQueryLong.from(TravelReview.class);

        criteriaQueryLong.select(criteriaBuilder.count(rootLong));

        Query<Long> longQuery = session.createQuery(criteriaQueryLong);
        List<Long> amount = longQuery.getResultList();
        amount.forEach(System.out::println);

        CriteriaQuery<Double> criteriaQueryDouble = criteriaBuilder.createQuery(Double.class);
        Root<TravelReview> rootDouble = criteriaQueryDouble.from(TravelReview.class);

        criteriaQueryDouble.select(criteriaBuilder.avg(rootDouble.get("stars")));

        Query<Double> doubleQuery = session.createQuery(criteriaQueryDouble);
        List<Double> average = doubleQuery.getResultList();
        average.forEach(p -> System.out.println(Precision.round(p, 2)));

        session.getTransaction().commit();
    }



    public void UpdateOrDelete() {
        String Update_Query = "update TravelReview set review=:review where id=2";
        String Delete_Query = "delete TravelReview where id=101";
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query QueryUpdate = session.createQuery(Update_Query);
        QueryUpdate.setParameter("review", "The city with charm. The city you will never forget");
        int success = QueryUpdate.executeUpdate();
        System.out.println("Update = " + success);

        Query QueryDelete = session.createQuery(Delete_Query);
        success = QueryDelete.executeUpdate();
        System.out.println("Delete = " + success);

        session.getTransaction().commit();
    }

    public void UpdateOrDeleteCriteria() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaUpdate<TravelReview> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(TravelReview.class);
        Root<TravelReview> root = criteriaUpdate.from(TravelReview.class);

        criteriaUpdate.set("stars", 3.0);
        criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), 1));
        int success = session.createQuery(criteriaUpdate).executeUpdate();
        System.out.println("Update = " + success);
        TravelReview travelReview = session.createQuery("from TravelReview where id = 1", TravelReview.class).uniqueResult();
        System.out.println(travelReview);

        CriteriaDelete<TravelReview> criteriaDelete = criteriaBuilder.createCriteriaDelete(TravelReview.class);
        root = criteriaDelete.from(TravelReview.class);
        criteriaDelete.where(criteriaBuilder.equal(root.get("id"), 98));
        success = session.createQuery(criteriaDelete).executeUpdate();
        System.out.println("Delete = " + success);
        transaction.commit();

    }

    public void fetchJoin() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TravelReview> query = criteriaBuilder.createQuery(TravelReview.class);
        Root<TravelReview> root = query.from(TravelReview.class);
        root.fetch("city", JoinType.LEFT);
        query.where(criteriaBuilder.equal(root.get("city").get("name"), "London"));

        List<TravelReview> reviews = session.createQuery(query).getResultList();
        reviews.forEach(System.out::println);
        session.getTransaction().commit();
    }

    public void populate() throws FileNotFoundException {
        String path = "src/main/java/DP_Java/HQL/TravelReview.sql";
        ScriptRunner scriptRunner = new ScriptRunner(getConnection());
        scriptRunner.setSendFullScript(false);
        scriptRunner.setStopOnError(true);
        scriptRunner.setLogWriter(null);
        scriptRunner.runScript(new FileReader(path));
    }
}

