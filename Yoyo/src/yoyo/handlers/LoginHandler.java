package yoyo.handlers;

import javax.swing.JOptionPane;
import yoyo.actors.Administrator;
import yoyo.actors.Customer;
import yoyo.actors.Officer;
import yoyo.actors.SalesPerson;

public class LoginHandler extends AccountHandler{
    private String userLoginInput;
    private String userPasswordInput;

    @Override
    public yoyo.actors.User Check(){
        for (String[] userValues : userInfo) {
            if ((userValues[3].equals(userLoginInput) || userValues[5].equals(userLoginInput)) && userValues[2].equals(userPasswordInput)) {

                yoyo.actors.User user = null;
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

    public void setUserLoginInput(String userLoginInput) {
        this.userLoginInput = userLoginInput;
    }

    public void setUserPasswordInput(String userPasswordInput) {
        this.userPasswordInput = userPasswordInput;
    }
    
    private void setLoginProperties(yoyo.actors.User user, String[] userValues) {
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