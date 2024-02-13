package com.healthcare.healthcare.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.util.*;


@Entity
public class Patient {
    
    @Id
    private int id;

    private Date joiningDate;

    private boolean wants_doc;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @MapsId
    private User user;

    public Patient() {
    }

    public Patient(int id, Date joiningDate, boolean wants_doc, User user) {
        this.id = id;
        this.joiningDate = joiningDate;
        this.wants_doc = wants_doc;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public boolean isWants_doc() {
        return wants_doc;
    }

    public void setWants_doc(boolean wants_doc) {
        this.wants_doc = wants_doc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

}
