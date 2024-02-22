package yoyo.application;

import yoyo.actors.Administrator;
import yoyo.actors.Customer;
import yoyo.actors.Officer;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import yoyo.actors.SalesPerson;
import yoyo.actors.User;

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

                User user = null;
                char firstLetter = userValues[0].charAt(0);
                switch (firstLetter) {
                    case 'A' -> {
                        user = new Administrator();
                        setProperties(user, userValues);
                    }
                    case 'O' -> {
                        user = new Officer();
                        setProperties(user, userValues);
                    }
                    case 'C' -> {
                        user = new Customer();
                        setProperties(user, userValues);
                    }
                    case 'S' -> {
                        user = new SalesPerson();
                        setProperties(user, userValues);
                    }
                    default -> {
                        System.err.println("Warning: Invalid access level derived for ID: " + userValues[0]);
                        return null;
                    }
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

    private void setProperties(User user, String[] userValues) {
        user.setID(userValues[0]);
        user.setUsername(userValues[1]);
        user.setPassword(userValues[2]);
        user.setEmail(userValues[3]);
        user.setAddress(userValues[4]);
        user.setPhoneNumber(userValues[5]);
        user.setGender(userValues[6]);
        user.setProfileLink(userValues[7]);
    }
}
