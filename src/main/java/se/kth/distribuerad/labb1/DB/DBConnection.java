package se.kth.distribuerad.labb1.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection hanterar anslutningen till databasen.
 * Denna klass implementerar ett singleton-mönster */
public class DBConnection {

    /**
     * URL för anslutning till MySQL-databasen.
     *
     */
    private static final String URL = "jdbc:mysql://localhost:3307/Labb1"; // Ändra till din databas-URL
    /**
     * Användarnamn för anslutning till databasen.
     */
    private static final String USER = "user";
    /**
     * Lösenord för anslutning till databasen.
     * Ändra till ditt databas-lösenord.
     */
    private static final String PASSWORD = "userpassword";
    /**
     * Singleton-instans av DBConnection.
     */
    private static DBConnection instance;
    /**
     * Connection-objektet som hanterar anslutningen till databasen.
     */
    private Connection conn;

    /**
     * Returnerar instansen av DBConnection. Om instansen inte existerar skapas en ny.
     * @return Den enda instansen av DBConnection.
     */
    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    /**
     * Privat konstruktor för att förhindra direkt instansiering och upprättar en anslutning till databasen.
     * Laddar MySQL-drivrutinen och upprättar anslutningen baserat på URL, användarnamn och lösenord.
     */
    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Hämtar anslutningen till databasen.
     * Om anslutningen inte existerar skapas en ny genom att anropa `getInstance()`.
     *
     * @return Connection-objektet som representerar anslutningen till databasen.
     * @throws SQLException Om anslutningen inte kan upprättas eller returneras.
     */
    public static Connection getConnection() throws SQLException {
        return DBConnection.getInstance().conn;
    }
    /**
     * Stänger anslutningen till databasen.
     * Om anslutningen är null händer ingenting.
     *
     * @param connection Connection-objektet som ska stängas.
     */
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
