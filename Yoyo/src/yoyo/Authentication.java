/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yoyo;

/**
 *
 * @author Eow
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Authentication {

    public static String authenticateUser(String userEmail, String userPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userRegistration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into email, password and status
                String[] userData = line.split(",");
                String storedEmail = userData[3];
                String storedPassword = userData[2];
                String storedStatus = userData[5];

                // Check if entered email and password match the stored values
                if (userEmail.equals(storedEmail) && userPassword.equals(storedPassword) && storedStatus.equals("C")) {
                    return "C"; // Authentication successful
                }
            }   
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "None"; // Authentication failed
    }
    
    public static String autheticateEmployee(String userEmail, String userPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("employeeRegistration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into email, password and status
                String[] userData = line.split(",");
                String storedEmail = userData[3];
                String storedPassword = userData[2];
                String storedStatus = userData[5];

                // Check if entered email and password match the stored values
                if (userEmail.equals(storedEmail) && userPassword.equals(storedPassword) && storedStatus.equals("S")){
                    return "S";
                } else if (userEmail.equals(storedEmail) && userPassword.equals(storedPassword) && storedStatus.equals("O")){
                    return "O";
                } else if (userEmail.equals(storedEmail) && userPassword.equals(storedPassword) && storedStatus.equals("A")){
                    return "A";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "None"; // Authentication failed
    }
}

