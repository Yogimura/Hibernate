package DP_Java.CarShowroom.Cars;

import javax.persistence.*;

@Entity(name="FK_Car")
@Table(name = "FK_Car")
public class FKCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Card_id")
    private int id;
    private String name = null;
    private String color = null;

    public FKCar() {
    }

    public FKCar(String name, String color) {
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
        return "\nFKCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

