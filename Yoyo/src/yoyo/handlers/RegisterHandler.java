package yoyo.handlers;

import java.io.IOException;
import javax.swing.JOptionPane;
import yoyo.actors.Customer;
import yoyo.resources.Validator;

public class RegisterHandler extends AccountHandler{
    private String userUsernameInput;
    private String userGenderInput;
    private String userEmailInput;
    private String userPhoneInput;
    private String userAddressInput;
    private String userRegisterPasswordInput;
    private String userConfirmPasswordInput;
    private String formatedUserId = "C001";
    private static int nextUserId;
    
    @Override
    public yoyo.actors.User Check() {

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
            fileHandler.appendEncrypted(dataLine);
            
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Registration successful!");
        return customer;
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
    
    private void setRegisterProperties(yoyo.actors.User user) {
        user.setID(formatedUserId);
        user.setUsername(userUsernameInput);
        user.setPassword(userRegisterPasswordInput);
        user.setEmail(userEmailInput);
        user.setAddress(userAddressInput);
        user.setPhoneNumber(userPhoneInput);
        user.setGender(userGenderInput);
        user.setProfileLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3_74Xvjek9I_SygCJ5IaAiBBsUMDar6wEQt3C66cKug&s");
    } 
}