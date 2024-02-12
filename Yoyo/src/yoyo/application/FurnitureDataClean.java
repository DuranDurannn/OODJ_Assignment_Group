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
import java.util.HashSet;
import java.util.Set;

public class FurnitureDataClean {
    public static void main(String[] args) {
        String csvFile = "/Users/Eow/Downloads/Furniture Price Prediction.csv";
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

            // Create a set to track duplicate rows
            Set<String> uniqueRows = new HashSet<>();

            // Print and write headers
            String headerString = String.format("| %-20s | %-20s | %-20s |%n", headers[index0].trim(), headers[index1].trim(), headers[index6].trim());
            System.out.print(headerString);
            writer.write(headerString);
            System.out.println("|---------------------|---------------------|---------------------|");
            writer.write("|---------------------|---------------------|---------------------|%n");

            // Read the rest of the file and write data to the file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                // Check if the indices are within bounds for each row
                if (index0 < data.length && index1 < data.length && index6 < data.length) {
                    String row = String.format("| %-20s | %-20s | %-20s |%n", data[index0].trim(), data[index1].trim(), data[index6].trim());

                    // Check for duplicates
                    if (uniqueRows.add(row)) {
                        // Print only unique rows
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










                             


                             



