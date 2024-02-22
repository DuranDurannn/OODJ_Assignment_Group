/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yoyo.application;

/**
 *
 * @author Eow
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EncryptFile {

    public static void main(String[] args) throws Exception {
        // File path and secret key
        String filePath = "FurnitureDetailsTest.txt";
        String secretKey = "Your16CharKey123"; // Replace this with your actual secret key

        // Check if the file is already encrypted
        if (isFileEncrypted(filePath)) {
            JOptionPane.showMessageDialog(null, "File is already encrypted. Cannot encrypt again.");
            return;
        }

        try {
            // Read the lines from the file
            ArrayList<String> encryptedLines = new ArrayList<>();
            ArrayList<String> lines = readFileLines(filePath);

            // Encrypt each line
            for (String line : lines) {
                String encryptedLine = Encryption.encrypt(line, secretKey);
                encryptedLines.add(encryptedLine);
            }

            // Write the encrypted data back to the file
            writeFile(filePath, encryptedLines);

            System.out.println("File encrypted successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> readFileLines(String filePath) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void writeFile(String filePath, ArrayList<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static boolean isFileEncrypted(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // If any line is not encrypted (i.e., not Base64 encoded), return false
                if (!line.matches("^[A-Za-z0-9+/]*={0,2}$")) {
                    return false;
                }
            }
        }
        return true;
    }
}


