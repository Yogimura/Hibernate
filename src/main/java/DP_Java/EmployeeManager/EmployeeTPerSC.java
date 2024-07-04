package DP_Java.EmployeeManager;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.JOINED;

@Entity
@Table(name="Inheritance_s2_employee_ann")
@Inheritance(strategy = JOINED)
public class EmployeeTPerSC {
    @Id
    @Column(name="Employee_id")
    @GeneratedValue(strategy = IDENTITY)
    private int id = 0;
    private String name = null;

    public EmployeeTPerSC() {}

    public EmployeeTPerSC(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "EmployeeTPerSC{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
