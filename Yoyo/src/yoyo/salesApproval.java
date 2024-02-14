package yoyo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class salesApproval extends javax.swing.JFrame {
    public salesApproval() {
        initComponents();
        displayPendingApproval(); // Call method to display pending approval data
    }

    // Method to read data from "pendingApproval.txt" and display it in the table
    private void displayPendingApproval() {
        DefaultTableModel model = (DefaultTableModel) pendingApproval_tbl.getModel();
        model.setRowCount(0); // Clear existing rows

        try (BufferedReader pendingReader = new BufferedReader(new FileReader("pendingApproval.txt"))) {

            String pendingLine;
            while ((pendingLine = pendingReader.readLine()) != null) {
                pendingLine = pendingLine.trim(); // Trim leading and trailing spaces
                if (!pendingLine.isEmpty()) { // Skip empty lines
                    String[] pendingParts = pendingLine.split(",");
                    if (pendingParts.length == 6) {
                        // Extract data from the parts array
                        String userEmail = pendingParts[0];
                        String furnitureCode = pendingParts[1];
                        String furnitureName = pendingParts[2];
                        String type = pendingParts[3];
                        double price = Double.parseDouble(pendingParts[4]);
                        String status = pendingParts[5];

                        // Add the extracted data to the table, including the user's email
                        model.addRow(new Object[]{userEmail, furnitureCode, furnitureName, type, price, status});
                    } else {
                        // Handle invalid lines
                        System.out.println("Invalid line in pendingApproval.txt: " + pendingLine);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateStatusInTextFile(int rowIndex, String newStatus) {
    try {
        String filePath = "pendingApproval.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        int count = 0;
        while ((line = reader.readLine()) != null) {
            if (count == rowIndex) {
                String[] parts = line.split(",");
                parts[5] = newStatus;
                line = String.join(",", parts);
            }
            sb.append(line).append("\n");
            count++;
        }
        reader.close();
        FileWriter writer = new FileWriter(filePath);
        writer.write(sb.toString());
        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    private void updateProductStatus(String userEmail, String furnitureCode, String furnitureName, String type, double price, String status) {
    try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("productStatus.txt", true)))) {
        writer.println(userEmail + "," + furnitureCode + "," + furnitureName + "," + type + "," + price + "," + status);
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pendingApproval_tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        approve_btn = new javax.swing.JButton();
        reject_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productProgress_tbl = new javax.swing.JTable();
        complete_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        pendingApproval_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Email", "Furniture Code", "Furniture Name", "Type", "Price", "Status"
            }
        ));
        jScrollPane1.setViewportView(pendingApproval_tbl);

        jLabel1.setText("Sales Approval");

        approve_btn.setText("Approve");
        approve_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approve_btnActionPerformed(evt);
            }
        });

        reject_btn.setText("Reject");
        reject_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reject_btnActionPerformed(evt);
            }
        });

        productProgress_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Email", "Furniture Code", "Furniture Name", "Type", "Price", "Status"
            }
        ));
        jScrollPane2.setViewportView(productProgress_tbl);

        complete_btn.setText("Complete");
        complete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(approve_btn)
                                .addGap(53, 53, 53)
                                .addComponent(reject_btn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(complete_btn)))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(approve_btn)
                                    .addComponent(reject_btn))))
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(complete_btn)
                        .addGap(305, 305, 305))))
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

    private void approve_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approve_btnActionPerformed
    int selectedRowIndex = pendingApproval_tbl.getSelectedRow();
    if (selectedRowIndex != -1) {
        DefaultTableModel pendingModel = (DefaultTableModel) pendingApproval_tbl.getModel();
        
        // Get the data from the selected row
        String userEmail = pendingModel.getValueAt(selectedRowIndex, 0).toString();
        String furnitureCode = pendingModel.getValueAt(selectedRowIndex, 1).toString();
        String furnitureName = pendingModel.getValueAt(selectedRowIndex, 2).toString();
        String type = pendingModel.getValueAt(selectedRowIndex, 3).toString();
        double price = Double.parseDouble(pendingModel.getValueAt(selectedRowIndex, 4).toString());

        // Update status to "Approved" in pendingApproval_tbl
        pendingModel.setValueAt("Approved", selectedRowIndex, 5);
        
        // Update the status in pendingApproval.txt
        updateStatusInTextFile(selectedRowIndex, "Approved");
        
        // Write the approved data to productStatus.txt
        updateProductStatus(userEmail, furnitureCode, furnitureName, type, price, "In Progress");
    } else {
        JOptionPane.showMessageDialog(this, "Please select a row to approve", "Approval Error", JOptionPane.ERROR_MESSAGE);
    }



    }//GEN-LAST:event_approve_btnActionPerformed

    private void complete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complete_btnActionPerformed
  
    }//GEN-LAST:event_complete_btnActionPerformed

    private void reject_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reject_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reject_btnActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(salesApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(salesApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(salesApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(salesApproval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new salesApproval().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve_btn;
    private javax.swing.JButton complete_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable pendingApproval_tbl;
    private javax.swing.JTable productProgress_tbl;
    private javax.swing.JButton reject_btn;
    // End of variables declaration//GEN-END:variables
}
