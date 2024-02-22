package yoyo.actors;

import yoyo.application.Dashboard;

public class SalesPerson extends User {
    
    private String accessLevel = "salesperson";
    
    @Override
    public String getAccessLevel() {
        return accessLevel;
    }
    
    @Override
    public void showDashboard() {
        Dashboard dashboard = new Dashboard(this);
        dashboard.setVisible(true);
    }
}
