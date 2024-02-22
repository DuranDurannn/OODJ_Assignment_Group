
import java.awt.CardLayout;
import javax.swing.ImageIcon;

        this.cardLayoutContent = new CardLayout();
        this.cardLayoutButton = new CardLayout();
        this.currentUser = user;
        imageLink = user.getProfileLink();
        initComponents(); 

        String address = user.getAddress();
        String[] lines = address.split(","); // Split the address by commas

        // Create a StringBuilder to build the HTML-formatted text
        StringBuilder htmlText = new StringBuilder("<html>");

        // Append each line with a <br> tag to create a new line
        for (String line : lines) {
            htmlText.append(line.trim()).append("<br>");
        }

        // Close the HTML tag
        htmlText.append("</html>");

        // Set the HTML-formatted text to the JLabel
        jLabel19.setText(htmlText.toString());

        jLabel55.setText(currentUser.getUsername());
        jLabel54.setText(currentUser.getAccessLevel());
        jLabel14.setText(currentUser.getUsername());
        jLabel21.setText(currentUser.getGender());
        jLabel16.setText(currentUser.getPhoneNumber());
        jLabel15.setText(currentUser.getEmail());
                
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
        
        System.out.println(currentUser);
        
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
                cardLayoutContent.show(ContentCards,"CustomerSummaryCard");
                cardLayoutButton.show(ButtonCards,"CustomerButtonsCards");
                buttonMenu11.setSelected(true);
            }

        }