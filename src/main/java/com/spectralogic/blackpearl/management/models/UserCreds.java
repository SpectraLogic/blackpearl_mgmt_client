package com.spectralogic.blackpearl.management.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserCreds {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUserAndPass(final String user, final String pass) {this.username = user; this.password = pass;}

}
