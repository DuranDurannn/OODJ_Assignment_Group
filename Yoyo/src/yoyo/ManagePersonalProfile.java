package yoyo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ManagePersonalProfile extends javax.swing.JFrame {
    public ManagePersonalProfile() {
        initComponents();
        autoFillPersonal();
    }
    
    public void autoFillPersonal() {
        try {
            File currentUser = new File("currentUser.txt");
            Scanner myReader = new Scanner(currentUser);
             while (myReader.hasNextLine()) {
                String current = myReader.nextLine();
                String[] currentactiveUser = current.split(",");
                String username = currentactiveUser[1];
                String email = currentactiveUser[3];
                String gender = currentactiveUser[4];
              
                // Set the retrieved data to the text fields and combo boxes
                username_txt.setText(username);
                email_txt.setText(email);
                gender_cbox.setSelectedItem(gender);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        email_txt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        save_btn = new javax.swing.JButton();
        newPassword_txt = new javax.swing.JPasswordField();
        reEnterNewPassword_txt = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        gender_cbox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        address_txt = new javax.swing.JTextField();
        phoneNumber_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setText("Username:");

        jLabel2.setText("New Password:");

        jLabel3.setText("Re-enter Password:");

        jLabel4.setText("Email:");

        jLabel5.setText("Profile Customization");

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        save_btn.setText("Save changes");
        save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btnActionPerformed(evt);
            }
        });

        jLabel6.setText("Gender:");

        gender_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Option--", "Male", "Female" }));

        jLabel7.setText("Address");

        jLabel8.setText("Phone Number");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(115, 115, 115)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(username_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(newPassword_txt)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(back_btn)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addComponent(reEnterNewPassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(save_btn)
                                        .addGap(21, 21, 21))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(email_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(gender_cbox, 0, 1, Short.MAX_VALUE)
                                    .addComponent(phoneNumber_txt)
                                    .addComponent(address_txt))))))
                .addContainerGap(293, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newPassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(reEnterNewPassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender_cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(save_btn))
                .addContainerGap(86, Short.MAX_VALUE))
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

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        AdminMainMenuUI adminMenu = new AdminMainMenuUI();
        adminMenu.setVisible(true);
        adminMenu.pack();
        adminMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btnActionPerformed
        String newUsername = username_txt.getText();
        String newPassword = new String(newPassword_txt.getPassword());
        String reEnteredPassword = new String(reEnterNewPassword_txt.getPassword());
        String newEmail = email_txt.getText();
        String newAddress = address_txt.getText();
        String newPhoneNumber = phoneNumber_txt.getText();
        String newGender = gender_cbox.getSelectedItem().toString();

        // Check if the passwords match or newPassword is empty
        if (!newPassword.equals("") || !reEnteredPassword.equals("")) {
            try {
                File currentUserFile = new File("currentUser.txt");
                File employeeRegistrationFile = new File("employeeRegistration.txt");
                File tempFile = new File("temp.txt");

                Scanner currentUserScanner = new Scanner(currentUserFile);
                PrintWriter writer = new PrintWriter(new FileWriter(tempFile));

                // Read the currentUser.txt file to get the current user's ID
                String currentLine = currentUserScanner.nextLine();
                String[] currentUserData = currentLine.split(",");
                String currentUserId = currentUserData[0];
                String currentUserStatus = currentUserData[7];
                
                Scanner employeeScanner = new Scanner(employeeRegistrationFile);
                while (employeeScanner.hasNextLine()) {
                    String line = employeeScanner.nextLine();
                    String[] userData = line.split(",");
                    String userId = userData[0];

                    // If the user ID matches the current user's ID, update the information
                    if (userId.equals(currentUserId)) {
                        // Update the user's information
                        line = userId + "," + newUsername + "," + newPassword + "," + newEmail + "," + newAddress + "," + newPhoneNumber + "," + newGender + "," + currentUserStatus;
                    }
                    writer.println(line);
                }
                
                PrintWriter currentWriter = new PrintWriter(new FileWriter(currentUserFile));
                currentLine = currentUserId + "," + newUsername + "," + newPassword + "," + newEmail + "," + newGender + "," + currentUserStatus;
                currentWriter.println(currentLine);
                
                employeeScanner.close();
                writer.close();
                currentWriter.close();

                // Rename the temporary file to the original file name
                if (!employeeRegistrationFile.delete()) {
                    System.out.println("Could not delete file");
                    return;
                }
                if (!tempFile.renameTo(employeeRegistrationFile)) {
                    System.out.println("Could not rename file");
                }

                // Inform the user about the successful update
                JOptionPane.showMessageDialog(this, "Changes saved successfully.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Passwords do not match or new password is empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        AdminMainMenuUI adminMenu = new AdminMainMenuUI();
        adminMenu.setVisible(true);
        adminMenu.pack();
        adminMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_save_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_txt;
    private javax.swing.JButton back_btn;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField newPassword_txt;
    private javax.swing.JTextField phoneNumber_txt;
    private javax.swing.JPasswordField reEnterNewPassword_txt;
    private javax.swing.JButton save_btn;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
