package yoyo.application;

import java.awt.BorderLayout;
import yoyo.actors.User;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import yoyo.reports.ClosedSaleReport;
import yoyo.reports.Invoice;
import yoyo.reports.WorkDoneReport;


public class Dashboard extends javax.swing.JFrame {
    
    private CardLayout cardLayoutContent;
    private CardLayout cardLayoutButton;
    private User currentUser;
    private String imageLink;
    
    public User getCurrentUser() {
    return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    public Dashboard(User user) { 
        this.currentUser = user;
        
        imageLink = user.getProfileLink();
        initComponents(); 

// <editor-fold defaultstate="collapsed" desc="Address line splitting">

        String address = user.getAddress();
        String[] lines = address.split(",");
        StringBuilder htmlText = new StringBuilder("<html>");

        for (String line : lines) {
            htmlText.append(line.trim()).append("<br>");
        }

        htmlText.append("</html>");
        
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Set visual text elements">

        jLabel19.setText(htmlText.toString());

        jLabel55.setText(currentUser.getUsername());
        jLabel54.setText(currentUser.getAccessLevel());
        jLabel14.setText(currentUser.getUsername());
        jLabel21.setText(currentUser.getGender());
        jLabel16.setText(currentUser.getPhoneNumber());
        jLabel15.setText(currentUser.getEmail());
        
// </editor-fold>
        
// <editor-fold defaultstate="collapsed" desc="Button icon initialization">     

        ImageIcon icon1 = new ImageIcon("dashboard.png");
        buttonMenu1.setIcon(icon1);
        buttonMenu6.setIcon(icon1);
        buttonMenu10.setIcon(icon1);
        buttonMenu11.setIcon(icon1);
        
        ImageIcon icon2 = new ImageIcon("sales.png");
        buttonMenu2.setIcon(icon2);
        
        ImageIcon icon3 = new ImageIcon("report.png");
        buttonMenu3.setIcon(icon3);
        buttonMenu12.setIcon(icon3);

        ImageIcon icon4 = new ImageIcon("profile.png");
        buttonMenu4.setIcon(icon4);
        buttonMenu9.setIcon(icon4);
        buttonMenu13.setIcon(icon4);
        buttonMenu15.setIcon(icon4);
        
        ImageIcon icon5 = new ImageIcon("logout.png");
        buttonMenu5.setIcon(icon5);
        
// </editor-fold>        

// <editor-fold defaultstate="collapsed" desc="Graph call">

        Map<String, Double> monthlyRevenue = new LinkedHashMap<>();
        monthlyRevenue.put("Jan", 1000.0);
        monthlyRevenue.put("Feb", 1200.0);
        monthlyRevenue.put("Mar", 1500.0);
        monthlyRevenue.put("Apr", 1700.0);
        monthlyRevenue.put("May", 1800.0);
        monthlyRevenue.put("Jun", 1900.0);
        monthlyRevenue.put("Jul", 2000.0);
        monthlyRevenue.put("Aug", 2100.0);
        monthlyRevenue.put("Sep", 2200.0);
        monthlyRevenue.put("Oct", 2300.0);
        monthlyRevenue.put("Nov", 2400.0);
        monthlyRevenue.put("Dec", 2500.0);
        
        MonthlyRevenueGraph.setLayout(new BorderLayout());
        createLineChart(monthlyRevenue,MonthlyRevenueGraph, "Monthly Revenue Comparison", "Month", "Revenue(RM)");
        
        Map<String, Double> monthlyUnitsSold = new LinkedHashMap<>();
        monthlyUnitsSold.put("Jan", 15.0);
        monthlyUnitsSold.put("Feb", 17.0);
        monthlyUnitsSold.put("Mar", 18.0);
        monthlyUnitsSold.put("Apr", 16.0);
        monthlyUnitsSold.put("May", 20.0);
        monthlyUnitsSold.put("Jun", 36.0);
        monthlyUnitsSold.put("Jul", 21.0);
        monthlyUnitsSold.put("Aug", 38.0);
        monthlyUnitsSold.put("Sep", 43.0);
        monthlyUnitsSold.put("Oct", 55.0);
        monthlyUnitsSold.put("Nov", 67.0);
        monthlyUnitsSold.put("Dec", 75.0);
        
        MonthlyUnitsSoldGraph.setLayout(new BorderLayout());
        createLineChart(monthlyUnitsSold,MonthlyUnitsSoldGraph, "Monthly Units Sold Comparison", "Month", "UnitsSold");

// </editor-fold>    
        
// <editor-fold defaultstate="collapsed" desc="Show different dashboards"> 

        cardLayoutContent = (CardLayout)(ContentCards.getLayout()); 
        cardLayoutButton = (CardLayout)(ButtonCards.getLayout());    
        
        switch (currentUser.getAccessLevel()) { // handles access level behaviour
            case "officer" -> {
                cardLayoutContent.show(ContentCards,"OfficerSummaryCard");
                cardLayoutButton.show(ButtonCards,"OfficerButtonsCards");
                buttonMenu1.setSelected(true);
            }

            case "salesperson" -> {
                cardLayoutContent.show(ContentCards,"SalespersonSummaryCard");
                cardLayoutButton.show(ButtonCards,"SalespersonButtonsCards");
                buttonMenu6.setSelected(true);
            }                

            case "administrator" -> {
                cardLayoutContent.show(ContentCards,"AdministratorSummaryCard");
                cardLayoutButton.show(ButtonCards,"AdministratorButtonsCards");
                buttonMenu10.setSelected(true);
            }
            
            case "customer" -> {
                cardLayoutContent.show(ContentCards, "CustomerSummaryCard");
                cardLayoutButton.show(ButtonCards,"CustomerButtonsCards");
                buttonMenu11.setSelected(true);
            }

        }
    }
    
// </editor-fold>    
    
    private void createLineChart(Map<String, Double> monthlyRevenue, JPanel panel, String title, String xLabel, String yLabel) {

        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String month : monthlyRevenue.keySet()) {
            dataset.addValue(monthlyRevenue.get(month), "Revenue", month);
        }

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
            title,
            xLabel,
            yLabel,
            dataset,
            PlotOrientation.VERTICAL,
            false, // Include legend
            false, // Include tooltips
            false // No URL generator
        );

