package se.kth.distribuerad.labb1.UI;

import se.kth.distribuerad.labb1.BO.Role;

public class UserDTO {
    private int userID;
    private String email;
    private String username;
    private String password;
    private Role role;

    // Konstruktorer
    public UserDTO(int userID, String email, String username, String password, Role role) {
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UserDTO(String email, String username, String password, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters och Setters
    public int getUserID() { return userID; }

    public void setUserID(int userID){
        this.userID=userID;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

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
