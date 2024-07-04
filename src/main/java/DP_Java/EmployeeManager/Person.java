package DP_Java.EmployeeManager;

import javax.persistence.*;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class Person {
    @Id
    @GeneratedValue
    @Column(name="Employee_id")
    private int id = 0;
    private String name = null;

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
}
