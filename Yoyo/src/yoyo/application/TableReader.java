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
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class TableReader {
    public void loadTableData(String filePath, DefaultTableModel tableModel) {
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] dataRow = line.split("!");
                tableModel.addRow(dataRow);
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Print the stack trace for debugging
        }
    }
}


