package com.healthcare.healthcare.Payloads;

import java.util.*;
public class ResponseActivity {
    private int id;

    private String name;
    
    private String description;

    private List<ResponseQuestion> questions = new ArrayList<>();


    public ResponseActivity() {
    }

    public ResponseActivity(int id, String name, String description, List<ResponseQuestion> questions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ResponseQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<ResponseQuestion> questions) {
        this.questions = questions;
    }
    
    

}
