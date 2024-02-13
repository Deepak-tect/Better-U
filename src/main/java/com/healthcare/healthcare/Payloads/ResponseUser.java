package com.healthcare.healthcare.Payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class ResponseUser {
    @NotEmpty
    private int id;
    @NotEmpty
    @Email(message = "Email address is not valid")
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotEmpty
    private String password;
    @NotEmpty
    private int role;
    private ResponseDemographics demographics;
    public ResponseUser() {
    }
    public ResponseUser(int id, String username, String password, int role, ResponseDemographics demographics) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.demographics = demographics;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
    public ResponseDemographics getDemographics() {
        return demographics;
    }
    public void setDemographics(ResponseDemographics demographics) {
        this.demographics = demographics;
    }
    @Override
    public String toString() {
        return "ResponseUser [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
                + ", demographics=" + demographics + "]";
    }
    
    
}
