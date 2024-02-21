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

    public void writeDataLineByLine(ArrayList<String[]> data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false)); // Overwrite

        for (String[] lineData : data) {
            StringBuilder line = new StringBuilder();
            for (String token : lineData) {
                line.append(token).append(",");
            }
            // Remove the trailing comma
            line.setLength(line.length() - 1);

            try {
                // Encrypt the line
                String encryptedLine = Encryption.encrypt(line.toString(), secretKey);
                writer.write(encryptedLine);
                writer.newLine();
                writer.flush();
            } catch (Exception e) {
                System.err.println("Error encrypting and writing line: " + e.getMessage());
            }
        }

        writer.close();
    }
}
