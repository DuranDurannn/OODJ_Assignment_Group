import com.formdev.flatlaf.FlatIntelliJLaf;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import yoyo.application.DashboardUI;



public static void main(String args[]) throws IOException {

    Login userInfo = new Login();  

    try {
        UIManager.setLookAndFeel (new FlatIntelliJLaf());
        userInfo.readUserInfo();
    } catch (UnsupportedLookAndFeelException e) {
    }

    new DashboardUI("administrator").setVisible(true); // shows adminUI (here for testing only, remove in final application)
    new DashboardUI("officer").setVisible(true); // shows officerUI (here for testing only, remove in final application)
    new DashboardUI("salesperson").setVisible(true); // shows salespersonUI (here for testing only, remove in final application)
       
}

        
        
            
        
    
    

