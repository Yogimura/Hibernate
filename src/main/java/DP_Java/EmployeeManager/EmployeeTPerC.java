package DP_Java.EmployeeManager;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Entity
@Table(name="Inheritance_s1_employee_an")
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name="Discriminator", discriminatorType = STRING)
@DiscriminatorValue(value = "EmployeeTPerC")
public class EmployeeTPerC {
    @Id
    @Column(name="Employee_id")
    @GeneratedValue(strategy = IDENTITY)
    protected int id = 0;
    protected String name = null;

    public EmployeeTPerC() {}

    public EmployeeTPerC(String name) {
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
        return "EmployeeTPerC{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                '}';
    }
}
