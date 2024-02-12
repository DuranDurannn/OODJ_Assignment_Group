/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yoyo;

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

public class Register {

    private static int nextUserId; // Initialize the ID counter

    static {
        // Initialize nextUserId by reading the last ID from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("userRegistration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    int userId = Integer.parseInt(parts[0]);
                    nextUserId = Math.max(nextUserId, userId);
                }
            }
            // Increment the last ID read from the file
            nextUserId++;
        } catch (IOException e) {
            // Handle the exception (e.g., show an error message)
            e.printStackTrace();
        }
    }

    public static boolean registerUser(String username, String password, String confirmPassword, String email, String address, String gender) {
        // Validate if all fields are filled
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || address.isEmpty() || gender.equals("--OPTION--")) {
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userRegistration.txt", true))) {
            // Append the new user data to the file with the formatted ID
            writer.write(formattedUserId + "," + username + "," + password + "," + email + "," + address + "," + gender + "," + "customer");
            writer.newLine(); // Add a new line for the next entry
            JOptionPane.showMessageDialog(null, "Registration Successfull!");

            // Increment the ID for the next user
            nextUserId++;

            return true;
        } catch (IOException e) {
            // Handle the exception (e.g., show an error message)
            JOptionPane.showMessageDialog(null, "Registration fail, please try again later!", "Uh-oh!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}







    
    

