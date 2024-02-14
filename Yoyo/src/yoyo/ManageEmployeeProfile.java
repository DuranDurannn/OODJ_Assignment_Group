package yoyo;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ManageEmployeeProfile extends javax.swing.JFrame {
    public ManageEmployeeProfile() {
        initComponents();
        loadTableData();
        setupListeners();
    }
    
    private void setupListeners() {
        // Add a listener to the selectItem_tbl for row selection
        allEmployee_tbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    // Call a method to handle row selection
                    handleRowSelection();
                }
            }

            private void handleRowSelection() {
                int selectedRowIndex = allEmployee_tbl.getSelectedRow();
                if (selectedRowIndex != -1) { // If a row is selected
                    // Retrieve data from the selected row
                    String userID = allEmployee_tbl.getValueAt(selectedRowIndex, 0).toString();
                    String username = allEmployee_tbl.getValueAt(selectedRowIndex, 1).toString();
                    String email = allEmployee_tbl.getValueAt(selectedRowIndex, 2).toString();
                    String address = allEmployee_tbl.getValueAt(selectedRowIndex, 3).toString();
                    String phoneNumber = allEmployee_tbl.getValueAt(selectedRowIndex, 4).toString();
                    String gender = allEmployee_tbl.getValueAt(selectedRowIndex, 5).toString();
                    String role = allEmployee_tbl.getValueAt(selectedRowIndex, 6).toString();

                    // Set the retrieved data to the text fields and combo boxes
                    username_txt.setText(username);
                    email_txt.setText(email);
                    address_txt.setText(address);
                    phoneNumber_txt.setText(phoneNumber);
                    
                    gender_cbox.setSelectedItem(gender);
                    // Set the role based on the first letter of the status
                    switch (role.charAt(0)) {
                        case 'A':
                            role_cbox.setSelectedItem("Admin");
                            break;
                        case 'O':
                            role_cbox.setSelectedItem("Officer");
                            break;
                        case 'S':
                            role_cbox.setSelectedItem("Salesperson");
                            break;
                        default:
                            role_cbox.setSelectedIndex(0); // Set to default if status is unknown
                            break;
                    }
                }   
            }
        });
    }
    
    private void loadTableData() {
        String FILE_PATH = "employeeRegistration.txt";
        File employeeList = new File(FILE_PATH);

        try {
            BufferedReader br = new BufferedReader(new FileReader(employeeList));
            String[] columnsName = {"UserID", "Username", "Email", "Address", "Phone Number", "Gender", "Status"};
        
            // Initialize the table model with column names
            DefaultTableModel table = new DefaultTableModel(columnsName, 0);
            allEmployee_tbl.setModel(table);
            
            Object[] tableLines = br.lines().toArray();

            for (Object tableLine : tableLines) {
                String line = tableLine.toString().trim();
                String[] dataRow = line.split(",");
                
                // Exclude the password column (assuming it's the third column)
                String[] dataRowWithoutPassword = new String[dataRow.length - 1];
                System.arraycopy(dataRow, 0, dataRowWithoutPassword, 0, 2); // Copy the first two elements (UserID and Username)
                System.arraycopy(dataRow, 3, dataRowWithoutPassword, 2, dataRowWithoutPassword.length - 2); // Copy the rest of the elements

                table.addRow(dataRowWithoutPassword);
            }
        } catch (IOException ex) {
            Logger.getLogger(ManageEmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        allEmployee_tbl.setDefaultEditor(Object.class, null);
    }
    
    private void filterTableData(String email) {
        // Get the DefaultTableModel of the selectItem_tbl
        DefaultTableModel selectItemModel = (DefaultTableModel) allEmployee_tbl.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(selectItemModel);
        allEmployee_tbl.setRowSorter(sorter);

        List<RowFilter<Object,Object>> filters = new ArrayList<>();

        // Filter by furniture type
        if (email != null && !email.isEmpty()) {
            filters.add(RowFilter.regexFilter(email, 1));
        }

        RowFilter<Object,Object> combinedFilter = RowFilter.andFilter(filters);
        sorter.setRowFilter(combinedFilter);
        
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allEmployee_tbl = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        email_txt = new javax.swing.JTextField();
        edit_btn = new javax.swing.JButton();
        gender_cbox = new javax.swing.JComboBox<>();
        role_cbox = new javax.swing.JComboBox<>();
        remove_btn = new javax.swing.JButton();
        address_txt = new javax.swing.JTextField();
        phoneNumber_txt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        allEmployee_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Email", "Address", "Phone Number", "Gender", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(allEmployee_tbl);

        jLabel2.setText("Username: ");

        jLabel3.setText("Email: ");

        jLabel4.setText("Gender:");

        jLabel5.setText("Role: ");

        edit_btn.setText("Edit");
        edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btnActionPerformed(evt);
            }
        });

        gender_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Optiion--", "Male", "Female" }));

        role_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Option--", "Admin", "Officer", "Salesperson" }));

        remove_btn.setText("Remove");
        remove_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_btnActionPerformed(evt);
            }
        });

        jLabel6.setText("Address");

        jLabel8.setText("Phone number: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(edit_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remove_btn)
                .addGap(33, 33, 33))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gender_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(role_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(phoneNumber_txt)
                            .addComponent(address_txt)
                            .addComponent(username_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(email_txt))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(role_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(remove_btn)
                    .addComponent(edit_btn))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jLabel1.setText("Manage worker profile");

        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Search username:");

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(back_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(323, 323, 323))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(back_btn))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btnActionPerformed
            // Get the selected row index
        int selectedRow = allEmployee_tbl.getSelectedRow();

        if (selectedRow != -1) { // Check if a row is selected
            try {
            // Read the file into a list
            List<String> lines = Files.readAllLines(Paths.get("employeeRegistration.txt"));

            // Extract user ID from the selected row
            String userID = allEmployee_tbl.getValueAt(selectedRow, 0).toString();

            // Find the line to update in the list
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.startsWith(userID)) {
                    String[] datarow = line.split(",");
                    
                    // Ensure that the password is not overwritten
                    String password = datarow[2];
                    // Update the details in the line
                    String updatedLine = userID + "," + username_txt.getText() + "," + password  + "," + email_txt.getText() + ","
                        + address_txt.getText() + "," + phoneNumber_txt.getText() + "," + gender_cbox.getSelectedItem().toString() + "," 
                        + role_cbox.getSelectedItem().toString().charAt(0);

                    // Replace the old line with the updated one
                    lines.set(i, updatedLine);

                    // Write the updated list back to the file
                    Files.write(Paths.get("employeeRegistration.txt"), lines);

                    // Refresh the table to reflect the changes
                    loadTableData();

                    // Inform the user about the successful update
                    JOptionPane.showMessageDialog(this, "Employee details updated successfully.");
                    return; // Exit the method
                    }
                }
                // If the user ID is not found
                JOptionPane.showMessageDialog(this, "User ID not found.", "Uh-oh!", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                Logger.getLogger(ManageEmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.", "Uh-oh!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_edit_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        AdminMainMenuUI adminMenu = new AdminMainMenuUI();
        adminMenu.setVisible(true);
        adminMenu.pack();
        adminMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void remove_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_btnActionPerformed
        int selectedRowIndex = allEmployee_tbl.getSelectedRow();
        if (selectedRowIndex != -1) { // If a row is selected
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to remove this employee?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    // Read the file into a list
                    List<String> lines = Files.readAllLines(Paths.get("employeeRegistration.txt"));

                    // Extract user ID from the selected row
                    String userID = allEmployee_tbl.getValueAt(selectedRowIndex, 0).toString();

                    // Find the line to remove from the list
                    for (int i = 0; i < lines.size(); i++) {
                        String line = lines.get(i);
                        if (line.startsWith(userID)) {
                            // Remove the line from the list
                            lines.remove(i);

                            // Write the updated list back to the file
                            Files.write(Paths.get("employeeRegistration.txt"), lines);

                            // Refresh the table to reflect the changes
                            loadTableData();

                            // Inform the user about the successful deletion
                            JOptionPane.showMessageDialog(this, "Employee removed successfully.");
                            return; // Exit the method
                        }
                    }
                    // If the user ID is not found
                    JOptionPane.showMessageDialog(this, "User ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(ManageEmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_remove_btnActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        String search = search_txt.getText();
        filterTableData(search);
    }//GEN-LAST:event_search_txtKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_txt;
    private javax.swing.JTable allEmployee_tbl;
    private javax.swing.JButton back_btn;
    private javax.swing.JButton edit_btn;
    private javax.swing.JTextField email_txt;
    private javax.swing.JComboBox<String> gender_cbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField phoneNumber_txt;
    private javax.swing.JButton remove_btn;
    private javax.swing.JComboBox<String> role_cbox;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
