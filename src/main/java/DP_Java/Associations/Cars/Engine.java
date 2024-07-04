package DP_Java.Associations.Cars;

public class Engine {
    private int id = 0;
    private String make = null;
    private String model = null;
    private String size = null;
    private CarAsso car = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public CarAsso getCar() {
        return car;
    }

    public void setCar(CarAsso car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", car=" + car.getName() + ":" + car.getColor() +
                '}';
    }
}
