package se.kth.distribuerad.labb1.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Labb1"; // Ändra till din databas-URL
    private static final String USER = "root"; // Ändra till ditt databas-användarnamn
    private static final String PASSWORD = "root"; // Ändra till ditt databas-lösenord

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
