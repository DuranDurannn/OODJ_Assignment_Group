
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import yoyo.application.DashboardUI;
import yoyo.reports.ClosedSaleReport;
import yoyo.reports.WorkDoneReport;


public static void main(String args[]) {
        
    try {
        UIManager.setLookAndFeel (new FlatIntelliJLaf()); 
    } catch (Exception e) {
        e.printStackTrace();
    }

    new DashboardUI().setVisible(true);
        
}

        
        
            
        
    
    

