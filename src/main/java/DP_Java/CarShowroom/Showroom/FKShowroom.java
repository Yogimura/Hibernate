package DP_Java.CarShowroom.Showroom;

import DP_Java.CarShowroom.Cars.FKCar;
import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.util.List;

import static org.hibernate.annotations.CascadeType.ALL;

@Entity(name = "FK_Showroom")
@Table(name = "FK_Showroom")
public class FKShowroom {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Showroom_id")
    private int idShowroom=0;

    @OneToMany
    @JoinColumn(name = "Showroom_id")
    @Cascade(ALL)
    private List<FKCar> cars = null;

    private String manager = null;
    private String location = null;

    public int getIdShowroom() {
        return idShowroom;
    }

    public void setIdShowroom(int idShowroom) {
        this.idShowroom = idShowroom;
    }

    public List<FKCar> getCars() {
        return cars;
    }

    public void setCars(List<FKCar> cars) {
        this.cars = cars;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "FKShowroom{" +
                "idShowroom=" + idShowroom +
                ", manager=" + manager +
                ", location='" + location + '\'' +
                ", cars='" + cars + '\'' +
                '}';
    }
}
