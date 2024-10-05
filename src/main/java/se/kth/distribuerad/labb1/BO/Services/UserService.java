package se.kth.distribuerad.labb1.BO.Services;

import se.kth.distribuerad.labb1.DB.DAO.UserDAO;
import se.kth.distribuerad.labb1.UI.UserDTO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

public class UserService {

    private static UserDAO userDAO;

    public UserService(Connection con){this.userDAO = new UserDAO(con);}

    public static UserDTO getUserDAO(String email){
        UserDTO user= null;
        try{
            return userDAO.getUserByEmail(email).makeDTO();
        }catch (SQLException e){e.printStackTrace();}
        return user;
    }
}
