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

    public static boolean registerUser(String username, String password, String confirmPassword, String email, String gender) {
        // Validate if all fields are filled
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || gender.equals("--OPTION--")) {
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
            // Append the new user data to the file with the formatted ID
            writer.write(formattedUserId + "," + username + "," + password + "," + email + "," + gender + "," + "customer");
            writer.newLine(); // Add a new line for the next entry
            System.out.println("Registration successful!");

            // Increment the ID for the next user
            incrementUserId();

            return true;
        } catch (IOException e) {
            // Handle the exception (e.g., show an error message)
            e.printStackTrace();
            return false;
        }
    }

    private static void incrementUserId() {
        nextUserId++;
    }
}







    
    

