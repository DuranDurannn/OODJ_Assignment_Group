
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import yoyo.application.DashboardUI;


public static void main(String args[]) {
        
    try {
        UIManager.setLookAndFeel (new FlatIntelliJLaf()); 
    } catch (Exception e) {
        e.printStackTrace();
    }

    new DashboardUI("administrator").setVisible(true); // shows adminUI (here for testing only, remove in final application)
    new DashboardUI("officer").setVisible(true); // shows officerUI (here for testing only, remove in final application)
    new DashboardUI("salesperson").setVisible(true); // shows salespersonUI (here for testing only, remove in final application)
       
}

        
        
            
        
    
    

