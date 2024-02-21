package yoyo.application;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class Encryption {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static String encrypt(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Generate a random IV (Initialization Vector)
        byte[] ivBytes = cipher.getParameters().getParameterSpec(IvParameterSpec.class).getIV();
        IvParameterSpec iv = new IvParameterSpec(ivBytes);

        // Encrypt the data
        byte[] encryptedData = cipher.doFinal(data.getBytes());

        // Prepend the IV to the encrypted data
        byte[] result = new byte[ivBytes.length + encryptedData.length];
        System.arraycopy(ivBytes, 0, result, 0, ivBytes.length);
        System.arraycopy(encryptedData, 0, result, ivBytes.length, encryptedData.length);

        return Base64.getEncoder().encodeToString(result);
    }

    public static String decrypt(String encryptedData, String key) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);

        // Separate IV and encrypted data
        byte[] ivBytes = new byte[16]; // Assuming a 16-byte IV for AES
        byte[] encryptedUserData = new byte[encryptedBytes.length - ivBytes.length];
        System.arraycopy(encryptedBytes, 0, ivBytes, 0, ivBytes.length);
        System.arraycopy(encryptedBytes, ivBytes.length, encryptedUserData, 0, encryptedUserData.length);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

        byte[] decryptedData = cipher.doFinal(encryptedUserData);
        return new String(decryptedData);
    }
}
