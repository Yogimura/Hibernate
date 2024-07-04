package DP_Java.JPA;

import DP_Java.Manager;
import jakarta.annotation.Resource;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Getter
public class JPAManager extends Manager {
    @Resource
    private EntityManager manager = null;
    private EntityManagerFactory Factory = null;

    public void InitEntities() {
        Factory = Persistence.createEntityManagerFactory("trading-entities");
        manager = Factory.createEntityManager();
    }

    public void persistNewInstrument() {
        Instrument instrument = new Instrument();
        instrument.setIssue("IBM");

        manager.persist(instrument);
    }

    public void findInstrument() {
        Instrument instrument = manager.getReference(Instrument.class, 1);
        System.out.println(instrument);

        Instrument instrument1 = manager.find(Instrument.class, 1);
        System.out.println(instrument1);

        manager.remove("IBM");
        //manager.refresh(); pull from the database
        //manager.flush(); pull from the app
    }
}
