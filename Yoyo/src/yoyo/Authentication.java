package yoyo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Authentication {

    public static String authenticateUser(String userEmail, String userPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userRegistration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into email, password and status
                String[] userData = line.split(",");
                String storedUserID = userData[0];
                String storedUsername = userData[1];
                String storedPassword = userData[2];
                String storedEmail = userData[3];
                String storedStatus = userData[5];
                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("currentUser.txt"))) {
                    writer.write(storedUserID + "," + storedUsername + "," + storedPassword + "," + storedEmail + "," + storedStatus);
                }

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
    
    public static String autheticateEmployee(String userEmail, String userPassword) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("employeeRegistration.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into email, password and status
                String[] userData = line.split(",");
                String storedUserID = userData[0];
                String storedUsername = userData[1];
                String storedPassword = userData[2];
                String storedEmail = userData[3];
                String storedGender = userData[4];
                String storedStatus = userData[5];
                
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("currentUser.txt"))) {
                    writer.write(storedUserID + "," + storedUsername + "," + storedPassword + "," + storedEmail + "," + storedGender + "," + storedStatus);
                }

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