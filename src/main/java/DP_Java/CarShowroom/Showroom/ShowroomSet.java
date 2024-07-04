package DP_Java.CarShowroom.Showroom;

import DP_Java.CarShowroom.Cars.CarSet;

import java.util.Set;

public class ShowroomSet {
    private int idShowroom = 0;
    private String manager = null;
    private String location = null;

    private Set<CarSet> cars = null;

    public ShowroomSet() {}

    public int getIdShowroom() {
        return idShowroom;
    }

    public void setIdShowroom(int idShowroom) {
        this.idShowroom = idShowroom;
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

    public Set<CarSet> getCars() {
        return cars;
    }

    public void setCars(Set<CarSet> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomSet{" +
                "idShowroom=" + idShowroom +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
