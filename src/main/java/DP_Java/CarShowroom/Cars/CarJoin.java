package DP_Java.CarShowroom.Cars;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="Car_join")
@Table(name = "Car_join")
public class CarJoin {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Card_id")
    private int id;
    private String name = null;
    private String color = null;

    public CarJoin() {
    }

    public CarJoin(String name, String color) {
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
        return "\nCarJoin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

