package se.kth.distribuerad.labb1.DB.User;

import java.sql.SQLException;
import java.util.List;

    public interface UserDAO {
        void addUser(User user) throws SQLException;
        User getUserByEmail(String email) throws SQLException;
        List<User> getAllUsers() throws SQLException;
        void updateUser(User user) throws SQLException;
        void deleteUser(String email) throws SQLException;
    }

