package DP_Java.VanillaMovieManager;

import java.sql.*;

public class VanillaMovieManager {

    private Connection connection = null;

    private final String connectionURL = "jdbc:mysql://localhost:3306/JH";
    private final String user = "root";
    private final String password = "12345";

    private final String insertSql = "INSERT INTO Movies VALUES (?, ?, ?, ?)";
    private final String selectSql = "SELECT * FROM Movies";

    private void persisMovie() {
        try {
            PreparedStatement pst = getConnection().prepareStatement(insertSql);
            pst.setInt(1, 1001);
            pst.setString(2, "Top Gun");
            pst.setString(3, "Tony Scott");
            pst.setString(4, "Action Film");

            pst.execute();
            System.out.println("MovieDB persisted successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void queryMovies() {
        try {
            Statement st = getConnection().createStatement();
            ResultSet rs = st.executeQuery(selectSql);
            st.close();
            while (rs.next()) {
                System.out.printf("MovieDB found: %d, Title: %s\n", rs.getInt("ID"), rs.getString("Title"));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }


    protected Connection getConnection() {
        try {
            connection = DriverManager.getConnection(connectionURL, user, password);
        } catch (SQLException ex) {
            System.err.println("Exception: " + ex.getMessage());
        }

        return connection;
    }
}
