package se.kth.distribuerad.labb1.BO;

import se.kth.distribuerad.labb1.UI.UserDTO;

import java.util.ArrayList;
/**
 * User representerar en användare i systemet.
 * Klassen innehåller information om användarens ID, e-postadress, användarnamn, lösenord och roll.
 */
public class User {
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
     *  Skapar en ny användare med dessa attribut
     * @param userID
     * @param email
     * @param username
     * @param password
     * @param role
     */
    public User(int userID, String email, String username, String password, Role role) {
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     *  Skapar en ny användare med dessa attribut
     * @param email
     * @param username
     * @param password
     * @param role
     */
    public User(String email, String username, String password, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     *  Skapar en ny användare med dessa attribut
     * @param email
     * @param password
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        //this.products = new ArrayList<>();
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
     * Gör om användare till en DTO med dess data
     * @return det ny skapade DTO
     */
    public UserDTO makeDTO(){

        return new UserDTO(email,username,password,role);
    }

    /**
     *
     * @return en to String
     */
    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
