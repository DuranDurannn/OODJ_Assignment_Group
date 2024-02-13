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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Authentication {

    public static boolean authenticateUser(String userEmail, String userPassword) {
        try (BufferedReader reader = new BufferedReader(new FileReader("userRegistration.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("loggedInUser.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into email and password
                String[] userData = line.split(",");
                String storedEmail = userData[3].trim(); // Assuming email is at index 3
                String storedPassword = userData[2].trim(); // Assuming password is at index 2

                // Check if entered email and password match the stored values
                if (userEmail.equals(storedEmail) && userPassword.equals(storedPassword)) {
                    // Write the user's email to the loggedInUser.txt file
                    writer.write(userEmail);
                    return true; // Authentication successful
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Authentication failed
    }
}


