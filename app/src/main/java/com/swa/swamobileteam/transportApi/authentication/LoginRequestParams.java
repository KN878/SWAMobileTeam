package com.swa.swamobileteam.transportApi.authentication;

public class LoginRequestParams {
    private String email;
    private String password;

    public LoginRequestParams(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
