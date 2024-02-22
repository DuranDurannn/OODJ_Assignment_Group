package yoyo.application;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FurnitureDetailsUI extends javax.swing.JFrame {
    
    private String lastSalesID = "S000";
    
    public FurnitureDetailsUI() {
        initComponents();
        loadFurnitureDetailsFromFile("FurnitureDetailsTest.txt");
    }
    
    private void loadFurnitureDetailsFromFile(String filePath) {
        DefaultTableModel model = (DefaultTableModel) FurnitureDetails_tbl.getModel();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int maxSalesID = 0;
            while ((line = br.readLine()) != null) {
                String decryptedLine = Encryption.decrypt(line, "Your16CharKey123"); // Replace "Your16CharKey123" with your actual secret key
                String[] rowData = decryptedLine.split("!");
                model.addRow(rowData);
            }

            // Increment maxSalesID by 1 to get the next sales ID
            lastSalesID = String.format("S%03d", maxSalesID + 1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FurnitureDetails_tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Retrieve_btn = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        FurnitureDetails_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FurnitureID", "Furniture Name", "Type ", "Price"
            }
        ));
        jScrollPane1.setViewportView(FurnitureDetails_tbl);

        jLabel1.setText("Furniture List");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        Retrieve_btn.setText("Retrieve");
        Retrieve_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Retrieve_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(Retrieve_btn)
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(Retrieve_btn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Retrieve_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Retrieve_btnActionPerformed
    
    try (BufferedReader br = new BufferedReader(new FileReader("PendingApproval.txt"))) {
        String line;
        int maxSalesID = 0;
        while ((line = br.readLine()) != null) {
            String[] rowData = line.split("!");
            String salesID = rowData[0].substring(1); // Remove the 'S' prefix
            int currentSalesID = Integer.parseInt(salesID);
            if (currentSalesID > maxSalesID) {
                maxSalesID = currentSalesID;
            }
            System.out.println(maxSalesID);
            System.out.println(currentSalesID);
        }
        // Increment maxSalesID by 1 to get the next sales ID
        lastSalesID = String.format("S%03d", maxSalesID + 1);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    // Get the selected row index
    int selectedRowIndex = FurnitureDetails_tbl.getSelectedRow();

    // Check if a row is selected
    if (selectedRowIndex != -1) {
        // Get the FurnitureID from the selected row
        String furnitureID = FurnitureDetails_tbl.getValueAt(selectedRowIndex, 0).toString();
        String furnitureName = FurnitureDetails_tbl.getValueAt(selectedRowIndex, 1).toString();
        String type = FurnitureDetails_tbl.getValueAt(selectedRowIndex, 2).toString();
        String price = FurnitureDetails_tbl.getValueAt(selectedRowIndex, 3).toString();
        String status = "pending";
        LocalDate localDate = LocalDate.now();
        String date = localDate.toString();
        
        try {
            // Store the FurnitureID into PendingApproval.txt
            storeFurnitureID(lastSalesID, furnitureID, furnitureName, type, price, status, date);
        } catch (IOException ex) {
            Logger.getLogger(FurnitureDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Display a confirmation message
        JOptionPane.showMessageDialog(this, "FurnitureID " + furnitureID + " stored in PendingApproval.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        // Display a message if no row is selected
        JOptionPane.showMessageDialog(this, "Please select a row from the table", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void storeFurnitureID(String lastSalesID, String furnitureID, String furnitureName, String type, String price, String status, String date) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("PendingApproval.txt", true))) {
            // Append two delimiters followed by the Furniture ID to the file
            writer.write(lastSalesID + "!" + "!" + furnitureID + "!" + furnitureName + "!" + type + "!" + price + "!" + status + "!" + date );
            writer.newLine();
        }
    }//GEN-LAST:event_Retrieve_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable FurnitureDetails_tbl;
    private javax.swing.JButton Retrieve_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
