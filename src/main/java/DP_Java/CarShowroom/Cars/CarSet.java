package DP_Java.CarShowroom.Cars;

import java.util.Objects;

public class CarSet {
    private int id;
    private String name = null;
    private String color = null;

    public CarSet() {}

    public CarSet(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\nCarSet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSet carSet = (CarSet) o;
        return getId() == carSet.getId() && Objects.equals(getName(), carSet.getName()) && Objects.equals(getColor(), carSet.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getColor());
    }
}
