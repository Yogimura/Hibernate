package DP_Java.EmployeeManager;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Inheritance_s3_executive_ann")
public class ExecutiveTPerCS extends Person{
    private double bonus = 0.0;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "ExecutiveTPerCS{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", bonus=" + getBonus() +
                "} ";
    }
}
