package yoyo.actors;

import yoyo.application.Dashboard;

public class Officer extends User {

    private String accessLevel = "officer";

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