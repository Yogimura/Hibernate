package DP_Java.EmployeeManagement;

import javax.persistence.*;

@Entity
@Table(name="Employees")
public class Employee {
    @Id
    @Column(name="Employee_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "empTableGen")
    //@TableGenerator(name = "empTableGen", table = "EMP_ID_TABLE")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empSeqGen")
    //@SequenceGenerator(name = "empSeqGen", sequenceName = "EMP_SEQ_GEN")
    private int id = 0;

    @Column(name = "Name", nullable = true)
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

    @Override
    public String toString() {
        return id + ":" + name;
    }
}
