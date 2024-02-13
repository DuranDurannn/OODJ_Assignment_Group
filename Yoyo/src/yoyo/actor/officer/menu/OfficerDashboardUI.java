
package yoyo.actor.officer.menu;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.UIManager;


public class OfficerDashboardUI extends javax.swing.JFrame {
    
    CardLayout cardLayout;
    public OfficerDashboardUI() {      
        initComponents(); 
        initButtonIcon();
        buttonMenu1.setSelected(true);
        cardLayout = (CardLayout)(ContentCards.getLayout());
    }
   
    
    //Imports icons
    public void initButtonIcon() {
        
        ImageIcon icon1 = new ImageIcon("dashboard.png");
        buttonMenu1.setIcon(icon1);
        
        ImageIcon icon2 = new ImageIcon("sales.png");
        buttonMenu2.setIcon(icon2);
        
        ImageIcon icon3 = new ImageIcon("report.png");
        buttonMenu3.setIcon(icon3);

        ImageIcon icon4 = new ImageIcon("profile.png");
        buttonMenu4.setIcon(icon4);
        
        ImageIcon icon5 = new ImageIcon("logout.png");
        buttonMenu5.setIcon(icon5);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OfficerDashboardBackground = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        roundPanel5 = new yoyo.resources.RoundPanel();
        buttonMenu1 = new yoyo.resources.ButtonMenu();
        buttonMenu2 = new yoyo.resources.ButtonMenu();
        buttonMenu3 = new yoyo.resources.ButtonMenu();
        buttonMenu4 = new yoyo.resources.ButtonMenu();
        buttonMenu5 = new yoyo.resources.ButtonMenu();
        roundPanel27 = new yoyo.resources.RoundPanel();
        imageAvatar20 = new yoyo.resources.ImageAvatar();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        ContentCards = new javax.swing.JPanel();
        SummaryCard = new javax.swing.JPanel();
        roundPanel17 = new yoyo.resources.RoundPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        roundPanel6 = new yoyo.resources.RoundPanel();
        jLabel3 = new javax.swing.JLabel();
        roundPanel12 = new yoyo.resources.RoundPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        roundPanel15 = new yoyo.resources.RoundPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        roundPanel16 = new yoyo.resources.RoundPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        SalesOrderCard = new javax.swing.JPanel();
        roundPanel1 = new yoyo.resources.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1280, 720));

        OfficerDashboardBackground.setBackground(new java.awt.Color(17, 17, 43));
        OfficerDashboardBackground.setPreferredSize(new java.awt.Dimension(1280, 720));

        Menu.setOpaque(false);

        roundPanel5.setBackground(new java.awt.Color(88, 89, 98));

        buttonMenu1.setText("Dashboard");
        buttonMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu1ActionPerformed(evt);
            }
        });

        buttonMenu2.setText("Sales Orders");
        buttonMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu2ActionPerformed(evt);
            }
        });

        buttonMenu3.setText("Reports");
        buttonMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu3ActionPerformed(evt);
            }
        });

        buttonMenu4.setText("Edit Profile");
        buttonMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu4ActionPerformed(evt);
            }
        });

        buttonMenu5.setText("Logout");
        buttonMenu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMenu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMenu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMenu3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonMenu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(buttonMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        roundPanel27.setBackground(new java.awt.Color(88, 89, 98));

        imageAvatar20.setForeground(new java.awt.Color(250, 250, 250));
        imageAvatar20.setBorderSize(4);
        imageAvatar20.setIcon(new javax.swing.ImageIcon("C:\\Users\\hewxi\\OneDrive\\Documents\\NetBeansProjects\\OODJ_Assignment_Group\\Yoyo\\profilePic.jpg")); // NOI18N

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(250, 250, 250));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Officer");
        jLabel54.setAlignmentX(0.5F);
        jLabel54.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(250, 250, 250));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Username");
        jLabel55.setAlignmentX(0.5F);
        jLabel55.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout roundPanel27Layout = new javax.swing.GroupLayout(roundPanel27);
        roundPanel27.setLayout(roundPanel27Layout);
        roundPanel27Layout.setHorizontalGroup(
            roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel27Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(imageAvatar20, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel27Layout.setVerticalGroup(
            roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel27Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(imageAvatar20, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel54)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(roundPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        ContentCards.setOpaque(false);
        ContentCards.setLayout(new java.awt.CardLayout());

        SummaryCard.setBackground(new java.awt.Color(200, 200, 30));
        SummaryCard.setOpaque(false);

        roundPanel17.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel17.setPreferredSize(new java.awt.Dimension(628, 382));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 33, 82));
        jLabel4.setText("Officer Dashboard");

        jTable2.setBackground(new java.awt.Color(246, 245, 249));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "UID", "Date", "Amount", "Status"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(30, 33, 82));
        jLabel28.setText("Recent Orders");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout roundPanel17Layout = new javax.swing.GroupLayout(roundPanel17);
        roundPanel17.setLayout(roundPanel17Layout);
        roundPanel17Layout.setHorizontalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(169, 169, 169)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );
        roundPanel17Layout.setVerticalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(219, 219, 219)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        roundPanel6.setBackground(new java.awt.Color(246, 245, 249));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 33, 82));
        jLabel3.setText("Summary");

        roundPanel12.setBackground(new java.awt.Color(254, 254, 254));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(30, 33, 82));
        jLabel23.setText("Total Revenue");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(30, 33, 82));
        jLabel25.setText("RM 696969");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(30, 33, 82));
        jLabel26.setText("From 696 sales");

        javax.swing.GroupLayout roundPanel12Layout = new javax.swing.GroupLayout(roundPanel12);
        roundPanel12.setLayout(roundPanel12Layout);
        roundPanel12Layout.setHorizontalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel12Layout.setVerticalGroup(
            roundPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel12Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26)
                .addGap(36, 36, 36))
        );

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(30, 33, 82));
        jLabel27.setText("Top Categories");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(30, 33, 82));
        jLabel39.setText("Find out the best performing categories here");

        roundPanel15.setBackground(new java.awt.Color(225, 242, 236));
        roundPanel15.setPreferredSize(new java.awt.Dimension(140, 140));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(30, 33, 82));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(30, 33, 82));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("38 units");
        jLabel35.setAlignmentX(0.5F);
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(30, 33, 82));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Category2");
        jLabel36.setAlignmentX(0.5F);
        jLabel36.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout roundPanel15Layout = new javax.swing.GroupLayout(roundPanel15);
        roundPanel15.setLayout(roundPanel15Layout);
        roundPanel15Layout.setHorizontalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addGroup(roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        roundPanel15Layout.setVerticalGroup(
            roundPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel15Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel35)
                .addGap(43, 43, 43)
                .addComponent(jLabel34))
        );

        roundPanel16.setBackground(new java.awt.Color(255, 243, 203));
        roundPanel16.setForeground(new java.awt.Color(30, 33, 82));
        roundPanel16.setPreferredSize(new java.awt.Dimension(140, 140));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(30, 33, 82));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Category1");
        jLabel37.setAlignmentX(0.5F);
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(30, 33, 82));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("45 units");
        jLabel38.setAlignmentX(0.5F);
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout roundPanel16Layout = new javax.swing.GroupLayout(roundPanel16);
        roundPanel16.setLayout(roundPanel16Layout);
        roundPanel16Layout.setHorizontalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addGroup(roundPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel16Layout.setVerticalGroup(
            roundPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel16Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout roundPanel6Layout = new javax.swing.GroupLayout(roundPanel6);
        roundPanel6.setLayout(roundPanel6Layout);
        roundPanel6Layout.setHorizontalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel6Layout.createSequentialGroup()
                        .addComponent(roundPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(roundPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(roundPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        roundPanel6Layout.setVerticalGroup(
            roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(roundPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(11, 11, 11)
                .addComponent(jLabel39)
                .addGap(18, 18, 18)
                .addGroup(roundPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout SummaryCardLayout = new javax.swing.GroupLayout(SummaryCard);
        SummaryCard.setLayout(SummaryCardLayout);
        SummaryCardLayout.setHorizontalGroup(
            SummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SummaryCardLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        SummaryCardLayout.setVerticalGroup(
            SummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
            .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentCards.add(SummaryCard, "Panel1");

        SalesOrderCard.setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(246, 245, 249));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout SalesOrderCardLayout = new javax.swing.GroupLayout(SalesOrderCard);
        SalesOrderCard.setLayout(SalesOrderCardLayout);
        SalesOrderCardLayout.setHorizontalGroup(
            SalesOrderCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SalesOrderCardLayout.setVerticalGroup(
            SalesOrderCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentCards.add(SalesOrderCard, "Panel2");

        javax.swing.GroupLayout OfficerDashboardBackgroundLayout = new javax.swing.GroupLayout(OfficerDashboardBackground);
        OfficerDashboardBackground.setLayout(OfficerDashboardBackgroundLayout);
        OfficerDashboardBackgroundLayout.setHorizontalGroup(
            OfficerDashboardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfficerDashboardBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ContentCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(OfficerDashboardBackgroundLayout.createSequentialGroup()
                .addGap(577, 577, 577)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OfficerDashboardBackgroundLayout.setVerticalGroup(
            OfficerDashboardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OfficerDashboardBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(OfficerDashboardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ContentCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OfficerDashboardBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OfficerDashboardBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu5ActionPerformed
        buttonMenu5.setSelected(true);
        buttonMenu1.setSelected(false);
        buttonMenu2.setSelected(false);
        buttonMenu3.setSelected(false);
        buttonMenu4.setSelected(false);   
    }//GEN-LAST:event_buttonMenu5ActionPerformed

    private void buttonMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu4ActionPerformed
        buttonMenu4.setSelected(true);
        buttonMenu1.setSelected(false);
        buttonMenu2.setSelected(false);
        buttonMenu3.setSelected(false);
        buttonMenu5.setSelected(false);
    }//GEN-LAST:event_buttonMenu4ActionPerformed

    private void buttonMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu3ActionPerformed
        buttonMenu3.setSelected(true);
        buttonMenu1.setSelected(false);
        buttonMenu2.setSelected(false);
        buttonMenu4.setSelected(false);
        buttonMenu5.setSelected(false);
    }//GEN-LAST:event_buttonMenu3ActionPerformed

    private void buttonMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu2ActionPerformed
        buttonMenu2.setSelected(true);
        buttonMenu1.setSelected(false);
        buttonMenu3.setSelected(false);
        buttonMenu4.setSelected(false);
        buttonMenu5.setSelected(false);
        cardLayout.show(ContentCards,"Panel2");
    }//GEN-LAST:event_buttonMenu2ActionPerformed

    private void buttonMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu1ActionPerformed
        buttonMenu1.setSelected(true);
        buttonMenu2.setSelected(false);
        buttonMenu3.setSelected(false);
        buttonMenu4.setSelected(false);
        buttonMenu5.setSelected(false);
        cardLayout.show(ContentCards,"Panel1");
    }//GEN-LAST:event_buttonMenu1ActionPerformed
    
    
    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel (new FlatIntelliJLaf()); 
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OfficerDashboardUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContentCards;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel OfficerDashboardBackground;
    private javax.swing.JPanel SalesOrderCard;
    private javax.swing.JPanel SummaryCard;
    private yoyo.resources.ButtonMenu buttonMenu1;
    private yoyo.resources.ButtonMenu buttonMenu2;
    private yoyo.resources.ButtonMenu buttonMenu3;
    private yoyo.resources.ButtonMenu buttonMenu4;
    private yoyo.resources.ButtonMenu buttonMenu5;
    private javax.swing.Box.Filler filler1;
    private yoyo.resources.ImageAvatar imageAvatar20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private yoyo.resources.RoundPanel roundPanel1;
    private yoyo.resources.RoundPanel roundPanel12;
    private yoyo.resources.RoundPanel roundPanel15;
    private yoyo.resources.RoundPanel roundPanel16;
    private yoyo.resources.RoundPanel roundPanel17;
    private yoyo.resources.RoundPanel roundPanel27;
    private yoyo.resources.RoundPanel roundPanel5;
    private yoyo.resources.RoundPanel roundPanel6;
    // End of variables declaration//GEN-END:variables
}
