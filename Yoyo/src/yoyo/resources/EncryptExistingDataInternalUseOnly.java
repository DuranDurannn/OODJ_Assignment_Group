package yoyo.resources;

import java.io.IOException;
import java.util.ArrayList;
import yoyo.handlers.SecureFileHandler;

public class EncryptExistingDataInternalUseOnly {
    public static void main(String[] args) {
        try {
            SecureFileHandler secureFileHandler = new SecureFileHandler();
            secureFileHandler.setFilePath("userInfo.txt");

            // Encrypt and append the line to the file
            secureFileHandler.appendEncryptedLine("C001!DARREN!123!darren@gmail.com!Sabah!0165529979!Male!https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3_74Xvjek9I_SygCJ5IaAiBBsUMDar6wEQt3C66cKug&s");

            // Reading and decrypting lines from the file
            ArrayList<String[]> decryptedDataList = secureFileHandler.readAndDecryptLines(8);

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
