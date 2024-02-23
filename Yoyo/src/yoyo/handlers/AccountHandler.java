package yoyo.handlers;

import java.util.ArrayList;

public abstract class AccountHandler {
    public ArrayList<String[]> userInfo;
    
    public void setUserInfo(ArrayList<String[]> userInfo) {
    this.userInfo = userInfo;
    }
    
    public abstract yoyo.actors.User Check();
}
