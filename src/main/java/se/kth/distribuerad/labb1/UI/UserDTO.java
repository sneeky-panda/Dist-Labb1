package se.kth.distribuerad.labb1.UI;

import se.kth.distribuerad.labb1.BO.Role;
import se.kth.distribuerad.labb1.BO.Services.UserService;
/**
 * UserDTO representerar en användare i systemet.
 * Klassen innehåller information om användarens ID, e-postadress, användarnamn, lösenord och roll.
 */
public class UserDTO {
    /**
     * Den unika ID som användaren har
     */
    private int userID;
    /**
     * Användarens email och inloggnings namn
     */
    private String email;
    /**
     * Användarens valda namn
     */
    private String username;
    /**
     * Användarens lösenord
     */
    private String password;
    /**
     * Anvädarens roll som ska ge eventuell behörighet
     */
    private Role role;

    /**
     *  Skapar en ny UserDTO med dessa attribut
     * @param userID
     * @param email
     * @param username
     * @param password
     * @param role
     */
    public UserDTO(int userID, String email, String username, String password, Role role) {
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Skapar en ny UserDTO med dessa attribut
     * @param email
     * @param username
     * @param password
     * @param role
     */
    public UserDTO(String email, String username, String password, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Skapar en ny UserDTO med dessa attribut
     * @param email
     * @param password
     */
    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     *
     * @return användarens unika ID
     */
    public int getUserID() { return userID; }

    /**
     * Sätter ID på objektet
     * @param userID
     */
    public void setUserID(int userID){
        this.userID=userID;
    }
    /**
     *
     * @return användarens email/inloggningsnamn
     */
    public String getEmail() { return email; }
    /**
     * Sätter användarens email/inloggningsnamn
     * @param email
     */
    public void setEmail(String email) { this.email = email; }
    /**
     *
     * @return användarens namn
     */
    public String getUsername() { return username; }
    /**
     * Sätter unsername till de valda namnet
     * @param username
     */
    public void setUsername(String username) { this.username = username; }
    /**
     *
     * @return användarens lösenord
     */
    public String getPassword() { return password; }

    /**
     * Sätter användarens lösenord
     * @param password
     */
    public void setPassword(String password) { this.password = password; }
    /**
     *
     * @return användares roll
     */

    public Role getRole() { return role; }
    /**
     * Sätter användares roll
     * @param role
     */
    public void setRole(Role role) { this.role = role; }

    /**
     *
     * @return en toString
     */
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='"+ password + '\''+
                ", role=" + role +
                '}';
    }
}
