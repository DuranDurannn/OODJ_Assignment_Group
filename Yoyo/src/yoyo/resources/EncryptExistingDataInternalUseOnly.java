package yoyo.resources;

import java.io.IOException;
import java.util.ArrayList;
import yoyo.application.SecureFileHandler;

public class EncryptExistingDataInternalUseOnly {
    private static final String ENCRYPTION_KEY = "Your16CharKey123";

    public static void main(String[] args) {
        try {
            SecureFileHandler secureFileHandler = new SecureFileHandler();

            // Encrypt and append the line to the file
            secureFileHandler.appendEncryptedLine("userInfo.txt", "C001!DARREN!123!darren@gmail.com!Sabah!0165529979!Male!https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3_74Xvjek9I_SygCJ5IaAiBBsUMDar6wEQt3C66cKug&s", ENCRYPTION_KEY);

            // Reading and decrypting lines from the file
            ArrayList<String[]> decryptedDataList = secureFileHandler.readAndDecryptLines("userInfo.txt", 8, ENCRYPTION_KEY);

            // Printing the decrypted data
            for (String[] tokens : decryptedDataList) {
                for (String token : tokens) {
                    System.out.print(token + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error writing to/reading from the file: " + e.getMessage());
        }
    }
}
