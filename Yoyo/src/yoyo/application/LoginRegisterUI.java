package yoyo.application;

import yoyo.actors.User;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;


public class LoginRegisterUI extends javax.swing.JFrame {
CardLayout cardLayoutWelcome;
Login login = new Login();
Register register = new Register();
String UserInputEmailOrPhone;
String UserInputPassword;
String userUsernameInput;
String userGenderInput;
String userEmailInput;
String userPhoneInput;
String userAddressInput;
String userRegisterPasswordInput;
String userConfirmPasswordInput;

    public LoginRegisterUI() {
        initComponents();
        cardLayoutWelcome = (CardLayout) WelcomeCards.getLayout();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        WelcomeCards = new javax.swing.JPanel();
        LoginCard = new javax.swing.JPanel();
        roundPanel1 = new yoyo.resources.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EmailOrPhoneField = new javax.swing.JTextField();
        PasswordField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        LogInButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        GoToSignUpButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        RegisterCard = new javax.swing.JPanel();
        roundPanel2 = new yoyo.resources.RoundPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        EmailRegisterField = new javax.swing.JTextField();
        PasswordConfirmRegisterField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        SignUpButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        GoToLogInButton = new javax.swing.JButton();
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

        WelcomeCards.setOpaque(false);
        WelcomeCards.setLayout(new java.awt.CardLayout());

        LoginCard.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel1.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel1.setForeground(new java.awt.Color(17, 17, 43));
        roundPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 33, 82));
        jLabel5.setText("Please login to access your account");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 33, 82));
        jLabel6.setText("Email or Phone");

        EmailOrPhoneField.setBackground(new java.awt.Color(255, 255, 255));

        PasswordField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 33, 82));
        jLabel7.setText("Password");

        LogInButton.setBackground(new java.awt.Color(196, 196, 196));
        LogInButton.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        LogInButton.setForeground(new java.awt.Color(30, 33, 82));
        LogInButton.setText("Login");
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 33, 82));
        jLabel8.setText("Don't have an account ? ");

        GoToSignUpButton.setBackground(null);
        GoToSignUpButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GoToSignUpButton.setForeground(new java.awt.Color(51, 51, 255));
        GoToSignUpButton.setText("Sign Up");
        GoToSignUpButton.setBorder(null);
        GoToSignUpButton.setContentAreaFilled(false);
        GoToSignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToSignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 0, 0)
                .addComponent(GoToSignUpButton)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(GoToSignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        GoToSignUpButton.getAccessibleContext().setAccessibleName("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 33, 82));
        jLabel4.setText("Hello There!");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(107, 107, 107))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(312, 312, 312))
                    .addComponent(EmailOrPhoneField)
                    .addComponent(LogInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(391, 391, 391))
                    .addComponent(PasswordField)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(265, 265, 265))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(192, 192, 192)))
                .addGap(40, 40, 40))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(EmailOrPhoneField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(52, 52, 52)
                .addComponent(LogInButton)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout LoginCardLayout = new javax.swing.GroupLayout(LoginCard);
        LoginCard.setLayout(LoginCardLayout);
        LoginCardLayout.setHorizontalGroup(
            LoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginCardLayout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(402, Short.MAX_VALUE))
        );
        LoginCardLayout.setVerticalGroup(
            LoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginCardLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        WelcomeCards.add(LoginCard, "LoginCard");

        RegisterCard.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel2.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel2.setForeground(new java.awt.Color(17, 17, 43));
        roundPanel2.setPreferredSize(new java.awt.Dimension(500, 500));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 33, 82));
        jLabel9.setText("If you're signing up as a staff member, please contact 012 324 3071");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 33, 82));
        jLabel10.setText("Email");

        EmailRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        PasswordConfirmRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 33, 82));
        jLabel11.setText("Confirm Password");

        SignUpButton.setBackground(new java.awt.Color(196, 196, 196));
        SignUpButton.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        SignUpButton.setForeground(new java.awt.Color(30, 33, 82));
        SignUpButton.setText("Sign up");
        SignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUpButtonActionPerformed(evt);
            }
        });

        jPanel2.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 33, 82));
        jLabel12.setText("Already have an account ?");

        GoToLogInButton.setBackground(null);
        GoToLogInButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        GoToLogInButton.setForeground(new java.awt.Color(51, 51, 255));
        GoToLogInButton.setText("Log in here");
        GoToLogInButton.setBorder(null);
        GoToLogInButton.setContentAreaFilled(false);
        GoToLogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoToLogInButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GoToLogInButton))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(GoToLogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 33, 82));
        jLabel13.setText("Welcome to YOYO");

        PasswordRegisterField.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 33, 82));
        jLabel14.setText("Password");

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

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(277, 277, 277))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(351, 351, 351))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(121, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddressRegisterField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordRegisterField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PasswordConfirmRegisterField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SignUpButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel2Layout.createSequentialGroup()
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EmailRegisterField, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                    .addComponent(UsernameRegisterField))
                                .addGap(30, 30, 30)
                                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel2Layout.createSequentialGroup()
                                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PhoneRegisterField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(GenderRegisterField))))
                        .addGap(40, 40, 40))))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(26, 26, 26)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UsernameRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GenderRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmailRegisterField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(roundPanel2Layout.createSequentialGroup()
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
                .addComponent(SignUpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout RegisterCardLayout = new javax.swing.GroupLayout(RegisterCard);
        RegisterCard.setLayout(RegisterCardLayout);
        RegisterCardLayout.setHorizontalGroup(
            RegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterCardLayout.createSequentialGroup()
                .addContainerGap(333, Short.MAX_VALUE)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );
        RegisterCardLayout.setVerticalGroup(
            RegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterCardLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        WelcomeCards.add(RegisterCard, "RegisterCard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WelcomeCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(WelcomeCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        UserInputEmailOrPhone = EmailOrPhoneField.getText();
        UserInputPassword = PasswordField.getText();
        
        try {
            SecureFileHandler secureFileHandler = new SecureFileHandler();
            secureFileHandler.setFilePath("userInfo.txt");
            ArrayList<String[]> decryptedData = secureFileHandler.readAndDecryptLines(8);
            login.setUserInfo(decryptedData);
            login.setUserLoginInput(UserInputEmailOrPhone);
            login.setUserPasswordInput(UserInputPassword);
            User verifiedUser = login.loginCheck();

            if (verifiedUser != null) {
                dispose();
                verifiedUser.showDashboard(); 
                
            } else {
                System.out.println("User not found or invalid credentials.");

            }
        } catch (IOException e) {
            System.err.println("Error reading user information file: " + e.getMessage());
        } finally {
        }
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void SignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUpButtonActionPerformed
        userUsernameInput = UsernameRegisterField.getText();
        userGenderInput = GenderRegisterField.getText();
        userEmailInput = EmailRegisterField.getText();
        userPhoneInput = PhoneRegisterField.getText();
        userAddressInput = AddressRegisterField.getText();
        userRegisterPasswordInput = PasswordRegisterField.getText();
        userConfirmPasswordInput = PasswordConfirmRegisterField.getText();
        
        try {
            SecureFileHandler secureFileHandler = new SecureFileHandler();
            secureFileHandler.setFilePath("userInfo.txt");
            ArrayList<String[]> decryptedData = secureFileHandler.readAndDecryptLines(8);
            register.setUserInfo(decryptedData);
            register.setUserUsernameInput(userUsernameInput);
            register.setUserGenderInput(userGenderInput);
            register.setUserEmailInput(userEmailInput);
            register.setUserPhoneInput(userPhoneInput);
            register.setUserAddressInput(userAddressInput);
            register.setUserRegisterPasswordInput(userRegisterPasswordInput);
            register.setUserConfirmPasswordInput(userConfirmPasswordInput);
            User verifiedUser = register.registerCheck();

            if (verifiedUser != null) {
                dispose();
                verifiedUser.showDashboard();
                
            } else {
                System.out.println("Invalid signup credentials.");
            }
        } catch (IOException e) {
            System.err.println("Error reading user information file: " + e.getMessage());
        } finally {
        }
    }//GEN-LAST:event_SignUpButtonActionPerformed
    private void GoToLogInButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        cardLayoutWelcome.show(WelcomeCards,"LoginCard");
    }   
    private void GoToSignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        cardLayoutWelcome.show(WelcomeCards,"RegisterCard");
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressRegisterField;
    private javax.swing.JTextField EmailOrPhoneField;
    private javax.swing.JTextField EmailRegisterField;
    private javax.swing.JTextField GenderRegisterField;
    private javax.swing.JButton GoToLogInButton;
    private javax.swing.JButton GoToSignUpButton;
    private javax.swing.JButton LogInButton;
    private javax.swing.JPanel LoginCard;
    private javax.swing.JTextField PasswordConfirmRegisterField;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JTextField PasswordRegisterField;
    private javax.swing.JTextField PhoneRegisterField;
    private javax.swing.JPanel RegisterCard;
    private javax.swing.JButton SignUpButton;
    private javax.swing.JTextField UsernameRegisterField;
    private javax.swing.JPanel WelcomeCards;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private yoyo.resources.RoundPanel roundPanel1;
    private yoyo.resources.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
