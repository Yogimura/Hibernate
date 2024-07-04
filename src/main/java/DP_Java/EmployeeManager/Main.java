package DP_Java.EmployeeManager;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = new EmployeeManager();
        employeeManager.prog_init();

        employeeManager.persistTPerC();
        employeeManager.retrieveTPerC();

        System.out.println("\n");

        employeeManager.persistTPerSC();
        employeeManager.retrieveTPerSC();

        System.out.println("\n");
        employeeManager.persistTPerCS();
        employeeManager.retrieveTPerCS();
    }
}
