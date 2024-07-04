package DP_Java.Associations;

public class Main {
    public static void main(String[] args) {
        AssocsManager assocsManager = new AssocsManager();
        assocsManager.init();
        assocsManager.persistCarEngine();
        assocsManager.retrieveCarEngine();

        System.out.println("\n");

        assocsManager.persistCarEngine2();
        assocsManager.retrieveCarEngine2();

        System.out.println("\n");

        assocsManager.persistAnnoCarEngine();
        assocsManager.retrieveAnnoCarEngine();

        System.out.println("\n");

        assocsManager.persistActorMovie();
        assocsManager.retrieveActorMovie();

        System.out.println("\n");

        assocsManager.persistBiActorMovie();
        assocsManager.retrieveBiActorMovie();

        System.out.println("\n");

        assocsManager.persistCourseStudent();
        assocsManager.retrieveCourseStudent();
    }
}
