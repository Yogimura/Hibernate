package DP_Java.CarShowroom;

public class Main {
    public static void main(String[] args) {
        ShowroomManager showroomManager = new ShowroomManager();
        showroomManager.init();

        showroomManager.persistLists();
        showroomManager.retrieveList();

        System.out.println("\n");

        showroomManager.persistSets();
        showroomManager.retrieveSet();

        System.out.println("\n");

        showroomManager.persistMaps();
        showroomManager.retrieveMap();

        System.out.println("\n");

        showroomManager.persistArrays();
        showroomManager.retrieveArray();

        System.out.println("\n");

        showroomManager.persistBags();
        showroomManager.retrieveBag();

        System.out.println("\n");

        showroomManager.persistFK();
        showroomManager.retrieveFK();

        System.out.println("\n");

        showroomManager.persistJoin();
        showroomManager.retrieveJoins();

        System.out.println("Tudo Ok");
    }
}
