package DP_Java.CarShowroom.Showroom;

import DP_Java.CarShowroom.Cars.CarJoin;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;
import static org.hibernate.annotations.CascadeType.ALL;

@Entity(name = "Showroom_join")
@Table(name = "Showroom_join")
public class ShowroomJoin {
    @Id
    @Column(name = "Showroom_id")
    @GeneratedValue(strategy = IDENTITY)
    private int id = 0;
    private String manager = null;
    private String location = null;

    @OneToMany
    @JoinTable(name = "Showroom_to_car_jointable", joinColumns = @JoinColumn(name="Showroom_id"))
    @Cascade(ALL)
    private Set<CarJoin> cars = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<CarJoin> getCars() {
        return cars;
    }

    public void setCars(Set<CarJoin> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomJoin{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
