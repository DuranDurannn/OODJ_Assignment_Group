package yoyo.application;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Validator {

    public static boolean validateUsername(String username) {
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (username.contains("!")) {
            JOptionPane.showMessageDialog(null, "Username cannot contain exclamation marks.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validateGender(String gender) {
        if (gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gender cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"))) {
            JOptionPane.showMessageDialog(null, "Invalid gender input. Please enter 'male' or 'female'.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validateEmail(String email) {
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Email address cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!email.contains("@")) {
            JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validatePhone(String phone) {
        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Phone number cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!phone.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter only numeric digits.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validateAddress(String address) {
        if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Address cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!address.matches(
            "^" +                                   // Start of string
            "\\d+\\s+[\\w\\s]+," +                  // House number (digits) followed by space, Street name (words and spaces) followed by a comma
            "\\s+[\\w\\s]+," +                      // Area/locality (words and spaces) followed by a comma
            "\\s+\\d{5}\\s+[\\w\\s]+," +            // Postal code (5 digits) followed by space, City/state/country (words and spaces) followed by a comma
            "\\s+[\\w\\s]+" +                       // Additional city/state/country (words and spaces)
            "$"                                     // End of string
        )) {
            JOptionPane.showMessageDialog(null, "Invalid address format. Please follow the example: 15 Persiaran Gurney, Georgetown, 10250 Pulau Pinang, Malaysia", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validatePassword(String password, String confirmPassword) {
        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (password.contains("!")) {
            JOptionPane.showMessageDialog(null, "Password cannot contain exclamation marks.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validateUniqueUser(String email, String phone, ArrayList<String[]> userInfo) {
        for (String[] userValues : userInfo) {
            if (userValues[3].equals(email) || userValues[5].equals(phone)) {
                JOptionPane.showMessageDialog(null, "Email or phone already exists. Please choose a different one.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }
}
