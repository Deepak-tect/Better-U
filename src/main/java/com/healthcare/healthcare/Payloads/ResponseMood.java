package com.healthcare.healthcare.Payloads;

import java.util.*;

public class ResponseMood {
    private int id;
    private String mood;
    private String description;
    private Date date;
    public ResponseMood() {
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ResponseMood(int id, String mood, String description, Date date) {
        this.id = id;
        this.mood = mood;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMood() {
        return mood;
    }
    public void setMood(String mood) {
        this.mood = mood;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
}
