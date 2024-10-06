package se.kth.distribuerad.labb1.DB.DAO;


import se.kth.distribuerad.labb1.BO.Role;
import se.kth.distribuerad.labb1.BO.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 * UserDAO hanterar dataåtkomst operationer för användare i databasen.

 */
public class UserDAO {
    /**
     * Anslutningen till databasen som används för att utföra SQL-operationer.
     */
    private Connection con;
    /**
     * Skapar en ny instans av UserDAO med en specifik databasanslutning.
     * @param con Databasanslutningen som ska användas för att utföra operationer på användartabellen.
     */
    public UserDAO(Connection con) {
        this.con = con;
    }
    /**
     * Lägger till en ny användare i databasen.
     * @param user User-objektet som ska läggas till i databasen.
     * @throws SQLException Om ett fel inträffar vid åtkomst till databasen.
     */
    public void addUser(User user) throws SQLException{
        String query = "INSERT INTO users (email, username, password, role) VALUES(?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().name());

            System.out.println("Rollens värde som skickas: " + user.getRole());  // Debug-utskrift

            statement.executeUpdate();
            System.out.println("gick det?????");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hämtar en användare baserat på e-postadress.
     * @param email E-postadressen för användaren som ska hämtas.
     * @return Ett User-objekt som representerar den hittade användaren, eller null om ingen användare hittas.
     * @throws SQLException Om ett fel inträffar vid åtkomst till databasen.
     */
    public User getUserByEmail(String email) throws SQLException{
        String query = "SELECT * FROM users WHERE email = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User newUser = new User(
                        resultSet.getInt("User_ID"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        Role.valueOf(resultSet.getString("role"))  // Konvertera från String till enum
                );
                return newUser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Hämtar alla användare från databasen.
     * @return En lista av User-objekt som representerar alla användare i databasen.
     * @throws SQLException Om ett fel inträffar vid åtkomst till databasen.
     */
    public List<User> getAllUsers() throws SQLException {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<>();
        try (Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("User_ID"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        Role.valueOf(resultSet.getString("role"))  // Konvertera från String till enum
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    /**
     * Uppdaterar en befintlig användare i databasen.
     * @param user User-objektet med de uppdaterade värdena.
     * @throws SQLException Om ett fel inträffar vid åtkomst till databasen.
     */
    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET email = ?, username = ?, password = ?, role = ? WHERE user_ID = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().name());
            statement.setInt(5, user.getUserID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tar bort en användare från databasen baserat på e-postadress.
     * @param email E-postadressen för användaren som ska tas bort.
     * @throws SQLException Om ett fel inträffar vid åtkomst till databasen.
     */
    public void deleteUser(String email) throws SQLException {
        String query = "DELETE FROM users WHERE email = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, email);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
