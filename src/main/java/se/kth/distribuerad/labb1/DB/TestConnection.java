package se.kth.distribuerad.labb1.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class TestConnection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        UserDAOImpl userDAO = null;  // Flytta upp deklarationen av userDAO
        try {
            connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Anslutningen till databasen lyckades!");
            }

            // Initiera userDAO efter att anslutningen har etablerats
            userDAO = new UserDAOImpl(connection);

            System.out.println("1 för att lägga till användare. 2 för att ta bort användare.");
            int x = scanner.nextInt();
            scanner.nextLine();  // Rensa radbrytning efter nextInt()

            switch (x) {
                case 1:
                    System.out.println("Ange email:");
                    String email = scanner.nextLine();
                    System.out.println("Ange namn:");
                    String namn = scanner.nextLine();
                    System.out.println("Ange lösenord:");
                    String losenord = scanner.nextLine();
                    System.out.println("Ange roll:");
                    String role = scanner.nextLine();  // Roll anges som sträng nu

                    User newUser = new User(email, namn, losenord, role);
                    userDAO.addUser(newUser);

                    System.out.println("En ny användare har lagts till.");

                    List<User> users = userDAO.getAllUsers();
                    System.out.println("Lista över alla användare i databasen:");
                    for (User user : users) {
                        System.out.println(user);
                    }
                    break;  // Viktigt att lägga till för att undvika att fortsätta till nästa case

                case 2:
                    System.out.println("Ange email för att ta bort användare:");
                    String eMail = scanner.nextLine();

                    List<User> allUsers = userDAO.getAllUsers();
                    if (allUsers.size() != 0) {
                        userDAO.deleteUser(eMail);
                        System.out.println("Användaren har tagits bort.");
                        System.out.println("Lista över alla användare i databasen:");
                        List<User> userS = userDAO.getAllUsers();
                        for (User user : userS) {
                            System.out.println(user);
                        }
                    } else {
                        System.out.println("Inga användare finns i databasen.");
                    }
                    break;  // Viktigt att lägga till för att undvika att fortsätta till nästa case

                default:
                    System.out.println("Ogiltigt val, vänligen välj 1 eller 2.");
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
            scanner.close();  // Stänger scanner för att undvika resurshanteringsproblem
        }
    }
}
