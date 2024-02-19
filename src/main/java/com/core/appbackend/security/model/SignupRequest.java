package com.core.appbackend.security.model;

public class SignupRequest {
    private String userName;

    private String password;

    public SignupRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
