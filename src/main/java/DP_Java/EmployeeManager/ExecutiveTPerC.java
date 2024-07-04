package DP_Java.EmployeeManager;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ExecutiveTPerC")
public class ExecutiveTPerC extends EmployeeTPerC {
    private String role = null;

    public ExecutiveTPerC() {}

    public ExecutiveTPerC(String name) {
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
        return "ExecutiveTPerC{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", role='" + getRole() + '\'' +
                "} ";
    }
}
