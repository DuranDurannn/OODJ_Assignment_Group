package yoyo.application;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {
    
    public static void main(String args[]) throws IOException {
        try {
            UIManager.setLookAndFeel (new FlatIntelliJLaf());           
            new LoginRegisterUI().setVisible(true);         

            
        } catch (UnsupportedLookAndFeelException e) {
            //ERROR HANDLING HEREEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
        }  
    }
}
    