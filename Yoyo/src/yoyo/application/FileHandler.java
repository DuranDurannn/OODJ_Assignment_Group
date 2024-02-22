package yoyo.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    private String filePath;
    private int numTokens;
    private String secretKey; // Store the secret key securely

    public FileHandler(String filePath, int numTokens, String secretKey) {
        this.filePath = filePath;
        this.numTokens = numTokens;
        this.secretKey = secretKey; // Validate and handle key securely
    }

    public ArrayList<String[]> readLinesOneByOne() throws IOException {
        ArrayList<String[]> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            try {
                // Decrypt the line
                String decryptedLine = Encryption.decrypt(line, secretKey);

                // Split and validate tokens
                String[] tokens = decryptedLine.split(",");
                if (tokens.length == numTokens) {
                    data.add(tokens);
                } else {
                    System.err.println("Warning: Line '" + line + "' has invalid format");
                }
            } catch (Exception e) {
                System.err.println("Error decrypting line: " + e.getMessage());
            }
        }

        reader.close();
        return data;
    }

    public void appendDataLineByLine(String userData) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            try {
                String encryptedLine = Encryption.encrypt(userData, secretKey);
                writer.write(encryptedLine);

                writer.newLine();
            } catch (Exception e) {
                System.err.println("Encryption error: " + e.getMessage());
            } finally {
                writer.close(); // Ensure writer is always closed
            }
        }   
    }
}