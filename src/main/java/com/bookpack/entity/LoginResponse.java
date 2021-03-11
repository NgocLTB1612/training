package com.bookpack.entity;

public class LoginResponse {
    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;


    public void setToken(String token) {
        this.token = token;
    }

    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse() {
    }

//    public String getJwt() {
//        return jwt;
//    }
//
//    public void setJwt(String jwt) {
//        this.jwt = jwt;
//    }
}
