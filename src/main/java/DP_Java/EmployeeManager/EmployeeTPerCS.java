package DP_Java.EmployeeManager;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Inheritance_s3_employee_ann")
public class EmployeeTPerCS extends Person{
    private String role = null;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "EmployeeTPerCS{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", role='" + getRole() + '\'' +
                "} ";
    }
}
