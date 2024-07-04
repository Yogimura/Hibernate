package DP_Java.JPA;

public class Main {
    public static void main(String[] args) {
        JPAManager jpaManager = new JPAManager();
        jpaManager.InitEntities();
        jpaManager.persistNewInstrument();
        jpaManager.findInstrument();

    }
}
