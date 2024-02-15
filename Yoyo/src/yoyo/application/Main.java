
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import yoyo.application.DashboardUI;


public class Main {
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel (new FlatIntelliJLaf()); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        new DashboardUI("argumentValue").setVisible(true);

    }
}


        
        
            
        
    
    

