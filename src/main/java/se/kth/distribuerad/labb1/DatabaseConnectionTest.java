package se.kth.distribuerad.labb1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        // Ange databasanslutningsdetaljer här
        String jdbcUrl = "jdbc:mysql://localhost:3306/labb1"; // Ersätt med din databas
        String username = "root"; // Ersätt med ditt MySQL användarnamn
        String password = "root"; // Ersätt med ditt MySQL lösenord

        Connection connection = null;

        try {
            // Försök att ansluta till databasen
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            if (connection != null) {
                System.out.println("Anslutning till databasen lyckades!");
            }
        } catch (SQLException e) {
            // Om anslutningen misslyckas
            System.out.println("Fel vid anslutning till databasen!");
            e.printStackTrace();
        } finally {
            // Stänger anslutningen om den är öppen
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Databasanslutningen är stängd.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
