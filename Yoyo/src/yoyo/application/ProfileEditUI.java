package yoyo.application;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileEditUI extends javax.swing.JFrame {
EditProfile editProfile = new EditProfile();
String editUserUsernameInput;
String editUserGenderInput;
String editUserPhoneInput;
String editUserEmailInput;
String editUserAddressInput;
String editUserCurrentPasswordInput;
String editUserConfirmPasswordInput;

    public ProfileEditUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editProfileRoundPanel = new yoyo.resources.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        EditUserEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        editProfileButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        EditCurrentPasswordField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        EditUsernameField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        EditGenderField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        EditPhoneField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        EditAddressField = new javax.swing.JTextField();
        EditNewPasswordField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        editProfileRoundPanel.setBackground(new java.awt.Color(246, 245, 249));
        editProfileRoundPanel.setForeground(new java.awt.Color(17, 17, 43));
        editProfileRoundPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 33, 82));
        jLabel10.setText("Email");

        EditUserEmail.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 33, 82));
        jLabel11.setText("New Password");

        editProfileButton.setBackground(new java.awt.Color(196, 196, 196));
        editProfileButton.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        editProfileButton.setForeground(new java.awt.Color(30, 33, 82));
        editProfileButton.setText("Save Changes");
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 33, 82));
        jLabel13.setText("Edit Profile");

        EditCurrentPasswordField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 33, 82));
        jLabel14.setText("Current Password");

        EditUsernameField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 33, 82));
        jLabel15.setText("Username");

        EditGenderField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(30, 33, 82));
        jLabel17.setText("Gender");

        EditPhoneField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(30, 33, 82));
        jLabel18.setText("Phone");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(30, 33, 82));
        jLabel19.setText("Address");

        EditAddressField.setBackground(new java.awt.Color(255, 255, 255));

        EditNewPasswordField.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout editProfileRoundPanelLayout = new javax.swing.GroupLayout(editProfileRoundPanel);
        editProfileRoundPanel.setLayout(editProfileRoundPanelLayout);
        editProfileRoundPanelLayout.setHorizontalGroup(
            editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditNewPasswordField)
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(277, 277, 277))
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                        .addGap(351, 351, 351))
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editProfileRoundPanelLayout.createSequentialGroup()
                        .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EditAddressField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EditCurrentPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editProfileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editProfileRoundPanelLayout.createSequentialGroup()
                                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EditUserEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                    .addComponent(EditUsernameField))
                                .addGap(30, 30, 30)
                                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                                        .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EditPhoneField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EditGenderField))))
                        .addGap(40, 40, 40))))
        );
        editProfileRoundPanelLayout.setVerticalGroup(
            editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditGenderField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(40, 40, 40))
                        .addComponent(EditPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditCurrentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(editProfileButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(editProfileRoundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editProfileRoundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        editUserUsernameInput = EditUsernameField.getText();
        editUserGenderInput = EditGenderField.getText();
        editUserEmailInput = EditUserEmail.getText();
        editUserPhoneInput = EditPhoneField.getText();
        editUserAddressInput = EditAddressField.getText();
        editUserCurrentPasswordInput = EditCurrentPasswordField.getText();
        editUserConfirmPasswordInput = EditNewPasswordField.getText();
        
         try {
            SecureFileHandler secureFileHandler = new SecureFileHandler();
            ArrayList<String[]> decryptedData = secureFileHandler.readAndDecryptLines("userInfo.txt", 8, "Your16CharKey123");
            editProfile.setUserInfo(decryptedData);
            editProfile.setEditUsernameInput(editUserUsernameInput);
            editProfile.setEditGenderInput(editUserGenderInput);
            editProfile.setEditPhoneInput(editUserPhoneInput);
            editProfile.setEditEmailInput(editUserEmailInput);
            editProfile.setEditAddressInput(editUserAddressInput);
            editProfile.setEditPasswordInput(editUserCurrentPasswordInput);
            editProfile.setEditConfirmPasswordInput(editUserConfirmPasswordInput);
            User verifiedUser = editProfile.editCheck();

            if (verifiedUser != null) {
                dispose();
                
            } else {
                System.out.println("Invalid credentials.");
            }
        } catch (IOException e) {
            System.err.println("Error reading user information file: " + e.getMessage());
        } finally {
        }
    }//GEN-LAST:event_editProfileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EditAddressField;
    private javax.swing.JTextField EditCurrentPasswordField;
    private javax.swing.JTextField EditGenderField;
    private javax.swing.JTextField EditNewPasswordField;
    private javax.swing.JTextField EditPhoneField;
    private javax.swing.JTextField EditUserEmail;
    private javax.swing.JTextField EditUsernameField;
    private javax.swing.JButton editProfileButton;
    private yoyo.resources.RoundPanel editProfileRoundPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
