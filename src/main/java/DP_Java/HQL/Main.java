package DP_Java.HQL;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        QueriesNQueries queries = new QueriesNQueries();
        queries.prog_init();
        queries.populate();
        queries.retrieveAll();

        System.out.println("\n");

        queries.retrieveLondon();

        System.out.println("\n");

        queries.retrieveIn();

        System.out.println("\n");

        queries.retrievePositional();

        System.out.println("\n");

        queries.retrieveIterator();

        System.out.println("\n");

        queries.retrieveSelect();

        System.out.println("\n");

        queries.retrieveTuple();

        System.out.println("\n");

        queries.retrieveEffectiveTuple();

        System.out.println("\n");

        queries.retrieveAggregate();

        System.out.println("\n");

        queries.UpdateOrDelete();

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.ALL);

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.GT);

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.LT);

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.Like);

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.Between);

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.In);

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.Null);

        System.out.println("\n");

        queries.retrieveCriteria(criteriaGuide.NotNull);

        System.out.println("\n");

        queries.retrievePredicateArray();

        System.out.println("\n");

        queries.retrievePredicateBoolean();

        System.out.println("\n");

        queries.retrieveCriteriaSort();

        System.out.println("\n");

        queries.retrieveCriteriaAggregate();

        System.out.println("\n");

        queries.UpdateOrDeleteCriteria();

        System.out.println("\n");

        queries.retrieveNamed();

        System.out.println("\n");

        queries.retrieveSQL();
    }
}
