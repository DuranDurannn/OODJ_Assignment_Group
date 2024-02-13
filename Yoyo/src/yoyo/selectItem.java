package yoyo;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class selectItem extends javax.swing.JFrame {
    public selectItem() {
        initComponents();
        loadTableData();
        setupListeners();
    }
    
    private void setupListeners() {
        // Add a listener to the selectItem_tbl for row selection
        selectItem_tbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    // Call a method to handle row selection
                    handleRowSelection();
                }
            }

            private void handleRowSelection() {
                selectItem_tbl.setRowSelectionAllowed(true);
            }
        });
}

    private void loadTableData() {
        String FILE_PATH = "furnitureDetails.txt";
        File furnitureList = new File(FILE_PATH);

        try {
            BufferedReader br = new BufferedReader(new FileReader(furnitureList));
            String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");
            DefaultTableModel table = (DefaultTableModel) selectItem_tbl.getModel();
            table.setColumnIdentifiers(columnsName);

            Object[] tableLines = br.lines().toArray();

            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");
                table.addRow(dataRow);
            }
        } catch (IOException ex) {
            Logger.getLogger(selectItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        selectItem_tbl.setDefaultEditor(Object.class, null);
    }
    
 private void filterTableData(String furnitureType, String priceRange) {
        // Get the DefaultTableModel of the selectItem_tbl
        DefaultTableModel selectItemModel = (DefaultTableModel) selectItem_tbl.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(selectItemModel);
        selectItem_tbl.setRowSorter(sorter);

        List<RowFilter<Object,Object>> filters = new ArrayList<>();

        // Filter by furniture type
        if (furnitureType != null && !furnitureType.isEmpty() && !furnitureType.equals("All")) {
            filters.add(RowFilter.regexFilter(furnitureType, 2));
        }

        // Filter by price range
        if (priceRange != null && !priceRange.isEmpty() && !priceRange.equals("None")) {
            String[] range = priceRange.split(" - ");
            double lowerBound = Double.parseDouble(range[0]);
            double upperBound = Double.parseDouble(range[1]);
            filters.add(RowFilter.numberFilter(RowFilter.ComparisonType.AFTER, lowerBound, 3));
            filters.add(RowFilter.numberFilter(RowFilter.ComparisonType.BEFORE, upperBound, 3));
        }

        RowFilter<Object,Object> combinedFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(combinedFilter);
        
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        furnitureType_cbox = new javax.swing.JComboBox<>();
        priceRange_cbox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectItem_tbl = new javax.swing.JTable();
        addToCart_btn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartItem_tbl = new javax.swing.JTable();
        checkOut_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalItem_text = new javax.swing.JTextField();
        totalPrice_text = new javax.swing.JTextField();
        removeFromCart_btn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setText("selectItem");

        jLabel2.setText("Furniture Type");

        jLabel3.setText("Price Range");

        furnitureType_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Modern Home", "General", "TV Cover Protector" }));
        furnitureType_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                furnitureType_cboxActionPerformed(evt);
            }
        });

        priceRange_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "0-1999", "2000-3999", "4000-5999" }));
        priceRange_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceRange_cboxActionPerformed(evt);
            }
        });

        selectItem_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Furniture Code", "Furniture Name", "Type", "Price"
            }
        ));
        jScrollPane1.setViewportView(selectItem_tbl);

        addToCart_btn.setText("Add to Cart");
        addToCart_btn.setToolTipText("");
        addToCart_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCart_btnActionPerformed(evt);
            }
        });

        cartItem_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Furniture Code", "Furniture Name", "Type", "Price"
            }
        ));
        jScrollPane2.setViewportView(cartItem_tbl);

        checkOut_btn.setText("Check Out");
        checkOut_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOut_btnActionPerformed(evt);
            }
        });

        jLabel4.setText("Total Price");

        jLabel5.setText("Total Item");

        totalItem_text.setEditable(false);
        totalItem_text.setText("0");

        totalPrice_text.setEditable(false);
        totalPrice_text.setText("0");
        totalPrice_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPrice_textActionPerformed(evt);
            }
        });

        removeFromCart_btn.setText("Remove From Cart");
        removeFromCart_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFromCart_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(removeFromCart_btn)
                                .addGap(18, 18, 18)
                                .addComponent(checkOut_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceRange_cbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalItem_text)
                                    .addComponent(totalPrice_text)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(390, 390, 390)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(474, 474, 474)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addToCart_btn)
                                .addGap(19, 19, 19))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(furnitureType_cbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(70, 70, 70))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(furnitureType_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(priceRange_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(addToCart_btn)
                                .addGap(23, 23, 23))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(totalItem_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalPrice_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkOut_btn)
                            .addComponent(removeFromCart_btn))
                        .addGap(42, 42, 42)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addToCart_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCart_btnActionPerformed
            // Get the selected row index from the selectItem_tbl
        int selectedRowIndex = selectItem_tbl.getSelectedRow();

        // Check if a row is selected
        if (selectedRowIndex != -1) {
            // Get the DefaultTableModel of the selectItem_tbl
            DefaultTableModel selectItemModel = (DefaultTableModel) selectItem_tbl.getModel();

            // Get the values from the selected row
            String furnitureCode = selectItemModel.getValueAt(selectedRowIndex, 0).toString();
            String furnitureName = selectItemModel.getValueAt(selectedRowIndex, 1).toString();
            String type = selectItemModel.getValueAt(selectedRowIndex, 2).toString();
            String price = selectItemModel.getValueAt(selectedRowIndex, 3).toString();

            // Add the selected item to the cartItem_tbl
            DefaultTableModel cartModel = (DefaultTableModel) cartItem_tbl.getModel();
            cartModel.addRow(new Object[]{furnitureCode, furnitureName, type, price});

            // Update total item count and total price
            int totalItems = cartModel.getRowCount();
            totalItem_text.setText(String.valueOf(totalItems));

            // Calculate total price
            int totalPrice = 0;
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                totalPrice += Double.parseDouble(cartModel.getValueAt(i, 3).toString());
            }
            totalPrice_text.setText(String.valueOf(totalPrice));
            
            selectItem_tbl.clearSelection();
        }
        else {
            JOptionPane.showMessageDialog(this, "Please select an item to add to cart", "Add To Cart", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addToCart_btnActionPerformed

    private void checkOut_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOut_btnActionPerformed
        System.out.println("Checkout");

        // Get the data from cartItem_tbl
        DefaultTableModel cartModel = (DefaultTableModel) cartItem_tbl.getModel();
        Object[][] data = new Object[cartModel.getRowCount()][cartModel.getColumnCount()];
        for (int i = 0; i < cartModel.getRowCount(); i++) {
            for (int j = 0; j < cartModel.getColumnCount(); j++) {
                data[i][j] = cartModel.getValueAt(i, j);
            }
        }

        // Create an instance of cartCheckOut and pass the data
        cartCheckOut cartCheckoutFrame = new cartCheckOut(data);

        // Display the cartCheckOut frame
        cartCheckoutFrame.setVisible(true);
    }//GEN-LAST:event_checkOut_btnActionPerformed

    private void removeFromCart_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFromCart_btnActionPerformed
        int selectedRowIndex = cartItem_tbl.getSelectedRow();
        
        if (selectedRowIndex != -1) {
            DefaultTableModel cartModel = (DefaultTableModel) cartItem_tbl.getModel();
            cartModel.removeRow(cartItem_tbl.getSelectedRow());
            
            // Update total item count and total price
            int totalItems = cartModel.getRowCount();
            totalItem_text.setText(String.valueOf(totalItems));
            
            // Calculate total price
            int totalPrice = 0;
            for (int i = 0; i < cartModel.getRowCount(); i++) {
                totalPrice += Double.parseDouble(cartModel.getValueAt(i, 3).toString());
            }
            totalPrice_text.setText(String.valueOf(totalPrice));
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to remove from cart", "Remove From Cart", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_removeFromCart_btnActionPerformed

    private void furnitureType_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_furnitureType_cboxActionPerformed
        String selectedFurnitureType = furnitureType_cbox.getSelectedItem().toString();
        filterTableData(selectedFurnitureType, null);
    }//GEN-LAST:event_furnitureType_cboxActionPerformed

    private void priceRange_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceRange_cboxActionPerformed
     String selectedPriceRange = furnitureType_cbox.getSelectedItem().toString();
        filterTableData(selectedPriceRange, null);
    }//GEN-LAST:event_priceRange_cboxActionPerformed

    private void totalPrice_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPrice_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPrice_textActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(selectItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new selectItem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCart_btn;
    private javax.swing.JTable cartItem_tbl;
    private javax.swing.JButton checkOut_btn;
    private javax.swing.JComboBox<String> furnitureType_cbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> priceRange_cbox;
    private javax.swing.JButton removeFromCart_btn;
    private javax.swing.JTable selectItem_tbl;
    private javax.swing.JTextField totalItem_text;
    private javax.swing.JTextField totalPrice_text;
    // End of variables declaration//GEN-END:variables
}
