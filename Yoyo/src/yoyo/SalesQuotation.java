package yoyo;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class SalesQuotation extends javax.swing.JFrame {
    public SalesQuotation(){
        initComponents();
        loadPendingQuotation(); // Call method to load pending quotation data
    }

    public void addRowToTable(Object[] rowData) {
        DefaultTableModel model = (DefaultTableModel) salesQuotation_tbl.getModel();
        model.addRow(rowData);
    }

    private void loadPendingQuotation() {
        DefaultTableModel model = (DefaultTableModel) salesQuotation_tbl.getModel();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("pendingQuotation.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) { // Check if the line has 5 parts (assuming the last part is the status)
                    Object[] rowData = {parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]}; // Include the status in the last column
                    model.addRow(rowData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading pending quotation data from file.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        salesQuotation_tbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sendApproval_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        salesQuotation_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Email", "Furniture Code", "Furniture Name", "Type", "Price", "Status"
            }
        ));
        jScrollPane1.setViewportView(salesQuotation_tbl);

        jLabel1.setText("Sales quotation");

        sendApproval_btn.setText("Send Approval");
        sendApproval_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendApproval_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(378, 378, 378))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(sendApproval_btn)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(sendApproval_btn)
                        .addGap(187, 187, 187))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendApproval_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendApproval_btnActionPerformed
                                         
        // Get the selected row index
        int selectedRow = salesQuotation_tbl.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to send approval.");
            return;
        }

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) salesQuotation_tbl.getModel();

        // Get the data from the selected row
        Object[] rowData = {
            model.getValueAt(selectedRow, 0),
            model.getValueAt(selectedRow, 1),
            model.getValueAt(selectedRow, 2),
            model.getValueAt(selectedRow, 3),
            model.getValueAt(selectedRow, 4),
            "unapproved" // Set status to "unapproved" in SalesApproval frame
        };

        // Remove the row from salesQuotation_tbl
        model.removeRow(selectedRow);

        // Write data to pendingApproval.txt
        writeDataToPendingApproval(rowData);

        // Remove data from pendingQuotation.txt
        removeDataFromPendingQuotation(selectedRow);
    }                                                

    private void writeDataToPendingApproval(Object[] rowData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pendingApproval.txt", true))) {
            for (Object data : rowData) {
                writer.write(data.toString());
                writer.write(",");
            }
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error writing to pendingApproval.txt.");
        }
    }

    private void removeDataFromPendingQuotation(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) salesQuotation_tbl.getModel();
        try (BufferedReader reader = new BufferedReader(new FileReader("pendingQuotation.txt"))) {
            String line;
            StringBuilder newFileContent = new StringBuilder();
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (count != selectedRow) {
                    newFileContent.append(line);
                    newFileContent.append("\n");
                }
                count++;
            }
            // Write the updated content back to pendingQuotation.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("pendingQuotation.txt"))) {
                writer.write(newFileContent.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error removing data from pendingQuotation.txt.");
        }
      

    }//GEN-LAST:event_sendApproval_btnActionPerformed

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
            java.util.logging.Logger.getLogger(SalesQuotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesQuotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesQuotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesQuotation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesQuotation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable salesQuotation_tbl;
    private javax.swing.JButton sendApproval_btn;
    // End of variables declaration//GEN-END:variables
}
