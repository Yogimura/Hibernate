package DP_Java.CarShowroom.Showroom;

import DP_Java.CarShowroom.Cars.CarMap;

import java.util.Map;

public class ShowroomMap {
    private int idShowroom = 0;
    private String manager = null;
    private String location = null;
    private Map<String, CarMap> cars = null;

    public ShowroomMap() {
    }

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

    public Map<String, CarMap> getCars() {
        return cars;
    }

    public void setCars(Map<String, CarMap> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomMap{" +
                "idShowroom=" + idShowroom +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
