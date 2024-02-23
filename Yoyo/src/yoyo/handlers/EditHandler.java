package yoyo.handlers;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import yoyo.handlers.AccountHandler;
import yoyo.handlers.SecureFileHandler;
import yoyo.resources.Validator;

public class EditHandler extends AccountHandler{
    private String userEditUsernameInput;
    private String userEditGenderInput;
    private String userEditEmailInput;
    private String userEditPhoneInput;
    private String userEditAddressInput;
    private String userEditPasswordInput;
    private String userEditConfirmPasswordInput;
    private String userEditProfileInput;
    private yoyo.actors.User editingUser = null;
    
    @Override
    public yoyo.actors.User Check() {
        
        boolean found = false;
        
        // Use Validator class for all validations
        if (!Validator.validateUsername(userEditUsernameInput)) {
            return null;
        }
        if (!Validator.validateGender(userEditGenderInput)) {
            return null;
        }
        if (!Validator.validateEmail(userEditEmailInput)) {
            return null;
        }
        if (!Validator.validatePhone(userEditPhoneInput)) {
            return null;
        }
        if (!Validator.validateAddress(userEditAddressInput)) {
            return null;
        }
        if (!Validator.validatePassword(userEditPasswordInput, userEditConfirmPasswordInput)) {
            return null;
        }
        if (!Validator.validateUniqueNotCurrentUser(userEditEmailInput, userEditPhoneInput, userInfo, editingUser)) {
            return null;
        }      
        
        setEditProperties(editingUser);
        
        for (int i = 0; i < userInfo.size(); i++) {
            
            String[] userValues = userInfo.get(i);
            editingUser.setID(userValues[0]);
            
            if (userValues[0].equals(editingUser.getID()) && userValues[2].equals(userEditPasswordInput)) {
                found = true;
                setEditProperties(editingUser);         
                userInfo.set(i, new String[]{editingUser.getID(), editingUser.getUsername(), editingUser.getPassword(), editingUser.getEmail(), editingUser.getAddress(), editingUser.getPhoneNumber(), editingUser.getGender(), editingUser.getProfileLink()});

                break;
            }
        }        

        if (!found) {
            JOptionPane.showMessageDialog(null, "User ID or current password is incorrect.", "Edit Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("edutUserID: " + editingUser.getID());
            return null;
        }
        
        String dataLine = editingUser.getID() + editingUser.getUsername()
                + editingUser.getPassword() + editingUser.getEmail()
                + editingUser.getAddress() + editingUser.getPhoneNumber()
                + editingUser.getGender() + editingUser.getProfileLink();     
        
        SecureFileHandler fileHandler = new SecureFileHandler();
        fileHandler.setFilePath("userInfo.txt");
        
        /*try {
            fileHandler.replaceEncryptedLine(dataLine, condition);     
        } catch (IOException e) {
            System.err.println("Error writing data to file: " + e.getMessage());
        }*/

        JOptionPane.showMessageDialog(null, "Edit successful!");
        return editingUser;
    }
    
    public void setUserInfo(ArrayList<String[]> userInfo) {
        this.userInfo = userInfo;
    }
    
    public void setEditingUser(yoyo.actors.User user) {
        this.editingUser = user;
    }
    
    public void setUserEditUsernameInput(String userEditUsernameInput) {
        this.userEditUsernameInput = userEditUsernameInput;
    }

    public void setUserEditGenderInput(String userEditGenderInput) {
        this.userEditGenderInput = userEditGenderInput.toLowerCase();
    }

    public void setUserEditEmailInput(String userEditEmailInput) {
        this.userEditEmailInput = userEditEmailInput;
    }

    public void setUserEditPhoneInput(String userEditPhoneInput) {
        this.userEditPhoneInput = userEditPhoneInput;
    }

    public void setUserEditAddressInput(String userEditAddressInput) {
        this.userEditAddressInput = userEditAddressInput;
    }

    public void setUserEditPasswordInput(String userEditPasswordInput) {
        this.userEditPasswordInput = userEditPasswordInput;
    }

    public void setUserEditConfirmPasswordInput(String userEditConfirmPasswordInput) {
        this.userEditConfirmPasswordInput = userEditConfirmPasswordInput;
    } 
    
    public void setUserEditProfileInput(String userEditProfileInput) {
        this.userEditProfileInput = userEditProfileInput;
    } 
    
    private void setEditProperties(yoyo.actors.User user) {
        user.setID(editingUser.getID());
        user.setUsername(userEditUsernameInput);
        user.setPassword(userEditPasswordInput);
        user.setEmail(userEditEmailInput);
        user.setAddress(userEditAddressInput);
        user.setPhoneNumber(userEditPhoneInput);
        user.setGender(userEditGenderInput);
        user.setProfileLink(userEditProfileInput);
    } 
}