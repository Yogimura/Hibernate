package DP_Java.EmployeeManager;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Inheritance_s2_executive_ann")
@PrimaryKeyJoinColumn(name="Employee_id")
public class ExecutiveTPerSC extends EmployeeTPerSC{
    private String role = null;

    public ExecutiveTPerSC() {}

    public ExecutiveTPerSC(String name) {
        super(name);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ExecutiveTPerSC{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", role='" + getRole() + '\'' +
                "} ";
    }
}
