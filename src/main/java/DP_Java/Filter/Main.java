package DP_Java.Filter;

public class Main {
    public static void main(String[] args) {
        CarManager carManager = new CarManager();
        carManager.prog_init();
        carManager.persist();
        carManager.retrieve();
    }
}
