package yoyo.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Login {

    private String filePath = "userInfo.txt";
    private static final String ENCRYPTION_KEY = "Your16CharKey123";

    public User readUserInfo() throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter email or phone number: ");
            String emailOrPhone = scanner.nextLine();          

            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            BufferedReader reader = null;
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

                    if ((emailOrPhone.equals(tokens[3]) || emailOrPhone.equals(tokens[5])) && password.equals(tokens[2])) {
                        // Check if login value matches email or phone number
                        User user = new User(); // Create User object based on matching data
                        user.setID(tokens[0]);
                        user.setUsername(tokens[1]);
                        user.setPassword(tokens[2]);
                        user.setEmail(tokens[3]);
                        user.setAddress(tokens[4]);
                        user.setPhoneNumber(tokens[5]);
                        user.setGender(tokens[6]);

                        char firstLetter = user.getID().charAt(0);
                        switch (firstLetter) {
                            case 'A' -> user.setAccessLevel("admin");
                            case 'M' -> user.setAccessLevel("manager");
                            case 'C' -> user.setAccessLevel("customer");
                            case 'S' -> user.setAccessLevel("salesperson");
                            default -> {
                                System.err.println("Warning: Invalid access level derived for ID: " + user.getID());
                                return null;
                            }
                        }

                        return user;
                    } else {
                        JOptionPane.showMessageDialog(
                            null, 
                            "Invalid email, phone number, or password. Please try again or register for a new account.", 
                            "Login Failed", 
                            JOptionPane.ERROR_MESSAGE,
                            null
                        );
                        
                        break; // IMPLEMENT ERROR HANDELING HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
                    }
                }
            } catch (IOException e) {
                throw e; // Re-throw IOException for proper handling
            } catch (Exception e) {
                System.err.println("Encryption error: " + e.getMessage());
                return null;
            }
        } catch (Exception e) {
        System.err.println("Encryption error: " + e.getMessage());
        return null;
        }
    return null;
    }
}