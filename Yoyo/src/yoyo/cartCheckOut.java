package yoyo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class cartCheckOut extends javax.swing.JFrame {
    
    public cartCheckOut(Object[][] data) {
        initComponents();
        
        // Populate cartCheckOut_tbl with the data from cartItem_tbl
        DefaultTableModel model = (DefaultTableModel) cartCheckOut_tbl.getModel();
        for (Object[] row : data) {
            model.addRow(row);
        }
        
        // Calculate and set total amount
        double totalAmount = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            Object value = model.getValueAt(i, 3);
            if (value != null) {
                totalAmount += Double.parseDouble(value.toString());
            }
        }
        totalAmount_txt.setText(String.valueOf(totalAmount));
        totalAmount_txt.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cartCheckout_lbl = new javax.swing.JLabel();
        totalAmount_txt = new javax.swing.JTextField();
        totalAmount_lbl = new javax.swing.JLabel();
        payAmount_txt = new javax.swing.JTextField();
        payAmount_lbl = new javax.swing.JLabel();
        payNow_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartCheckOut_tbl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        cartCheckout_lbl.setText("Cart Checkout");

        totalAmount_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalAmount_txtActionPerformed(evt);
            }
        });

        totalAmount_lbl.setText("total amount：RM");

        payAmount_lbl.setText("pay amount: RM");

        payNow_btn.setText("Pay now");
        payNow_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payNow_btnActionPerformed(evt);
            }
        });

        back_btn.setText("Back");

        cartCheckOut_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Furniture Code", "Furniture Name", "Type", "Price"
            }
        ));
        jScrollPane1.setViewportView(cartCheckOut_tbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(cartCheckout_lbl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(back_btn)
                                .addGap(31, 31, 31)
                                .addComponent(payNow_btn))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(payAmount_lbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(payAmount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(totalAmount_lbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(totalAmount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cartCheckout_lbl)
                .addGap(79, 79, 79)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmount_lbl)
                    .addComponent(totalAmount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payAmount_lbl)
                    .addComponent(payAmount_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(payNow_btn))
                .addGap(121, 121, 121))
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

    private void totalAmount_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalAmount_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalAmount_txtActionPerformed

    private void payNow_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payNow_btnActionPerformed
                                            
        // Get the pay amount entered by the user
        double payAmount = Double.parseDouble(payAmount_txt.getText());

        // Get the total amount from the text field
        double totalAmount = Double.parseDouble(totalAmount_txt.getText());

        // Check if pay amount is sufficient
        if (payAmount >= totalAmount) {
            // Perform payment processing here
            // For example, display a message dialog
            JOptionPane.showMessageDialog(this, "Payment successful! Thank you for your purchase.");

            // Save data to pendingQuotation.txt
            DefaultTableModel model = (DefaultTableModel) cartCheckOut_tbl.getModel();
            int rowCount = model.getRowCount();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("pendingQuotation.txt", true))) {
                
                String currentUserToWrite = null;
                
                try {
                    File currentUser = new File("currentUser.txt");
                    Scanner myReader = new Scanner(currentUser);
                     while (myReader.hasNextLine()) {
                        String current = myReader.nextLine();
                        String[] currentActiveUser = current.split(",");
                        currentUserToWrite = currentActiveUser[3];
                     }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                
                for (int i = 0; i < rowCount; i++) {
                    String furnitureCode = model.getValueAt(i, 0).toString();
                    String furnitureName = model.getValueAt(i, 1).toString();
                    String type = model.getValueAt(i, 2).toString();
                    double price = Double.parseDouble(model.getValueAt(i, 3).toString());
                    // Append ",pending" to the data before writing it to the file
                    String line = currentUserToWrite + "," + furnitureCode + "," + furnitureName + "," + type + "," + price + ",pending";
                    writer.write(line);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving data to pendingQuotation.txt");
            }

            // Add data to SalesQuotation table
            SalesQuotation salesQuotation = new SalesQuotation();
            for (int i = 0; i < rowCount; i++) {
                Object[] rowData = {
                    model.getValueAt(i, 0),
                    model.getValueAt(i, 1),
                    model.getValueAt(i, 2),
                    model.getValueAt(i, 3)
                };
                salesQuotation.addRowToTable(rowData);
            }

            // Close the cartCheckOut window after successful payment
            dispose();
        } else {
            // If pay amount is insufficient, display an error message
            JOptionPane.showMessageDialog(this, "Insufficient pay amount. Please enter a valid amount.");
        }
    }//GEN-LAST:event_payNow_btnActionPerformed

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
            java.util.logging.Logger.getLogger(cartCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cartCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cartCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cartCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JTable cartCheckOut_tbl;
    private javax.swing.JLabel cartCheckout_lbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel payAmount_lbl;
    private javax.swing.JTextField payAmount_txt;
    private javax.swing.JButton payNow_btn;
    private javax.swing.JLabel totalAmount_lbl;
    private javax.swing.JTextField totalAmount_txt;
    // End of variables declaration//GEN-END:variables
}
