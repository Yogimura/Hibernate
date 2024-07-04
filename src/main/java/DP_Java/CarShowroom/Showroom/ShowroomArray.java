package DP_Java.CarShowroom.Showroom;

import java.util.Arrays;

public class ShowroomArray {
    private int idShowroom = 0;
    private String manager = null;
    private String location = null;

    private String[] cars = null;

    public ShowroomArray() {
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

    public String[] getCars() {
        return cars;
    }

    public void setCars(String[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomArray{" +
                "idShowroom=" + idShowroom +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
