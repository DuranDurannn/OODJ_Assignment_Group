package yoyo.actors;

import yoyo.application.Dashboard;

public class Customer extends User {

    private String accessLevel = "customer";

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