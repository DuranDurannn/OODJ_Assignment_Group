/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yoyo.register;

/**
 *
 * @author Eow
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class EmployeeRegister {

    private static int nextUserId; // Initialize the ID counter

    static {
        // Initialize the ID counter by reading the last used ID from the file
        nextUserId = readLastUserId();
    }

    private static int readLastUserId() {
        try (BufferedReader reader = new BufferedReader(new FileReader("employeeRegistration.txt"))) {
            String line;
            int lastUserId = 0;

            // Read each line to find the last used user ID
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    int userId = Integer.parseInt(parts[0]);
                    lastUserId = Math.max(lastUserId, userId);
                }
            }

            return lastUserId + 1; // Increment to get the next user ID
        } catch (IOException | NumberFormatException e) {
            // Handle exceptions (e.g., file not found, invalid format)
            e.printStackTrace();
            return 1; // Default to 1 if there is an issue
        }
    }

    public static boolean registerUser(String username, String password, String confirmPassword, String email, String gender, String role) {
        // Validate if all fields are filled
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || gender.equals("--OPTION--") || role.equals("--OPTION--")) {
            // Display an error message or handle it according to your requirements
            JOptionPane.showMessageDialog(null, "Registration fail, please fill in all the fields", "Uh-oh!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please re-enter.");
            return false;
        }
        
        //Check for existing email
        try (BufferedReader reader = new BufferedReader(new FileReader("employeeRegistration.txt"))) {
            String line;
            int lastUserId = 0;

            // Read each line to find the last used user ID
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (email.equals(parts[3])){
                    JOptionPane.showMessageDialog(null, "Registration fail, eamil already used", "Uh-oh!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
        } catch (IOException | NumberFormatException e) {
            // Handle exceptions (e.g., file not found, invalid format)
            e.printStackTrace();
        }
        
        // Format the user ID with leading zeros (e.g., 001, 002, ...)
        String formattedUserId = String.format("%03d", nextUserId);

        // Save the data to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employeeRegistration.txt", true))) {
            // Append the new user data to the file with the formatted ID and role
            writer.write(formattedUserId + "," + username + "," + password + "," + email + "," + gender + "," + role.charAt(0));
            writer.newLine(); // Add a new line for the next entry
            JOptionPane.showMessageDialog(null, "Registration Successfull!");

            // Increment the ID for the next user
            nextUserId++;

            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Registration fail, please try again later!", "Uh-oh!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}


