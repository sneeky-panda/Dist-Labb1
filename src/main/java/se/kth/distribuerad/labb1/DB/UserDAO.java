package se.kth.distribuerad.labb1.DB;

import java.util.List;

    public interface UserDAO {
        void addUser(User user);
        User getUserById(String email);
        List<User> getAllUsers();
        void updateUser(User user);
        void deleteUser(String email);
    }

