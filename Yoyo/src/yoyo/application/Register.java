package yoyo.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Register {
    
    private static String filePath = "userInfo.txt";
    private static final String ENCRYPTION_KEY = "Your16CharKey123";
    
    private static ArrayList<User> userList = new ArrayList<>();
    
    private static int nextUserId;
    
    BufferedReader reader = null;
    {
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedInfo = Encryption.decrypt(line, ENCRYPTION_KEY);
                String[] tokens = decryptedInfo.split(",");

                if (tokens.length != 7) {
                    System.err.println("Warning: Line '" + line + "' has invalid format");
                    continue;
                }
                
                User user = new User(); // Create User object based on matching data
                user.setID(tokens[0]);
                user.setUsername(tokens[1]);
                user.setPassword(tokens[2]);
                user.setEmail(tokens[3]);
                user.setAddress(tokens[4]);
                user.setPhoneNumber(tokens[5]);
                user.setGender(tokens[6]);
                
                if (tokens.length > 0) {
                    String userIdString = tokens[0];
                    if (userIdString.startsWith("C")) {
                        int userId = Integer.parseInt(userIdString.substring(2)); // Remove the "CS" prefix
                        nextUserId = Math.max(nextUserId, userId);
                    }
                }
            }
            
            nextUserId++;
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean registerUserInfo(String registerUsername, String registerAddress, String registerEmail, String registerPassword, String registerConfirmPassword) {
        // Validate that all fields are filled in
        if (registerUsername.isEmpty() || registerAddress.isEmpty() || registerEmail.isEmpty() || registerPassword.isEmpty() || registerConfirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(
                null, 
                "Please fill in all information to register. Please try again.", 
                "Register Failed", 
                JOptionPane.ERROR_MESSAGE,
                null
            );
            return false;
        }

        // Validate that password and confirm password match
        if (!registerPassword.equals(registerConfirmPassword)) {
            JOptionPane.showMessageDialog(
                null, 
                "Password does not match confirm password. Please try again.", 
                "Register Failed", 
                JOptionPane.ERROR_MESSAGE,
                null
            );
             return false;
        }
        
        //Check is the email taken or not
        for (User user : userList) {
            if (user.getEmail().equals(registerEmail)) {
                JOptionPane.showMessageDialog(
                    null, 
                    "Email already exists. Please use a different email address.", 
                    "Register Failed", 
                    JOptionPane.ERROR_MESSAGE,
                    null
                );
                return false;
            }
        }
        
        String formatedUserId = "C" + String.format("%03d", nextUserId);
        
        String newUser = formatedUserId + "," + registerUsername + "," + registerAddress + "," + registerEmail + "," + registerPassword;

        /* Encrypt user information
        String encryptedInfo;
        try {
            encryptedInfo = Encryption.encrypt(newUser, ENCRYPTION_KEY);
        } catch (Exception e) {
            e.printStackTrace(); // Handle encryption errors appropriately
            return false; // If encryption fails, return false
        }
        */

        // Perform the registration process here (e.g., write user information to a file or database)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(newUser); // Write encrypted user information
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace(); // Handle file writing errors appropriately
            return false; // If writing to file fails, return false
        }

        // If registration is successful, return true
        return true;
    }
}
