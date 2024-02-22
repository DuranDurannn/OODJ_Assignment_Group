package yoyo.application;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Login {

    public User processUserInfo(ArrayList<String[]> userInfo, String userLoginInput, String userPasswordInput) {
        for (String[] userValues : userInfo) {
            // Assuming columns 3 and 5 contain email and phone number respectively
            if ((userValues[3].equals(userLoginInput) || userValues[5].equals(userLoginInput)) && userValues[2].equals(userPasswordInput)) {
                // Match found!
                User user = new User();
                user.setID(userValues[0]);
                user.setUsername(userValues[1]);
                user.setPassword(userValues[2]); // Assuming password can be stored in plain text, update if needed
                user.setEmail(userValues[3]);
                user.setAddress(userValues[4]);
                user.setPhoneNumber(userValues[5]);
                user.setGender(userValues[6]);

                char firstLetter = user.getID().charAt(0);
                switch (firstLetter) {
                    case 'A' -> user.setAccessLevel("admin");
                    case 'M' -> user.setAccessLevel("manager");
                    case 'C' -> user.setAccessLevel("customer");
                    case 'S' -> user.setAccessLevel("salesperson");
                    default -> System.err.println("Warning: Invalid access level derived for ID: " + user.getID());
                }

                return user;
            }
        }

        // No match found
        JOptionPane.showMessageDialog(null,
                "Invalid credentials. Please try again.",
                "Login Failed",
                JOptionPane.ERROR_MESSAGE,
                null);

        return null;
    }
}
