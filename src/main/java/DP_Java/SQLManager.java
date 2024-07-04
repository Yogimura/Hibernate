package DP_Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLManager {
    private Connection connection = null;

    protected Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/JH";
            String user = "root";
            String password = "12345";
            connection = DriverManager.getConnection(connectionURL, user, password);
        } catch (SQLException ex) {
            System.err.println("Exception: " + ex.getMessage());
        }

        return connection;
    }
}
