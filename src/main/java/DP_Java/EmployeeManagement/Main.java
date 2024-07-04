package DP_Java.EmployeeManagement;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagement();
        employeeManagement.init();
        Employee carlos = new Employee();
        carlos.setId(3);
        carlos.setName("Carlos");
        employeeManagement.putEmployee(carlos);
        employeeManagement.getEmployees();
    }
}
