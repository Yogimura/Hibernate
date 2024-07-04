package DP_Java.Filter;

public class Car {
    private int id = 0;
    private String color = null;
    private String name = null;
    private String make = null;
    private String model = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "CarAsso{" +
                "id=" + getId() +
                ", color='" + getColor() + '\'' +
                ", name='" + getName() + '\'' +
                ", make='" + getMake() + '\'' +
                ", model='" + getModel() + '\'' +
                '}';
    }
}
