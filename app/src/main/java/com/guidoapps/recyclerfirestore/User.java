package com.guidoapps.recyclerfirestore;

public class User {
    String userName;
    String userStatus;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public User(String userName, String userStatus) {
        this.userName = userName;
        this.userStatus = userStatus;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserStatus() {
        return userStatus;
    }
}
