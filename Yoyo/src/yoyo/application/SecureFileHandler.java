package yoyo.application;

import java.io.*;
import java.util.ArrayList;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class SecureFileHandler {
    
    private String filePath;
    private String secretKey = "Your16CharKey123";
    
    public ArrayList<String[]> readAndDecryptLines(int numTokens) throws IOException {
        ArrayList<String[]> decryptedDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    byte[] encryptedBytes = Base64.getDecoder().decode(line);

                    byte[] ivBytes = new byte[16];
                    byte[] encryptedUserData = new byte[encryptedBytes.length - ivBytes.length];
                    System.arraycopy(encryptedBytes, 0, ivBytes, 0, ivBytes.length);
                    System.arraycopy(encryptedBytes, ivBytes.length, encryptedUserData, 0, encryptedUserData.length);

                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    SecretKey keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
                    IvParameterSpec iv = new IvParameterSpec(ivBytes);
                    cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);

                    byte[] decryptedDataBytes = cipher.doFinal(encryptedUserData);
                    String decryptedLine = new String(decryptedDataBytes);

                    // Split and validate tokens
                    String[] tokens = decryptedLine.split("!");
                    if (tokens.length == numTokens) {
                        decryptedDataList.add(tokens);
                    } else {
                        throw new IOException("Line has an invalid format: " + line);
                    }
                } catch (Exception e) {
                    throw new IOException("Error decrypting line: " + e.getMessage(), e);
                }
            }
        }
        return decryptedDataList;
    }

    public void appendEncryptedLine(String userData) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                SecretKey keySpec = new SecretKeySpec(secretKey.getBytes(), "AES");
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);

                byte[] ivBytes = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();

                byte[] encryptedData = cipher.doFinal(userData.getBytes());

                byte[] result = new byte[ivBytes.length + encryptedData.length];
                System.arraycopy(ivBytes, 0, result, 0, ivBytes.length);
                System.arraycopy(encryptedData, 0, result, ivBytes.length, encryptedData.length);

                String encodedResult = Base64.getEncoder().encodeToString(result);

                writer.write(encodedResult);
                writer.newLine();
            } catch (Exception e) {
                throw new IOException("Encryption and write to file error: " + e.getMessage(), e);
            }
        }
    }
    
    public void setFilePath(String filePath) {
    this.filePath = filePath;
    }

    // Add this setter method for secretKey
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}