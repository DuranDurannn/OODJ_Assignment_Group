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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Furniture {
    public static void main(String[] args) {
        String csvFile = "Furniture Price Prediction.csv";
        String outputFile = "furnitureDetails.txt";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Read the header line
            String headerLine = br.readLine();
            String[] headers = headerLine.split(csvSplitBy);

            // Find the indices of the columns
            int index0 = 0; // Assuming index 0 corresponds to the first column you want
            int index1 = 1; // Assuming index 1 corresponds to the second column you want
            int index6 = 6; // Assuming index 6 corresponds to the seventh column you want

            // Check if the indices are within bounds
            if (index0 >= headers.length || index1 >= headers.length || index6 >= headers.length) {
                System.out.println("Invalid column indices.");
                return;
            }

            // Create a map to track unique furniture names and their corresponding IDs
            Map<String, Integer> furnitureMap = new HashMap<>();

            // Print and write headers including Furniture ID
            String headerString = String.format("Furniture ID,%s,%s,%s%n", headers[index0].trim(), headers[index1].trim(), headers[index6].trim());
            System.out.print(headerString);
            writer.write(headerString);

            // Read the rest of the file and write data to the file (up to 100 rows)
            int furnitureID = 1; // Start Furniture ID from 1
            for (int i = 0; i < 69 && (line = br.readLine()) != null; i++) {
                String[] data = line.split(csvSplitBy);

                // Check if the indices are within bounds for each row
                if (index0 < data.length && index1 < data.length && index6 < data.length) {
                    String furnitureName = data[index0].trim();

                    // Check if the furniture name is already in the map
                    if (!furnitureMap.containsKey(furnitureName)) {
                        // Add the furniture name to the map with its corresponding ID
                        furnitureMap.put(furnitureName, furnitureID);

                        // Write the row to the output file
                        String row = String.format("F%03d,%s,%s,%s%n", furnitureID++, furnitureName, data[index1].trim(), data[index6].trim());
                        System.out.print(row);
                        writer.write(row);
                    }
                } else {
                    System.out.println("Invalid column indices for row: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
