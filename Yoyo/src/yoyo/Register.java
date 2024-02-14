package yoyo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Register {
    private static int nextUserId; // Initialize the ID counter

    static {
        // Read each line to find the last used user ID
        try (BufferedReader reader = new BufferedReader(new FileReader("userRegistration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0) {
                    String userIdString = parts[0];
                    if (userIdString.startsWith("CS")) {
                        int userId = Integer.parseInt(userIdString.substring(2)); // Remove the "CS" prefix
                        nextUserId = Math.max(nextUserId, userId);
                    }
                }
            }
            // Increment the last ID read from the file
            nextUserId++;
        } catch (IOException e) {
            // Handle the exception (e.g., show an error message)
            e.printStackTrace();
        }
    }

    public static boolean registerUser(String username, String password, String confirmPassword, String email, String address, String phoneNumber, String gender) {
        // Validate if all fields are filled
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty() || address.isEmpty() || phoneNumber.isEmpty() || gender.equals("--OPTION--")) {
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
                
                if (email.equals(parts[4])){
                    JOptionPane.showMessageDialog(null, "Registration fail, eamil already used", "Uh-oh!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
            
        } catch (IOException | NumberFormatException e) {
            // Handle exceptions (e.g., file not found, invalid format)
            e.printStackTrace();
        }

        // Format the user ID with leading zeros and "CS" prefix (e.g., CS001, CS002, ...)
        String formattedUserId = "CS" + String.format("%03d", nextUserId);

        // Save the data to the text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userRegistration.txt", true))) {
            // Append the new user data to the file with the formatted ID
            writer.write(formattedUserId + "," + username + "," + password + "," + email + "," + address + "," + phoneNumber + "," + gender + "," + "C");
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







    
    

