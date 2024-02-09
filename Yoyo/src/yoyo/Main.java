/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yoyo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Eow
 */
public class Main {
     public static void main(String args[]) {
        LoginUI LoginFrame = new LoginUI();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);

        // Call a method to open and read the user registration file
        readUserRegistrationFile();
    }

    private static void readUserRegistrationFile() {
        // Specify the file path
        String filePath = "userRegistration.txt";
        

        // Open and read the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Display each line (user entry) in the console
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle the exception (e.g., show an error message)
            e.printStackTrace();
        }
    }
}

        
        
            
        
    
    

