package yoyo.actors;

import yoyo.application.Dashboard;

public class Administrator extends User {

    private String accessLevel = "administrator";

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