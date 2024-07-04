package DP_Java.CarShowroom.Showroom;

import DP_Java.CarShowroom.Cars.CarBag;

import java.util.Arrays;
import java.util.List;

public class ShowroomBag {
    private int idShowroom = 0;
    private String manager = null;
    private String location = null;
    private List<CarBag> cars = null;

    public ShowroomBag() {}
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

    public List<CarBag> getCars() {
        return cars;
    }

    public void setCars(List<CarBag> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomList{" +
                "idShowroom=" + idShowroom +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
