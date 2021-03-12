package com.bookpack.entity;

public class LoggedUser {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public LoggedUser(String username) {
        this.username = username;
    }
}
