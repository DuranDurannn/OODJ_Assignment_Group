package yoyo.application;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
    public static void main(String args[]) throws IOException {

        String var1 = "darren@gmail.com";
        String var2 = "123";
        Login login = new Login();

        try {
            UIManager.setLookAndFeel (new FlatIntelliJLaf());
            
            //new LoginRegisterUI().setVisible(true);
            
            
            FileHandler fileHandler = new FileHandler("userInfo.txt", 7, "Your16CharKey123");
            ArrayList<String[]> tempDecryptedUserInfoLine = fileHandler.readLinesOneByOne();
            User verifiedUser = login.processUserInfo(tempDecryptedUserInfoLine, var1, var2);
            
            if (verifiedUser != null) {
                System.out.println("User information:");
                System.out.println("ID: " + verifiedUser.getID());
                System.out.println("Username: " + verifiedUser.getUsername());
                System.out.println("Password: " + verifiedUser.getPassword());
                System.out.println("Email: " + verifiedUser.getEmail());
                System.out.println("Address: " + verifiedUser.getAddress());
                System.out.println("Phone Number: " + verifiedUser.getPhoneNumber());
                System.out.println("Gender: " + verifiedUser.getGender());
                System.out.println("Access Level: " + verifiedUser.getAccessLevel());
            } else {
                System.out.println("User not found or invalid credentials.");
            }
            
            //new Dashboard(user.getAccessLevel()).setVisible(true); 
            
        } catch (UnsupportedLookAndFeelException e) {
            //ERROR HANDLING HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        }  
    }
}
    