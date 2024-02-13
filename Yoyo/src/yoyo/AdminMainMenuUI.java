package yoyo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdminMainMenuUI extends javax.swing.JFrame {
    public AdminMainMenuUI() {
        initComponents();
        showCurrentUser();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        registerStaff_btn = new javax.swing.JButton();
        personalProfile_btn = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        manageEmployee_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        currentUser_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        jLabel1.setText("Admin Main Menu");

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        registerStaff_btn.setText("Register Staff");
        registerStaff_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerStaff_btnActionPerformed(evt);
            }
        });

        personalProfile_btn.setText("Personal Profile");
        personalProfile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalProfile_btnActionPerformed(evt);
            }
        });

        manageEmployee_btn.setText("Manage Employee");
        manageEmployee_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployee_btnActionPerformed(evt);
            }
        });

        jLabel2.setText("Current User:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(registerStaff_btn)
                        .addGap(65, 65, 65)
                        .addComponent(personalProfile_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(manageEmployee_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(logout_btn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentUser_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(currentUser_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerStaff_btn)
                    .addComponent(personalProfile_btn))
                .addGap(29, 29, 29)
                .addComponent(manageEmployee_btn)
                .addGap(26, 26, 26)
                .addComponent(logout_btn)
                .addGap(33, 33, 33)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void showCurrentUser() {
        try {
            File currentUser = new File("currentUser.txt");
            Scanner myReader = new Scanner(currentUser);
             while (myReader.hasNextLine()) {
                String current = myReader.nextLine();
                String[] currentactiveUser = current.split(",");
                currentUser_txt.setText(currentactiveUser[1]);
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        LoginUI LoginFrame = new LoginUI();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void registerStaff_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerStaff_btnActionPerformed
        EmployeeRegisterUI registerMenu = new EmployeeRegisterUI();
        registerMenu.setVisible(true);
        registerMenu.pack();
        registerMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_registerStaff_btnActionPerformed

    private void manageEmployee_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployee_btnActionPerformed
        ManageEmployeeProfile manageEmployeeMenu = new ManageEmployeeProfile();
        manageEmployeeMenu.setVisible(true);
        manageEmployeeMenu.pack();
        manageEmployeeMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_manageEmployee_btnActionPerformed

    private void personalProfile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalProfile_btnActionPerformed
        ManagePersonalProfile personalProfileMenu = new ManagePersonalProfile();
        personalProfileMenu.setVisible(true);
        personalProfileMenu.pack();
        personalProfileMenu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_personalProfile_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JTextField currentUser_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton manageEmployee_btn;
    private javax.swing.JButton personalProfile_btn;
    private javax.swing.JButton registerStaff_btn;
    // End of variables declaration//GEN-END:variables
}
