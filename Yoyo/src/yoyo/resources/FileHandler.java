package yoyo.resources;

import java.io.IOException;
import java.util.ArrayList;

public interface FileHandler {
    ArrayList<String[]> readAndDecryptLines(String filePath, int numTokens, String secretKey) throws IOException;
    void appendEncryptedLine(String filePath, String userData, String secretKey) throws IOException;
}
