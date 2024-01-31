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

public class EmployeeRegister {

    private static int nextUserId; // Initialize the ID counter

    static {
        // Initialize the ID counter by reading the last used ID from the file
        nextUserId = readLastUserId();
    }

    private static int readLastUserId() {
        try (BufferedReader reader = new BufferedReader(new FileReader("userRegistration.txt"))) {
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
            System.out.println("Please fill in all the fields.");
            return false;
        }

        // Check if passwords match
        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please re-enter.");
            return false;
        }

        // Format the user ID with leading zeros (e.g., 001, 002, ...)
        String formattedUserId = String.format("%03d", nextUserId);

        // Save the data to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userRegistration.txt", true))) {
            // Append the new user data to the file with the formatted ID and role
            writer.write(formattedUserId + "," + username + "," + password + "," + email + "," + gender + "," + role);
            writer.newLine(); // Add a new line for the next entry
            System.out.println("Registration successful!");

            // Increment the ID for the next user
            nextUserId++;

            return true;
        } catch (IOException e) {
            // Handle the exception (e.g., show an error message)
            e.printStackTrace();
            return false;
        }
    }

    // Other methods, if needed

  
}


