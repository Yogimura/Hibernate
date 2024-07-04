package DP_Java.Associations.Cars;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="Engine_one2one_ann")
public class EngineAnnot {
    @Id
    @Column(name="Engine_id")
    @GeneratedValue(strategy = AUTO)
    private int id = 0;

    private String make = null;
    private String model = null;
    private String size = null;

    @OneToOne
    private CarAnnot car = null;

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

    public CarAnnot getCar() {
        return car;
    }

    public void setCar(CarAnnot car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "EngineAnnot{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                ", car=" + car.getName() +
                '}';
    }
}
