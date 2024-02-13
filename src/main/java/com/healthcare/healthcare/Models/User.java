package com.healthcare.healthcare.Models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Demographics demographics;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Patient patient;

    public User() {
    }

    public User(int id, String username, String password, Role role, Demographics demographics, Patient patient) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.demographics = demographics;
        this.patient = patient;
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

    public Role getRoles() {
        return role;
    }

    public void setRoles(Role roles) {
        this.role = roles;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }
    

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", roles=" + role
                + ", demographics=" + demographics + "]";
    }

    

}
