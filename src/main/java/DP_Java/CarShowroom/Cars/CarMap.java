package DP_Java.CarShowroom.Cars;

public class CarMap {
    private int id;
    private String name = null;
    private String color = null;

    public CarMap() {}

    public CarMap(String name, String color) {
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
        return "\nCarMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
