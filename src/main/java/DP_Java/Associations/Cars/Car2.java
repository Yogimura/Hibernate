package DP_Java.Associations.Cars;

public class Car2 {
    private int id;
    private String name;
    private String color;
    private Engine2 engine;

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

    public Engine2 getEngine() {
        return engine;
    }

    public void setEngine(Engine2 engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
