package yoyo.application;

import yoyo.actors.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import yoyo.actors.Administrator;
import yoyo.actors.Customer;
import yoyo.actors.Officer;
import yoyo.actors.SalesPerson;

public class AccountHandler {

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
    private String userLoginInput;
    private String userPasswordInput;

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
    
    public void setUserLoginInput(String userLoginInput) {
        this.userLoginInput = userLoginInput;
    }

    public void setUserPasswordInput(String userPasswordInput) {
        this.userPasswordInput = userPasswordInput;
    }
    public User registerCheck() {

        User user = null;

        // Use Validator class for all validations
        if (!Validator.validateUsername(userUsernameInput)) {
            return null;
        }
        if (!Validator.validateGender(userGenderInput)) {
            return null;
        }
        if (!Validator.validateEmail(userEmailInput)) {
            return null;
        }
        if (!Validator.validatePhone(userPhoneInput)) {
            return null;
        }
        if (!Validator.validateAddress(userAddressInput)) {
            return null;
        }
        if (!Validator.validatePassword(userRegisterPasswordInput, userConfirmPasswordInput)) {
            return null;
        }
        if (!Validator.validateUniqueUser(userEmailInput, userPhoneInput, userInfo)) {
            return null;
        }

        for (String[] userValues : userInfo) {
            if (userValues.length > 0 && userValues[0].startsWith("C")) {
                int userId = Integer.parseInt(userValues[0].substring(1));
                nextUserId = Math.max(nextUserId, userId);
            }
        }

        Customer customer = new Customer();

        nextUserId++;
        formatedUserId = "C" + String.format("%03d", nextUserId);

        setRegisterProperties(customer);
        
        SecureFileHandler fileHandler = new SecureFileHandler();
        fileHandler.setFilePath("userInfo.txt");

        String dataLine = customer.getID() + "!" + customer.getUsername() + "!"
                + customer.getPassword() + "!" + customer.getEmail() + "!"
                + customer.getAddress() + "!" + customer.getPhoneNumber() + "!"
                + customer.getGender() + "!" + customer.getProfileLink();

        try {
            fileHandler.appendEncryptedLine(dataLine);
            
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Registration successful!");
        return customer;
    }
    
    private void setRegisterProperties(User user) {
    user.setID(formatedUserId);
    user.setUsername(userUsernameInput);
    user.setPassword(userRegisterPasswordInput);
    user.setEmail(userEmailInput);
    user.setAddress(userAddressInput);
    user.setPhoneNumber(userPhoneInput);
    user.setGender(userGenderInput);
    user.setProfileLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3_74Xvjek9I_SygCJ5IaAiBBsUMDar6wEQt3C66cKug&s");
    }
    
    public User loginCheck() {
        for (String[] userValues : userInfo) {
            if ((userValues[3].equals(userLoginInput) || userValues[5].equals(userLoginInput)) && userValues[2].equals(userPasswordInput)) {

                User user = null;
                char firstLetter = userValues[0].charAt(0);
                switch (firstLetter) {
                    case 'A' -> {
                        user = new Administrator();
                        setLoginProperties(user, userValues);
                    }
                    case 'O' -> {
                        user = new Officer();
                        setLoginProperties(user, userValues);
                    }
                    case 'C' -> {
                        user = new Customer();
                        setLoginProperties(user, userValues);
                    }
                    case 'S' -> {
                        user = new SalesPerson();
                        setLoginProperties(user, userValues);
                    }
                    default -> {
                        System.err.println("Warning: Invalid access level derived for ID: " + userValues[0]);
                        return null;
                    }
                }                
                return user;
            }
        }

        JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
        return null;
    }
        
    private void setLoginProperties(User user, String[] userValues) {
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
