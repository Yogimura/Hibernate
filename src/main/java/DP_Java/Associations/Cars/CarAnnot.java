package DP_Java.Associations.Cars;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="Car_one2one_ann")
public class CarAnnot {
    @Id
    @Column(name = "Card_id")
    @GeneratedValue(strategy = AUTO)
    private int id;

    private String name = null;
    private String color = null;

    @OneToOne(cascade = ALL)
    @JoinColumn(name="Engine_id")
    private EngineAnnot engine = null;

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

    public EngineAnnot getEngine() {
        return engine;
    }

    public void setEngine(EngineAnnot engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "CarAnnot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine.getModel() +
                '}';
    }
}