        // Customize chart (optional)
        customizeChart(chart); // Call a separate method for customization

        // Add chart to the panel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
    
    private void customizeChart(JFreeChart chart) {
        
        // Optional customizations
        chart.getPlot().setBackgroundPaint(new Color(246,245,249)); 
        
        // Add rounded corners to lines (optional)
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) chart.getCategoryPlot().getRenderer();
        renderer.setSeriesPaint(0, new Color(0, 128, 255)); // Set point color to blue
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6)); // Change shape to circle
        renderer.setBaseShapesVisible(true);
        renderer.setDrawOutlines(false);
        renderer.setUseFillPaint(true);
        renderer.setBaseFillPaint(new Color(0, 128, 255));
    }     
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DashboardBackground = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        roundPanel5 = new yoyo.resources.RoundPanel();
        buttonMenu5 = new yoyo.resources.ButtonMenu();
        ButtonCards = new javax.swing.JPanel();
        OfficerButtons = new javax.swing.JPanel();
        buttonMenu1 = new yoyo.resources.ButtonMenu();
        buttonMenu2 = new yoyo.resources.ButtonMenu();
        buttonMenu3 = new yoyo.resources.ButtonMenu();
        buttonMenu4 = new yoyo.resources.ButtonMenu();
        SalespersonButtons = new javax.swing.JPanel();
        buttonMenu6 = new yoyo.resources.ButtonMenu();
        buttonMenu9 = new yoyo.resources.ButtonMenu();
        AdministratorButtons = new javax.swing.JPanel();
        buttonMenu10 = new yoyo.resources.ButtonMenu();
        buttonMenu12 = new yoyo.resources.ButtonMenu();
        buttonMenu13 = new yoyo.resources.ButtonMenu();
        CustomerButtons = new javax.swing.JPanel();
        buttonMenu11 = new yoyo.resources.ButtonMenu();
        buttonMenu15 = new yoyo.resources.ButtonMenu();
        roundPanel27 = new yoyo.resources.RoundPanel();
        imageAvatar20 = new yoyo.resources.ImageAvatar();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        ContentCards = new javax.swing.JPanel();
        OfficerSummaryCard = new javax.swing.JPanel();
        roundPanel17 = new yoyo.resources.RoundPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        SearchQuotationButton2 = new javax.swing.JButton();
        GenerateInvoiceButton = new javax.swing.JButton();
        ReportCard = new javax.swing.JPanel();
        roundPanel3 = new yoyo.resources.RoundPanel();
        MonthlyRevenueGraph = new javax.swing.JPanel();
        MonthlyUnitsSoldGraph = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        GenerateClosedSaleReportButton = new javax.swing.JButton();
        GenerateWorkDoneReportButton = new javax.swing.JButton();
        AdministratorSummaryCard = new javax.swing.JPanel();
        roundPanel18 = new yoyo.resources.RoundPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        SearchQuotationButton = new javax.swing.JButton();
        ModifyQuotationButton = new javax.swing.JButton();
        ManagePersonalAccount = new javax.swing.JPanel();
        roundPanel19 = new yoyo.resources.RoundPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        imageAvatar21 = new yoyo.resources.ImageAvatar();
        EditProfileDetailsButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        SalespersonSummaryCard = new javax.swing.JPanel();
        roundPanel20 = new yoyo.resources.RoundPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        SearchQuotationButton1 = new javax.swing.JButton();
        ModifyQuotationButton1 = new javax.swing.JButton();
        roundPanel11 = new yoyo.resources.RoundPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jTextField10 = new javax.swing.JTextField();
        SearchItemsButton7 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        CustomerSummaryCard = new javax.swing.JPanel();
        roundPanel23 = new yoyo.resources.RoundPanel();
        SearchItemsButton = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        roundPanel2 = new yoyo.resources.RoundPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        SearchItemsButton1 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 800));

        DashboardBackground.setBackground(new java.awt.Color(17, 17, 43));

        Menu.setOpaque(false);

        roundPanel5.setBackground(new java.awt.Color(88, 89, 98));
        roundPanel5.setPreferredSize(new java.awt.Dimension(178, 441));

        buttonMenu5.setText("Logout");
        buttonMenu5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu5.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu5ActionPerformed(evt);
            }
        });

        ButtonCards.setOpaque(false);
        ButtonCards.setLayout(new java.awt.CardLayout());

        OfficerButtons.setBackground(new java.awt.Color(88, 89, 98));
        OfficerButtons.setOpaque(false);

        buttonMenu1.setText("Dashboard");
        buttonMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu1.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu1ActionPerformed(evt);
            }
        });

        buttonMenu2.setText("Sales Orders");
        buttonMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu2.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu2ActionPerformed(evt);
            }
        });

        buttonMenu3.setText("Reports");
        buttonMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu3.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu3ActionPerformed(evt);
            }
        });

        buttonMenu4.setText("Edit Profile");
        buttonMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu4.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OfficerButtonsLayout = new javax.swing.GroupLayout(OfficerButtons);
        OfficerButtons.setLayout(OfficerButtonsLayout);
        OfficerButtonsLayout.setHorizontalGroup(
            OfficerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(buttonMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(buttonMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(buttonMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        OfficerButtonsLayout.setVerticalGroup(
            OfficerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfficerButtonsLayout.createSequentialGroup()
                .addComponent(buttonMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 206, Short.MAX_VALUE))
        );

        ButtonCards.add(OfficerButtons, "OfficerButtonsCards");

        SalespersonButtons.setBackground(new java.awt.Color(88, 89, 98));
        SalespersonButtons.setOpaque(false);

        buttonMenu6.setText("Dashboard");
        buttonMenu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu6.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu6ActionPerformed(evt);
            }
        });

        buttonMenu9.setText("Edit Profile");
        buttonMenu9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu9.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SalespersonButtonsLayout = new javax.swing.GroupLayout(SalespersonButtons);
        SalespersonButtons.setLayout(SalespersonButtonsLayout);
        SalespersonButtonsLayout.setHorizontalGroup(
            SalespersonButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonMenu9, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(buttonMenu6, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        SalespersonButtonsLayout.setVerticalGroup(
            SalespersonButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalespersonButtonsLayout.createSequentialGroup()
                .addComponent(buttonMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );

        ButtonCards.add(SalespersonButtons, "SalespersonButtonsCards");

        AdministratorButtons.setBackground(new java.awt.Color(88, 89, 98));
        AdministratorButtons.setOpaque(false);

        buttonMenu10.setText("Dashboard");
        buttonMenu10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu10.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu10ActionPerformed(evt);
            }
        });

        buttonMenu12.setText("Reports");
        buttonMenu12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu12.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu12ActionPerformed(evt);
            }
        });

        buttonMenu13.setText("Edit Profile");
        buttonMenu13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu13.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdministratorButtonsLayout = new javax.swing.GroupLayout(AdministratorButtons);
        AdministratorButtons.setLayout(AdministratorButtonsLayout);
        AdministratorButtonsLayout.setHorizontalGroup(
            AdministratorButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonMenu13, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(buttonMenu12, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(buttonMenu10, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        AdministratorButtonsLayout.setVerticalGroup(
            AdministratorButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministratorButtonsLayout.createSequentialGroup()
                .addComponent(buttonMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 248, Short.MAX_VALUE))
        );

        ButtonCards.add(AdministratorButtons, "AdministratorButtonsCards");

        CustomerButtons.setBackground(new java.awt.Color(88, 89, 98));
        CustomerButtons.setOpaque(false);

        buttonMenu11.setText("Dashboard");
        buttonMenu11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu11.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu11ActionPerformed(evt);
            }
        });

        buttonMenu15.setText("Edit Profile");
        buttonMenu15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonMenu15.setPreferredSize(new java.awt.Dimension(179, 36));
        buttonMenu15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenu15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CustomerButtonsLayout = new javax.swing.GroupLayout(CustomerButtons);
        CustomerButtons.setLayout(CustomerButtonsLayout);
        CustomerButtonsLayout.setHorizontalGroup(
            CustomerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonMenu15, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
            .addComponent(buttonMenu11, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        CustomerButtonsLayout.setVerticalGroup(
            CustomerButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerButtonsLayout.createSequentialGroup()
                .addComponent(buttonMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 290, Short.MAX_VALUE))
        );

        ButtonCards.add(CustomerButtons, "CustomerButtonsCards");

        javax.swing.GroupLayout roundPanel5Layout = new javax.swing.GroupLayout(roundPanel5);
        roundPanel5.setLayout(roundPanel5Layout);
        roundPanel5Layout.setHorizontalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        roundPanel5Layout.setVerticalGroup(
            roundPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ButtonCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        roundPanel27.setBackground(new java.awt.Color(88, 89, 98));

        imageAvatar20.setForeground(new java.awt.Color(250, 250, 250));
        imageAvatar20.setBorderSize(4);
        imageAvatar20.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL(imageLink)
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());
        imageAvatar20.setPreferredSize(new java.awt.Dimension(122, 122));

        javax.swing.GroupLayout imageAvatar20Layout = new javax.swing.GroupLayout(imageAvatar20);
        imageAvatar20.setLayout(imageAvatar20Layout);
        imageAvatar20Layout.setHorizontalGroup(
            imageAvatar20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imageAvatar20Layout.setVerticalGroup(
            imageAvatar20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(250, 250, 250));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Access Level");
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
            .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel27Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(imageAvatar20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        roundPanel27Layout.setVerticalGroup(
            roundPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel27Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(imageAvatar20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jLabel55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel54)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(roundPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        ContentCards.setOpaque(false);
        ContentCards.setLayout(new java.awt.CardLayout());

        OfficerSummaryCard.setBackground(new java.awt.Color(200, 200, 30));
        OfficerSummaryCard.setOpaque(false);

        roundPanel17.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel17.setPreferredSize(new java.awt.Dimension(628, 382));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 33, 82));
        jLabel4.setText("Officer Dashboard");

        jTable2.setBackground(new java.awt.Color(246, 245, 249));
        jTable2.setForeground(new java.awt.Color(246, 245, 249));
        jTable2.getTableHeader().setBackground(new java.awt.Color(30, 33, 82));
        jTable2.getTableHeader().setForeground(new java.awt.Color(246, 245, 249));
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setShowGrid(false);
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

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 80)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 33, 82));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("69");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 33, 82));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pending Sales Approvals");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout roundPanel17Layout = new javax.swing.GroupLayout(roundPanel17);
        roundPanel17.setLayout(roundPanel17Layout);
        roundPanel17Layout.setHorizontalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(roundPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(191, 191, 191)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        roundPanel17Layout.setVerticalGroup(
            roundPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel17Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(57, 57, 57)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout OfficerSummaryCardLayout = new javax.swing.GroupLayout(OfficerSummaryCard);
        OfficerSummaryCard.setLayout(OfficerSummaryCardLayout);
        OfficerSummaryCardLayout.setHorizontalGroup(
            OfficerSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OfficerSummaryCardLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        OfficerSummaryCardLayout.setVerticalGroup(
            OfficerSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addComponent(roundPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentCards.add(OfficerSummaryCard, "OfficerSummaryCard");

        SalesOrderCard.setOpaque(false);

        roundPanel1.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel1.setPreferredSize(new java.awt.Dimension(810, 728));

        jTable1.setBackground(new java.awt.Color(246, 245, 249));
        jTable1.getTableHeader().setBackground(new java.awt.Color(30, 33, 82));
        jTable1.getTableHeader().setForeground(new java.awt.Color(246, 245, 249));
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 33, 82));
        jLabel9.setText("Sales Orders");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        SearchQuotationButton2.setBackground(new java.awt.Color(30, 33, 82));
        SearchQuotationButton2.setForeground(new java.awt.Color(255, 255, 255));
        SearchQuotationButton2.setText("Search");
        SearchQuotationButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchQuotationButton2ActionPerformed(evt);
            }
        });

        GenerateInvoiceButton.setBackground(new java.awt.Color(30, 33, 82));
        GenerateInvoiceButton.setForeground(new java.awt.Color(255, 255, 255));
        GenerateInvoiceButton.setText("Generate Invoice");
        GenerateInvoiceButton.setBorderPainted(false);
        GenerateInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateInvoiceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1049, Short.MAX_VALUE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SearchQuotationButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GenerateInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchQuotationButton2)
                    .addComponent(GenerateInvoiceButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SalesOrderCardLayout = new javax.swing.GroupLayout(SalesOrderCard);
        SalesOrderCard.setLayout(SalesOrderCardLayout);
        SalesOrderCardLayout.setHorizontalGroup(
            SalesOrderCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        SalesOrderCardLayout.setVerticalGroup(
            SalesOrderCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentCards.add(SalesOrderCard, "SalesOrderCard");

        ReportCard.setOpaque(false);

        roundPanel3.setBackground(new java.awt.Color(246, 245, 249));

        MonthlyRevenueGraph.setBackground(new java.awt.Color(255, 255, 0));
        MonthlyRevenueGraph.setPreferredSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout MonthlyRevenueGraphLayout = new javax.swing.GroupLayout(MonthlyRevenueGraph);
        MonthlyRevenueGraph.setLayout(MonthlyRevenueGraphLayout);
        MonthlyRevenueGraphLayout.setHorizontalGroup(
            MonthlyRevenueGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        MonthlyRevenueGraphLayout.setVerticalGroup(
            MonthlyRevenueGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MonthlyUnitsSoldGraph.setBackground(new java.awt.Color(255, 255, 0));
        MonthlyUnitsSoldGraph.setPreferredSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout MonthlyUnitsSoldGraphLayout = new javax.swing.GroupLayout(MonthlyUnitsSoldGraph);
        MonthlyUnitsSoldGraph.setLayout(MonthlyUnitsSoldGraphLayout);
        MonthlyUnitsSoldGraphLayout.setHorizontalGroup(
            MonthlyUnitsSoldGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        MonthlyUnitsSoldGraphLayout.setVerticalGroup(
            MonthlyUnitsSoldGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 33, 82));
        jLabel10.setText("Reports");

        GenerateClosedSaleReportButton.setBackground(new java.awt.Color(30, 33, 82));
        GenerateClosedSaleReportButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GenerateClosedSaleReportButton.setForeground(new java.awt.Color(255, 255, 255));
        GenerateClosedSaleReportButton.setText("Generate Closed Sale Report");
        GenerateClosedSaleReportButton.setBorderPainted(false);
        GenerateClosedSaleReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateClosedSaleReportButtonActionPerformed(evt);
            }
        });

        GenerateWorkDoneReportButton.setBackground(new java.awt.Color(30, 33, 82));
        GenerateWorkDoneReportButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        GenerateWorkDoneReportButton.setForeground(new java.awt.Color(255, 255, 255));
        GenerateWorkDoneReportButton.setText("Generate Work Done Report");
        GenerateWorkDoneReportButton.setBorderPainted(false);
        GenerateWorkDoneReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateWorkDoneReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel3Layout.createSequentialGroup()
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(MonthlyUnitsSoldGraph, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(GenerateClosedSaleReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MonthlyRevenueGraph, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(GenerateWorkDoneReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MonthlyUnitsSoldGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MonthlyRevenueGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenerateWorkDoneReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerateClosedSaleReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout ReportCardLayout = new javax.swing.GroupLayout(ReportCard);
        ReportCard.setLayout(ReportCardLayout);
        ReportCardLayout.setHorizontalGroup(
            ReportCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReportCardLayout.setVerticalGroup(
            ReportCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentCards.add(ReportCard, "ReportCard");

        AdministratorSummaryCard.setBackground(new java.awt.Color(200, 200, 30));
        AdministratorSummaryCard.setOpaque(false);

        roundPanel18.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel18.setPreferredSize(new java.awt.Dimension(628, 382));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 33, 82));
        jLabel7.setText("Administrator Dashboard");

        jTable3.setBackground(new java.awt.Color(246, 245, 249));
        jTable3.getTableHeader().setBackground(new java.awt.Color(30, 33, 82));
        jTable3.getTableHeader().setForeground(new java.awt.Color(246, 245, 249));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Info Field I Forgor", "Info Field I Forgor", "Info Field I Forgor", "Info Field I Forgor", "Info Field I Forgor"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        SearchQuotationButton.setBackground(new java.awt.Color(30, 33, 82));
        SearchQuotationButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchQuotationButton.setText("Search");
        SearchQuotationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchQuotationButtonActionPerformed(evt);
            }
        });

        ModifyQuotationButton.setBackground(new java.awt.Color(30, 33, 82));
        ModifyQuotationButton.setForeground(new java.awt.Color(255, 255, 255));
        ModifyQuotationButton.setText("Save Changes");
        ModifyQuotationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyQuotationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel18Layout = new javax.swing.GroupLayout(roundPanel18);
        roundPanel18.setLayout(roundPanel18Layout);
        roundPanel18Layout.setHorizontalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel18Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel18Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel18Layout.createSequentialGroup()
                        .addGroup(roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel18Layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchQuotationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(jLabel7))
                        .addComponent(ModifyQuotationButton)))
                .addGap(40, 40, 40))
        );
        roundPanel18Layout.setVerticalGroup(
            roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel18Layout.createSequentialGroup()
                .addGroup(roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel18Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel18Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModifyQuotationButton)
                            .addComponent(SearchQuotationButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout AdministratorSummaryCardLayout = new javax.swing.GroupLayout(AdministratorSummaryCard);
        AdministratorSummaryCard.setLayout(AdministratorSummaryCardLayout);
        AdministratorSummaryCardLayout.setHorizontalGroup(
            AdministratorSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        AdministratorSummaryCardLayout.setVerticalGroup(
            AdministratorSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );

        ContentCards.add(AdministratorSummaryCard, "AdministratorSummaryCard");

        ManagePersonalAccount.setBackground(new java.awt.Color(200, 200, 30));
        ManagePersonalAccount.setOpaque(false);

        roundPanel19.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel19.setPreferredSize(new java.awt.Dimension(628, 382));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 33, 82));
        jLabel6.setText("Edit Profile");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        imageAvatar21.setForeground(new java.awt.Color(30, 33, 82));
        imageAvatar21.setBorderSize(15);
        imageAvatar21.setIcon(new javax.swing.JLabel() {
            public javax.swing.Icon getIcon() {
                try {
                    return new javax.swing.ImageIcon(
                        new java.net.URL(imageLink)
                    );
                } catch (java.net.MalformedURLException e) {
                }
                return null;
            }
        }.getIcon());

        EditProfileDetailsButton.setBackground(new java.awt.Color(88, 89, 98));
        EditProfileDetailsButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EditProfileDetailsButton.setForeground(new java.awt.Color(255, 255, 255));
        EditProfileDetailsButton.setText("Edit Profile Details");
        EditProfileDetailsButton.setBorderPainted(false);
        EditProfileDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditProfileDetailsButtonActionPerformed(evt);
            }
        });

        jPanel5.setOpaque(false);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 33, 82));
        jLabel14.setText("Username");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 33, 82));
        jLabel11.setText("Username");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(30, 33, 82));
        jLabel16.setText("+6012-2314122");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 33, 82));
        jLabel12.setText("Phone");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(30, 33, 82));
        jLabel20.setText("Gender");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(30, 33, 82));
        jLabel21.setText("Gender");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 33, 82));
        jLabel13.setText("Email");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 33, 82));
        jLabel15.setText("email@gmail.com");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(30, 33, 82));
        jLabel19.setText("27 Jln Seksyen 1/26, ");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(30, 33, 82));
        jLabel17.setText("Address");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 42, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel15))
                .addGap(48, 48, 48)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(189, 189, 189))
        );

        javax.swing.GroupLayout roundPanel19Layout = new javax.swing.GroupLayout(roundPanel19);
        roundPanel19.setLayout(roundPanel19Layout);
        roundPanel19Layout.setHorizontalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel19Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(191, 191, 191)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(roundPanel19Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(imageAvatar21, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
                .addGap(76, 76, 76)
                .addGroup(roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EditProfileDetailsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        roundPanel19Layout.setVerticalGroup(
            roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel19Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(roundPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel19Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 408, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EditProfileDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageAvatar21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(133, 133, 133))
        );

        javax.swing.GroupLayout ManagePersonalAccountLayout = new javax.swing.GroupLayout(ManagePersonalAccount);
        ManagePersonalAccount.setLayout(ManagePersonalAccountLayout);
        ManagePersonalAccountLayout.setHorizontalGroup(
            ManagePersonalAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
        );
        ManagePersonalAccountLayout.setVerticalGroup(
            ManagePersonalAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );

        ContentCards.add(ManagePersonalAccount, "ManagePersonalAccountCard");

        SalespersonSummaryCard.setBackground(new java.awt.Color(200, 200, 30));
        SalespersonSummaryCard.setOpaque(false);

        roundPanel20.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel20.setPreferredSize(new java.awt.Dimension(628, 382));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 33, 82));
        jLabel8.setText("Salesperson Dashboard");

        jTable4.setBackground(new java.awt.Color(246, 245, 249));
        jTable4.getTableHeader().setBackground(new java.awt.Color(30, 33, 82));
        jTable4.getTableHeader().setForeground(new java.awt.Color(246, 245, 249));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sales ID", "Date", "Amount", "Status"
            }
        ));
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(1).setHeaderValue("Date");
            jTable4.getColumnModel().getColumn(2).setHeaderValue("Amount");
            jTable4.getColumnModel().getColumn(3).setHeaderValue("Status");
        }

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        SearchQuotationButton1.setBackground(new java.awt.Color(30, 33, 82));
        SearchQuotationButton1.setForeground(new java.awt.Color(255, 255, 255));
        SearchQuotationButton1.setText("Search");
        SearchQuotationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchQuotationButton1ActionPerformed(evt);
            }
        });

        ModifyQuotationButton1.setBackground(new java.awt.Color(30, 33, 82));
        ModifyQuotationButton1.setForeground(new java.awt.Color(255, 255, 255));
        ModifyQuotationButton1.setText("Save Changes");
        ModifyQuotationButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyQuotationButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel20Layout = new javax.swing.GroupLayout(roundPanel20);
        roundPanel20.setLayout(roundPanel20Layout);
        roundPanel20Layout.setHorizontalGroup(
            roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel20Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(roundPanel20Layout.createSequentialGroup()
                        .addGroup(roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel20Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchQuotationButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(jLabel8))
                        .addComponent(ModifyQuotationButton1)))
                .addGap(40, 40, 40))
        );
        roundPanel20Layout.setVerticalGroup(
            roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel20Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModifyQuotationButton1)
                    .addComponent(SearchQuotationButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        roundPanel11.setBackground(new java.awt.Color(246, 245, 249));

        jTable13.setBackground(new java.awt.Color(246, 245, 249));
        jTable13.setForeground(new java.awt.Color(246, 245, 249));
        jTable13.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(jTable13);

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        SearchItemsButton7.setBackground(new java.awt.Color(30, 33, 82));
        SearchItemsButton7.setForeground(new java.awt.Color(255, 255, 255));
        SearchItemsButton7.setText("Search");
        SearchItemsButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemsButton7ActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(30, 33, 82));
        jLabel41.setText("Sale Orders");

        javax.swing.GroupLayout roundPanel11Layout = new javax.swing.GroupLayout(roundPanel11);
        roundPanel11.setLayout(roundPanel11Layout);
        roundPanel11Layout.setHorizontalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel11Layout.createSequentialGroup()
                        .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel11Layout.createSequentialGroup()
                                .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchItemsButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        roundPanel11Layout.setVerticalGroup(
            roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel11Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchItemsButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout SalespersonSummaryCardLayout = new javax.swing.GroupLayout(SalespersonSummaryCard);
        SalespersonSummaryCard.setLayout(SalespersonSummaryCardLayout);
        SalespersonSummaryCardLayout.setHorizontalGroup(
            SalespersonSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalespersonSummaryCardLayout.createSequentialGroup()
                .addComponent(roundPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(roundPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SalespersonSummaryCardLayout.setVerticalGroup(
            SalespersonSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
            .addComponent(roundPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentCards.add(SalespersonSummaryCard, "SalespersonSummaryCard");

        CustomerSummaryCard.setBackground(new java.awt.Color(200, 200, 30));
        CustomerSummaryCard.setOpaque(false);

        roundPanel23.setBackground(new java.awt.Color(246, 245, 249));
        roundPanel23.setPreferredSize(new java.awt.Dimension(628, 382));

        SearchItemsButton.setBackground(new java.awt.Color(30, 33, 82));
        SearchItemsButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchItemsButton.setText("Search");
        SearchItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemsButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 33, 82));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Please contact sales personel or call us at 012 324 3071 to make a purchase");

        jTable7.setBackground(new java.awt.Color(246, 245, 249));
        jTable7.getTableHeader().setBackground(new java.awt.Color(30, 33, 82));
        jTable7.getTableHeader().setForeground(new java.awt.Color(246, 245, 249));
        jTable7.setForeground(new java.awt.Color(246, 245, 249));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable7);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(30, 33, 82));
        jLabel29.setText("Shop Catalogue");

        javax.swing.GroupLayout roundPanel23Layout = new javax.swing.GroupLayout(roundPanel23);
        roundPanel23.setLayout(roundPanel23Layout);
        roundPanel23Layout.setHorizontalGroup(
            roundPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel23Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel23Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel23Layout.createSequentialGroup()
                        .addGroup(roundPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel23Layout.createSequentialGroup()
                                .addComponent(jTextField3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchItemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
        );
        roundPanel23Layout.setVerticalGroup(
            roundPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel23Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchItemsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(40, 40, 40))
        );

        roundPanel2.setBackground(new java.awt.Color(246, 245, 249));

        jTable6.setBackground(new java.awt.Color(246, 245, 249));
        jTable6.getTableHeader().setBackground(new java.awt.Color(30, 33, 82));
        jTable6.getTableHeader().setForeground(new java.awt.Color(246, 245, 249));
        jTable6.setForeground(new java.awt.Color(246, 245, 249));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable6);

        jTextField4.setText("Search Ongoing Orders");

        SearchItemsButton1.setBackground(new java.awt.Color(30, 33, 82));
        SearchItemsButton1.setForeground(new java.awt.Color(255, 255, 255));
        SearchItemsButton1.setText("Search");
        SearchItemsButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemsButton1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(30, 33, 82));
        jLabel24.setText("My Orders");

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundPanel2Layout.createSequentialGroup()
                        .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchItemsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchItemsButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout CustomerSummaryCardLayout = new javax.swing.GroupLayout(CustomerSummaryCard);
        CustomerSummaryCard.setLayout(CustomerSummaryCardLayout);
        CustomerSummaryCardLayout.setHorizontalGroup(
            CustomerSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerSummaryCardLayout.createSequentialGroup()
                .addComponent(roundPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CustomerSummaryCardLayout.setVerticalGroup(
            CustomerSummaryCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
            .addComponent(roundPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ContentCards.add(CustomerSummaryCard, "CustomerSummaryCard");

        javax.swing.GroupLayout DashboardBackgroundLayout = new javax.swing.GroupLayout(DashboardBackground);
        DashboardBackground.setLayout(DashboardBackgroundLayout);
        DashboardBackgroundLayout.setHorizontalGroup(
            DashboardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ContentCards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        DashboardBackgroundLayout.setVerticalGroup(
            DashboardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardBackgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DashboardBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ContentCards, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        dispose();
        new LoginRegisterUI().setVisible(true);
    }//GEN-LAST:event_buttonMenu5ActionPerformed

    private void GenerateClosedSaleReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateClosedSaleReportButtonActionPerformed
        new ClosedSaleReport().setVisible(true);
    }//GEN-LAST:event_GenerateClosedSaleReportButtonActionPerformed

    private void GenerateWorkDoneReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateWorkDoneReportButtonActionPerformed
        new WorkDoneReport().setVisible(true);
    }//GEN-LAST:event_GenerateWorkDoneReportButtonActionPerformed

    private void buttonMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu4ActionPerformed
        buttonMenu4.setSelected(true);
        buttonMenu1.setSelected(false);
        buttonMenu2.setSelected(false);
        buttonMenu3.setSelected(false);
        buttonMenu5.setSelected(false);
        cardLayoutContent.show(ContentCards,"ManagePersonalAccountCard");
    }//GEN-LAST:event_buttonMenu4ActionPerformed

    private void buttonMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu3ActionPerformed
        buttonMenu3.setSelected(true);
        buttonMenu1.setSelected(false);
        buttonMenu2.setSelected(false);
        buttonMenu4.setSelected(false);
        buttonMenu5.setSelected(false);
        cardLayoutContent.show(ContentCards,"ReportCard");
    }//GEN-LAST:event_buttonMenu3ActionPerformed

    private void buttonMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu2ActionPerformed
        buttonMenu2.setSelected(true);
        buttonMenu1.setSelected(false);
        buttonMenu3.setSelected(false);
        buttonMenu4.setSelected(false);
        buttonMenu5.setSelected(false);
        cardLayoutContent.show(ContentCards,"SalesOrderCard");
    }//GEN-LAST:event_buttonMenu2ActionPerformed

    private void buttonMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu1ActionPerformed
        buttonMenu1.setSelected(true);
        buttonMenu2.setSelected(false);
        buttonMenu3.setSelected(false);
        buttonMenu4.setSelected(false);
        buttonMenu5.setSelected(false);
        cardLayoutContent.show(ContentCards,"OfficerDashboardCard");
    }//GEN-LAST:event_buttonMenu1ActionPerformed

    private void ModifyQuotationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyQuotationButtonActionPerformed

    }//GEN-LAST:event_ModifyQuotationButtonActionPerformed

    private void SearchQuotationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchQuotationButtonActionPerformed

    }//GEN-LAST:event_SearchQuotationButtonActionPerformed

    private void GenerateInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateInvoiceButtonActionPerformed
        new Invoice().setVisible(true);
    }//GEN-LAST:event_GenerateInvoiceButtonActionPerformed

    private void EditProfileDetailsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditProfileDetailsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditProfileDetailsButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void SearchQuotationButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchQuotationButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchQuotationButton1ActionPerformed

    private void ModifyQuotationButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyQuotationButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModifyQuotationButton1ActionPerformed

    private void buttonMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu6ActionPerformed
        buttonMenu6.setSelected(true);
        buttonMenu9.setSelected(false);
        cardLayoutContent.show(ContentCards,"SalespersonSummaryCard");
    }//GEN-LAST:event_buttonMenu6ActionPerformed

    private void buttonMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu9ActionPerformed
        buttonMenu6.setSelected(false);
        buttonMenu9.setSelected(true);
        cardLayoutContent.show(ContentCards,"ManagePersonalAccountCard");
    }//GEN-LAST:event_buttonMenu9ActionPerformed

    private void buttonMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu10ActionPerformed
        buttonMenu10.setSelected(true);
        buttonMenu12.setSelected(false);
        buttonMenu13.setSelected(false);
        cardLayoutContent.show(ContentCards,"AdministratorSummaryCard");
    }//GEN-LAST:event_buttonMenu10ActionPerformed

    private void buttonMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu12ActionPerformed
        buttonMenu12.setSelected(true);
        buttonMenu10.setSelected(false);
        buttonMenu13.setSelected(false);
        cardLayoutContent.show(ContentCards,"ReportCard");
    }//GEN-LAST:event_buttonMenu12ActionPerformed

    private void buttonMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu13ActionPerformed
        buttonMenu13.setSelected(true);
        buttonMenu10.setSelected(false);
        buttonMenu12.setSelected(false);
        cardLayoutContent.show(ContentCards,"ManagePersonalAccountCard");
    }//GEN-LAST:event_buttonMenu13ActionPerformed

    private void buttonMenu11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu11ActionPerformed
        buttonMenu11.setSelected(true);
        buttonMenu15.setSelected(false);
        cardLayoutContent.show(ContentCards,"SalespersonSummaryCard");
    }//GEN-LAST:event_buttonMenu11ActionPerformed

    private void buttonMenu15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenu15ActionPerformed
        buttonMenu15.setSelected(true);
        buttonMenu11.setSelected(false);
        cardLayoutContent.show(ContentCards,"ManagePersonalAccountCard");
    }//GEN-LAST:event_buttonMenu15ActionPerformed

    private void SearchItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchItemsButtonActionPerformed

    private void SearchItemsButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemsButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchItemsButton1ActionPerformed

    private void SearchItemsButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemsButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchItemsButton7ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void SearchQuotationButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchQuotationButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchQuotationButton2ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdministratorButtons;
    private javax.swing.JPanel AdministratorSummaryCard;
    private javax.swing.JPanel ButtonCards;
    private javax.swing.JPanel ContentCards;
    private javax.swing.JPanel CustomerButtons;
    private javax.swing.JPanel CustomerSummaryCard;
    private javax.swing.JPanel DashboardBackground;
    private javax.swing.JButton EditProfileDetailsButton;
    private javax.swing.JButton GenerateClosedSaleReportButton;
    private javax.swing.JButton GenerateInvoiceButton;
    private javax.swing.JButton GenerateWorkDoneReportButton;
    private javax.swing.JPanel ManagePersonalAccount;
    private javax.swing.JPanel Menu;
    private javax.swing.JButton ModifyQuotationButton;
    private javax.swing.JButton ModifyQuotationButton1;
    private javax.swing.JPanel MonthlyRevenueGraph;
    private javax.swing.JPanel MonthlyUnitsSoldGraph;
    private javax.swing.JPanel OfficerButtons;
    private javax.swing.JPanel OfficerSummaryCard;
    private javax.swing.JPanel ReportCard;
    private javax.swing.JPanel SalesOrderCard;
    private javax.swing.JPanel SalespersonButtons;
    private javax.swing.JPanel SalespersonSummaryCard;
    private javax.swing.JButton SearchItemsButton;
    private javax.swing.JButton SearchItemsButton1;
    private javax.swing.JButton SearchItemsButton7;
    private javax.swing.JButton SearchQuotationButton;
    private javax.swing.JButton SearchQuotationButton1;
    private javax.swing.JButton SearchQuotationButton2;
    private yoyo.resources.ButtonMenu buttonMenu1;
    private yoyo.resources.ButtonMenu buttonMenu10;
    private yoyo.resources.ButtonMenu buttonMenu11;
    private yoyo.resources.ButtonMenu buttonMenu12;
    private yoyo.resources.ButtonMenu buttonMenu13;
    private yoyo.resources.ButtonMenu buttonMenu15;
    private yoyo.resources.ButtonMenu buttonMenu2;
    private yoyo.resources.ButtonMenu buttonMenu3;
    private yoyo.resources.ButtonMenu buttonMenu4;
    private yoyo.resources.ButtonMenu buttonMenu5;
    private yoyo.resources.ButtonMenu buttonMenu6;
    private yoyo.resources.ButtonMenu buttonMenu9;
    private yoyo.resources.ImageAvatar imageAvatar20;
    private yoyo.resources.ImageAvatar imageAvatar21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private yoyo.resources.RoundPanel roundPanel1;
    private yoyo.resources.RoundPanel roundPanel11;
    private yoyo.resources.RoundPanel roundPanel12;
    private yoyo.resources.RoundPanel roundPanel15;
    private yoyo.resources.RoundPanel roundPanel16;
    private yoyo.resources.RoundPanel roundPanel17;
    private yoyo.resources.RoundPanel roundPanel18;
    private yoyo.resources.RoundPanel roundPanel19;
    private yoyo.resources.RoundPanel roundPanel2;
    private yoyo.resources.RoundPanel roundPanel20;
    private yoyo.resources.RoundPanel roundPanel23;
    private yoyo.resources.RoundPanel roundPanel27;
    private yoyo.resources.RoundPanel roundPanel3;
    private yoyo.resources.RoundPanel roundPanel5;
    private yoyo.resources.RoundPanel roundPanel6;
    // End of variables declaration//GEN-END:variables
}
