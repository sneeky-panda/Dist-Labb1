package se.kth.distribuerad.labb1.DB.DAO;


import se.kth.distribuerad.labb1.BO.Role;
import se.kth.distribuerad.labb1.BO.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection con;

    public UserDAO(Connection con) {
        this.con = con;
    }

    public void addUser(User user) throws SQLException{
        String query = "INSERT INTO users (email, username, password, role) VALUES(?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getRole().name());  // Använd enumens namn som String

            System.out.println("Rollens värde som skickas: " + user.getRole());  // Debug-utskrift

            statement.executeUpdate();
            System.out.println("gick det?????");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
