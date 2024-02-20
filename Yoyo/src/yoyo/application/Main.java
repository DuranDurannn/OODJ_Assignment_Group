package yoyo.application;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
<<<<<<< HEAD
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel (new FlatIntelliJLaf()); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        new DashboardUI("argumentValue").setVisible(true);

    }
}


        
        
            
        
    
    

=======
    public static void main(String args[]) throws IOException {

        Login userInfo = new Login();
        User user = null;

        try {
            UIManager.setLookAndFeel (new FlatIntelliJLaf());
            new LoginRegisterUI().setVisible(true);
            user = userInfo.readUserInfo();
            new DashboardUI(user.getAccessLevel()).setVisible(true); 
        } catch (UnsupportedLookAndFeelException e) {
            //ERROR HANDLING HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        }  
    }
}
>>>>>>> 0e49e3262e03ab220b6ab14de529d25f93ef3190
