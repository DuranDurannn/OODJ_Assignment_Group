package yoyo.application;

public class ProfileEdit extends javax.swing.JFrame {
String editUserUsernameInput;
String editUserGenderInput;
String editUserPhoneNumberInput;
String editUserEmailInput;
String editUserAddressInput;
String editUserRegisterPasswordInput;
String editUserConfirmPasswordInput;

    public ProfileEdit() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        editProfileRoundPanel = new yoyo.resources.RoundPanel();
        jLabel10 = new javax.swing.JLabel();
        EmailRegisterField = new javax.swing.JTextField();
        PasswordConfirmRegisterField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        editProfileButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        PasswordRegisterField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        UsernameRegisterField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        GenderRegisterField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        PhoneRegisterField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        AddressRegisterField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        editProfileRoundPanel.setBackground(new java.awt.Color(246, 245, 249));
        editProfileRoundPanel.setForeground(new java.awt.Color(17, 17, 43));
        editProfileRoundPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 33, 82));
        jLabel10.setText("Email");

        EmailRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        PasswordConfirmRegisterField.setBackground(new java.awt.Color(255, 255, 255));

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

        PasswordRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 33, 82));
        jLabel14.setText("Current Password");

        UsernameRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 33, 82));
        jLabel15.setText("Username");

        GenderRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(30, 33, 82));
        jLabel17.setText("Gender");

        PhoneRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(30, 33, 82));
        jLabel18.setText("Phone");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(30, 33, 82));
        jLabel19.setText("Address");

        AddressRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout editProfileRoundPanelLayout = new javax.swing.GroupLayout(editProfileRoundPanel);
        editProfileRoundPanel.setLayout(editProfileRoundPanelLayout);
        editProfileRoundPanelLayout.setHorizontalGroup(
            editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editProfileRoundPanelLayout.createSequentialGroup()
                        .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddressRegisterField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordRegisterField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordConfirmRegisterField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editProfileButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editProfileRoundPanelLayout.createSequentialGroup()
                                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EmailRegisterField, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                    .addComponent(UsernameRegisterField))
                                .addGap(30, 30, 30)
                                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                                        .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PhoneRegisterField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(GenderRegisterField))))
                        .addGap(40, 40, 40))))
        );
        editProfileRoundPanelLayout.setVerticalGroup(
            editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsernameRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GenderRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmailRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editProfileRoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(editProfileRoundPanelLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addGap(40, 40, 40))
                        .addComponent(PhoneRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddressRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordConfirmRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(editProfileButton)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(editProfileRoundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
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
        editUserUsernameInput = UsernameRegisterField.getText();
        editUserGenderInput = GenderRegisterField.getText();
        editUserEmailInput = EmailRegisterField.getText();
        editUserPhoneNumberInput = PhoneRegisterField.getText();
        editUserAddressInput = AddressRegisterField.getText();
        editUserRegisterPasswordInput = PasswordRegisterField.getText();
        editUserConfirmPasswordInput = PasswordConfirmRegisterField.getText();
        
    }//GEN-LAST:event_editProfileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressRegisterField;
    private javax.swing.JTextField EmailRegisterField;
    private javax.swing.JTextField GenderRegisterField;
    private javax.swing.JTextField PasswordConfirmRegisterField;
    private javax.swing.JTextField PasswordRegisterField;
    private javax.swing.JTextField PhoneRegisterField;
    private javax.swing.JTextField UsernameRegisterField;
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
