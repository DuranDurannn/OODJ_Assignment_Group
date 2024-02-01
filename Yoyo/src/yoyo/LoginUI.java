/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package yoyo;

/**
 *
 * @author Eow
 */
public class LoginUI extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public LoginUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        right = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        email_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JTextField();
        password_lbl = new javax.swing.JLabel();
        email_lbl = new javax.swing.JLabel();
        login_btn = new javax.swing.JButton();
        register_btn = new javax.swing.JButton();
        login_lbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        staff_btn = new javax.swing.JButton();
        staff_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        right.setBackground(new java.awt.Color(0, 0, 0));
        right.setPreferredSize(new java.awt.Dimension(400, 500));

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jPanel1.add(right);
        right.setBounds(0, 0, 400, 500);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        email_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_txtActionPerformed(evt);
            }
        });

        password_lbl.setText("Password:");

        email_lbl.setText("Email:");

        login_btn.setText("Login");
        login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_btnActionPerformed(evt);
            }
        });

        register_btn.setText("Register");
        register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btnActionPerformed(evt);
            }
        });

        login_lbl.setFont(new java.awt.Font("Devanagari Sangam MN", 1, 36)); // NOI18N
        login_lbl.setText("Login");

        jLabel1.setText("Don't have an account? Register here!");

        staff_btn.setText("Login here");
        staff_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staff_btnActionPerformed(evt);
            }
        });

        staff_lbl.setText("Already a staff?");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(staff_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(staff_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(login_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(password_txt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(email_txt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(register_btn))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(login_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_btn)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(email_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(login_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(staff_btn)
                    .addComponent(staff_lbl))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(440, 30, 330, 440);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_btnActionPerformed
        RegisterUI RegisterFrame = new RegisterUI();
        RegisterFrame.setVisible(true);
        RegisterFrame.pack();
        RegisterFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_register_btnActionPerformed

    private void login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_btnActionPerformed
        String userEmail = email_txt.getText();
        String userPassword = password_txt.getText();
        if (Authentication.authenticateUser(userEmail, userPassword)) {
            // If authentication is successful, navigate to the MainMenu
            MainMenuUI mainMenu = new MainMenuUI();
            mainMenu.setVisible(true);
            mainMenu.pack();
            mainMenu.setLocationRelativeTo(null);
            this.dispose(); // Close the Login frame
        } else {
            // If authentication fails, display an error message or handle it accordingly
            System.out.println("Invalid email or password. Please try again.");
        }
    
        
    
    }//GEN-LAST:event_login_btnActionPerformed

    private void staff_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staff_btnActionPerformed
        EmployeeLoginUI EmployeeLoginFrame = new EmployeeLoginUI();
        EmployeeLoginFrame.setVisible(true);
        EmployeeLoginFrame.pack();
        EmployeeLoginFrame.setLocationRelativeTo(null);
        this.dispose();      
    }//GEN-LAST:event_staff_btnActionPerformed

    private void email_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_txtActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email_lbl;
    private javax.swing.JTextField email_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login_btn;
    private javax.swing.JLabel login_lbl;
    private javax.swing.JLabel password_lbl;
    private javax.swing.JTextField password_txt;
    private javax.swing.JButton register_btn;
    private javax.swing.JPanel right;
    private javax.swing.JButton staff_btn;
    private javax.swing.JLabel staff_lbl;
    // End of variables declaration//GEN-END:variables
}
