package yoyo.application;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Login {

    private ArrayList<String[]> userInfo;
    private String userLoginInput;
    private String userPasswordInput;

    public void setUserInfo(ArrayList<String[]> userInfo) {
        this.userInfo = userInfo;
    }

    public void setUserLoginInput(String userLoginInput) {
        this.userLoginInput = userLoginInput;
    }

    public void setUserPasswordInput(String userPasswordInput) {
        this.userPasswordInput = userPasswordInput;
    }

    public User loginCheck() {

        for (String[] userValues : userInfo) {
            if ((userValues[3].equals(userLoginInput) || userValues[5].equals(userLoginInput)) && userValues[2].equals(userPasswordInput)) {
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
