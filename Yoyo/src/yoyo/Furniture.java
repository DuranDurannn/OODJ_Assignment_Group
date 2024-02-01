/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yoyo;

/**
 *
 * @author Eow
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Furniture extends JFrame {

    private JTable table;

    public Furniture() {
        setTitle("Furniture Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Type");
        model.addColumn("Price");

        // Read data from CSV file and write to text file
        String csvFile = "/Users/Eow/Downloads/Furniture Price Prediction.csv";
        String outputFile = "furnitureDetails.txt";
        String line;
        String csvSplitBy = ",";
        Set<String> uniqueRows = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            // Read the header line
            String headerLine = br.readLine();
            String[] headers = headerLine.split(csvSplitBy);

            // Write header to text file
            String headerString = String.format("%-20s | %-20s | %-20s%n", headers[0].trim(), headers[1].trim(), headers[6].trim());
            writer.write(headerString);

            // Read the rest of the file and write data to the text file
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                // Check if the data meets the criteria
                if (data.length > 6 && data[6].matches("\\d+")) { // Price is an integer
                    if (data[1].trim().equalsIgnoreCase("Modern Home")) { // Type is "Modern Home"
                        String row = String.format("%-20s | %-20s | %-20s%n", data[0].trim(), data[1].trim(), data[6].trim());

                        // Check for duplicates
                        if (uniqueRows.add(row)) {
                            // Write only unique rows to text file
                            writer.write(row);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read data from text file and populate table model
        try (BufferedReader br = new BufferedReader(new FileReader(outputFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create JTable with model
        table = new JTable(model);

        // Add table to scroll pane and add scroll pane to frame
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Furniture::new);
    }
}









                             


                             



