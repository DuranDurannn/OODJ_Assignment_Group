package yoyo;

public class EmployeeRegisterUI extends javax.swing.JFrame {

    public EmployeeRegisterUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        employeeRegistration_lbl = new javax.swing.JLabel();
        username_lbl = new javax.swing.JLabel();
        password_lbl = new javax.swing.JLabel();
        email_lbl = new javax.swing.JLabel();
        gender_lbl = new javax.swing.JLabel();
        role_lbl = new javax.swing.JLabel();
        username_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JTextField();
        email_txt = new javax.swing.JTextField();
        gender_dbox = new javax.swing.JComboBox<>();
        role_dbox = new javax.swing.JComboBox<>();
        back_btn = new javax.swing.JButton();
        register_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        confirmPassword_txt = new javax.swing.JTextField();
        address_txt = new javax.swing.JTextField();
        phoneNumber_txt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        employeeRegistration_lbl.setFont(new java.awt.Font("Devanagari Sangam MN", 1, 36)); // NOI18N
        employeeRegistration_lbl.setText("Employee Registration");

        username_lbl.setText("Username: ");

        password_lbl.setText("Password: ");

        email_lbl.setText("Email: ");

        gender_lbl.setText("Gender:");

        role_lbl.setText("Role:");

        gender_dbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--OPTION--", "Male", "Female" }));

        role_dbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--OPTION--", "Admin", "Officer", "Salesperson" }));

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        register_btn.setText("Register");
        register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btnActionPerformed(evt);
            }
        });

        jLabel1.setText("Re-enter Password:");

        confirmPassword_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassword_txtActionPerformed(evt);
            }
        });

        jLabel2.setText("Address:");

        jLabel3.setText("Phone Number:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(username_lbl)
                            .addComponent(password_lbl)
                            .addComponent(role_lbl)
                            .addComponent(back_btn)
                            .addComponent(jLabel1)
                            .addComponent(gender_lbl)
                            .addComponent(email_lbl)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(register_btn)
                                .addComponent(role_dbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(username_txt)
                                .addComponent(password_txt))
                            .addComponent(confirmPassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(phoneNumber_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(address_txt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(gender_dbox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(employeeRegistration_lbl))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(employeeRegistration_lbl)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username_lbl)
                    .addComponent(username_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(confirmPassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_lbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(address_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumber_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gender_dbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gender_lbl))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(role_dbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(role_lbl))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(register_btn))
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_btnActionPerformed
        String username = username_txt.getText();
        String password = password_txt.getText();
        String confirmPassword = confirmPassword_txt.getText();
        String email = email_txt.getText();
        String address = address_txt.getText();
        String phoneNumber = phoneNumber_txt.getText();
        String gender = (String) gender_dbox.getSelectedItem();
        String role = (String) role_dbox.getSelectedItem();
        
        username_txt.setText("");
        password_txt.setText("");
        confirmPassword_txt.setText("");
        email_txt.setText("");
        address_txt.setText("");
        phoneNumber_txt.setText("");
        gender_dbox.setSelectedIndex(0);
        role_dbox.setSelectedIndex(0);

        // Call the registerUser method from UserRegistration class
        boolean registrationSuccessful = EmployeeRegister.registerUser(username, password, confirmPassword, email, address, phoneNumber, gender, role);

        if (registrationSuccessful) {
            // Optionally, you can perform additional actions if registration is successful
            // For example, show a success message, navigate to another screen, etc.
            System.out.println("Registration successful! Additional actions can be performed here.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_register_btnActionPerformed

    private void confirmPassword_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassword_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassword_txtActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        AdminMainMenuUI adminMainMenu = new AdminMainMenuUI();
        adminMainMenu.setVisible(true);
        adminMainMenu.pack();
        adminMainMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_txt;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField confirmPassword_txt;
    private javax.swing.JLabel email_lbl;
    private javax.swing.JTextField email_txt;
    private javax.swing.JLabel employeeRegistration_lbl;
    private javax.swing.JComboBox<String> gender_dbox;
    private javax.swing.JLabel gender_lbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JTextField password_txt;
    private javax.swing.JTextField phoneNumber_txt;
    private javax.swing.JButton register_btn;
    private javax.swing.JComboBox<String> role_dbox;
    private javax.swing.JLabel role_lbl;
    private javax.swing.JLabel username_lbl;
    private javax.swing.JTextField username_txt;
    // End of variables declaration//GEN-END:variables
}
