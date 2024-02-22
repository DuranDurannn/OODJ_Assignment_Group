package yoyo.application;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditProfile {
    
    private ArrayList<String[]> userInfo;
    private String editUsernameInput;
    private String editGenderInput;
    private String editEmailInput;
    private String editPhoneInput;
    private String editAddressInput;
    private String editPasswordInput;
    private String editConfirmPasswordInput;
    
    public void setUserInfo(ArrayList<String[]> userInfo) {
        this.userInfo = userInfo;
    }
    
    public void setEditUsernameInput(String editUsernameInput) {
        this.editUsernameInput = editUsernameInput;
    }
    
    public void setEditGenderInput(String editGenderInput) {
        this.editGenderInput = editGenderInput.toLowerCase();
    }
    
    public void setEditEmailInput(String editEmailInput) {
        this.editEmailInput = editEmailInput;
    }
    
    public void setEditPhoneInput(String editPhoneInput) {
        this.editPhoneInput = editPhoneInput;
    }
    
    public void setEditAddressInput(String editAddressInput) {
        this.editAddressInput = editAddressInput;
    }
    
    public void setEditPasswordInput(String editPasswordInput) {
        this.editPasswordInput = editPasswordInput;
    }
    
    public void setEditConfirmPasswordInput(String editConfirmPasswordInput) {
        this.editConfirmPasswordInput = editConfirmPasswordInput;
    }
    
    public User editCheck() {
        
        User editUser = new User();
        
        if (editUsernameInput.isEmpty() || editGenderInput.isEmpty() ||
            editEmailInput.isEmpty() || editPhoneInput.isEmpty() ||
            editAddressInput.isEmpty() || editPasswordInput.isEmpty() ||
            editConfirmPasswordInput.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
        return null;
    }
}
