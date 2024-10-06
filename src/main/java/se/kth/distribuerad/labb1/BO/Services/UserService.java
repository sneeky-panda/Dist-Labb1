package se.kth.distribuerad.labb1.BO.Services;

import se.kth.distribuerad.labb1.BO.User;
import se.kth.distribuerad.labb1.DB.DAO.UserDAO;
import se.kth.distribuerad.labb1.UI.UserDTO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * UserService hanterar logiken relaterad till användare.
 * Den fungerar som en brygga mellan databasen och presentationslagret.
 */
public class UserService {
    /**
     * Dataåtkomstobjekt (DAO) för användare som tillåter interaktion med databasen.
     */
    private UserDAO userDAO;

    /**
     * Skapar en ny instans av UserService och initierar DAO med en databasanslutning.
     *
     * @param con Databasanslutningen som används för att kommunicera med användardatabasen.
     */
    public UserService(Connection con){ this.userDAO = new UserDAO(con);
    }

    /**
     * Hämtar en användare baserat på deras e-postadress.
     * Använder UserDAO för att hämta en användare från databasen och omvandlar den till en UserDTO.
     *
     * @param email E-postadressen för användaren som ska hämtas.
     * @return En UserDTO av användaren om den hittar, annars returneras null.
     */
    public UserDTO getUserDAO(String email){
        UserDTO user= null;
        try{
            return userDAO.getUserByEmail(email).makeDTO();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
