package yoyo.application;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Register {

    private ArrayList<String[]> userInfo;
    private String userUsernameInput;
    private String userGenderInput;
    private String userEmailInput;
    private String userPhoneInput;
    private String userAddressInput;
    private String userRegisterPasswordInput;
    private String userConfirmPasswordInput;
    private String formatedUserId = "C001";
    private static int nextUserId;

    public void setUserInfo(ArrayList<String[]> userInfo) {
        this.userInfo = userInfo;
    }

    public void setUserUsernameInput(String userUsernameInput) {
        this.userUsernameInput = userUsernameInput;
    }

    public void setUserGenderInput(String userGenderInput) {
        this.userGenderInput = userGenderInput.toLowerCase();
    }

    public void setUserEmailInput(String userEmailInput) {
        this.userEmailInput = userEmailInput;
    }

    public void setUserPhoneInput(String userPhoneInput) {
        this.userPhoneInput = userPhoneInput;
    }

    public void setUserAddressInput(String userAddressInput) {
        this.userAddressInput = userAddressInput;
    }

    public void setUserRegisterPasswordInput(String userPasswordInput) {
        this.userRegisterPasswordInput = userPasswordInput;
    }

    public void setUserConfirmPasswordInput(String userConfirmPasswordInput) {
        this.userConfirmPasswordInput = userConfirmPasswordInput;
    }

    public User registerCheck() {
        
        User registeringUser = new User();
        
        if (userUsernameInput.isEmpty() || userGenderInput.isEmpty() ||
            userEmailInput.isEmpty() || userPhoneInput.isEmpty() ||
            userAddressInput.isEmpty() || userRegisterPasswordInput.isEmpty() ||
            userConfirmPasswordInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (userUsernameInput.contains("!") || userGenderInput.contains("!") ||
            userEmailInput.contains("!") || userPhoneInput.contains("!") ||
            userAddressInput.contains("!") || userRegisterPasswordInput.contains("!") ||
            userConfirmPasswordInput.contains("!")) {
            JOptionPane.showMessageDialog(null, "Exclaimation marks are not allowed in any input field.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!userGenderInput.equals("male") && !userGenderInput.equals("female")) {
            JOptionPane.showMessageDialog(null, "Invalid gender input. Please enter 'male' or 'female'.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!userRegisterPasswordInput.equals(userConfirmPasswordInput)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match. Please try again.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!userEmailInput.contains("@")) {
            JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!userPhoneInput.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Please enter only numeric digits.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        if (!userAddressInput.matches(
                "^" +                                   // Start of string
                "\\d+\\s+[\\w\\s]+," +                   // House number (digits) followed by space, Street name (words and spaces) followed by a comma
                "\\s+[\\w\\s]+," +                      // Area/locality (words and spaces) followed by a comma
                "\\s+\\d{5}\\s+[\\w\\s]+," +            // Postal code (5 digits) followed by space, City/state/country (words and spaces) followed by a comma
                "\\s+[\\w\\s]+" +                       // Additional city/state/country (words and spaces)
                "$"                                     // End of string
        )) {
            JOptionPane.showMessageDialog(
                null, 
                "Invalid address format. Please follow the example: 15 Persiaran Gurney, Georgetown, 10250 Pulau Pinang, Malaysia", 
                "Registration Error", 
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        for (String[] userValues : userInfo) {

            if (userValues[3].equals(userEmailInput) || userValues[5].equals(userPhoneInput)) {
                JOptionPane.showMessageDialog(null, "Email or phone already exists. Please choose a different one.", "Registration Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            if (userValues.length > 0 && userValues[0].startsWith("C")) {
                int userId = Integer.parseInt(userValues[0].substring(1));
                nextUserId = Math.max(nextUserId, userId);
            }                  
        }
        nextUserId++;
        
        formatedUserId = "C" + String.format("%03d", nextUserId);

        registeringUser.setID(formatedUserId);
        registeringUser.setUsername(userUsernameInput);
        registeringUser.setPassword(userRegisterPasswordInput);
        registeringUser.setEmail(userEmailInput);
        registeringUser.setAddress(userAddressInput);
        registeringUser.setPhoneNumber(userPhoneInput);
        registeringUser.setGender(userGenderInput);
        registeringUser.setProfileLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3_74Xvjek9I_SygCJ5IaAiBBsUMDar6wEQt3C66cKug&s"); 

        char firstLetter = registeringUser.getID().charAt(0);
        switch (firstLetter) {
            case 'A' -> registeringUser.setAccessLevel("admin");
            case 'M' -> registeringUser.setAccessLevel("manager");
            case 'C' -> registeringUser.setAccessLevel("customer");
            case 'S' -> registeringUser.setAccessLevel("salesperson");
            default -> System.err.println("Warning: Invalid access level derived for ID: " + registeringUser.getID());
        }
        SecureFileHandler fileHandler = new SecureFileHandler();
        fileHandler.setFilePath("userInfo.txt");

        String dataLine = registeringUser.getID() + "!" + registeringUser.getUsername() + "!"
                       + registeringUser.getPassword() + "!" + registeringUser.getEmail() + "!"
                       + registeringUser.getAddress() + "!" + registeringUser.getPhoneNumber() + "!"
                       + registeringUser.getGender() + "!" + registeringUser.getProfileLink();

        try {
            fileHandler.appendEncryptedLine(dataLine);
            
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Registration successful!");
        return registeringUser;
    }
}
