package com.healthcare.healthcare.Payloads;


import java.util.*;
public class ResponsePatients {
    
    private int id;
    private Date joiningDate;
    private boolean wants_doc;
    private ResponseUser user;
    private ResponseDoctor responseDoctor;
    public ResponsePatients() {
        this.joiningDate = new Date();
    }
    public ResponsePatients(int id, boolean wants_doc, ResponseUser user) {
        this.id = id;
        this.wants_doc = wants_doc;
        this.user = user;
    }
    
    public ResponsePatients(int id, Date joiningDate, boolean wants_doc, ResponseUser user,
            ResponseDoctor responseDoctor) {
        this.id = id;
        this.joiningDate = joiningDate;
        this.wants_doc = wants_doc;
        this.user = user;
        this.responseDoctor = responseDoctor;
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
        Date currentDate = new Date();
        this.joiningDate = currentDate;
    }
    public boolean isWants_doc() {
        return wants_doc;
    }
    public void setWants_doc(boolean wants_doc) {
        this.wants_doc = wants_doc;
    }
    public ResponseUser getUser() {
        return user;
    }
    public void setUser(ResponseUser user) {
        this.user = user;
    }
    
    @Override
    public String toString() {
        return "ResponsePatients [id=" + id + ", joiningDate=" + joiningDate + ", wants_doc=" + wants_doc + ", user="
                + user + "]";
    }
    public ResponseDoctor getResponseDoctor() {
        return responseDoctor;
    }
    public void setResponseDoctor(ResponseDoctor responseDoctor) {
        this.responseDoctor = responseDoctor;
    }
    
}
