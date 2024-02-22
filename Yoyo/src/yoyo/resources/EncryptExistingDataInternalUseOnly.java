package yoyo.resources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import yoyo.application.Encryption;

public class EncryptExistingDataInternalUseOnly {

    private static final String ENCRYPTION_KEY = "Your16CharKey123";

    public static void main(String[] args) {
        try {
            encryptAndWriteToFile("C001,DARREN,123,darren@gmail.com,Sabah,0165529979,Male");

        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Encryption error: " + e.getMessage());
        }
    }

    private static void encryptAndWriteToFile(String userData) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("userInfo.txt", true))) {
            try {
                String encryptedUserData = Encryption.encrypt(userData, ENCRYPTION_KEY);
                writer.write(encryptedUserData);
                writer.newLine();
            } catch (Exception e) {
            System.err.println("Encryption error: " + e.getMessage());
            }
        }
    }
}
