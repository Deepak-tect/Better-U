package com.healthcare.healthcare.Payloads;

import java.util.*;

public class ResponseAssignment {
    private int id;
    private ResponseDoctor doctor;
    private List<ResponseAssignmentActivity> activities = new ArrayList<>();
    
    public ResponseAssignment() {
    }
    public ResponseAssignment(int id, ResponseDoctor doctor,
            List<ResponseAssignmentActivity> activities) {
        this.id = id;
        
        this.doctor = doctor;
        this.activities = activities;
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    } 
    public ResponseDoctor getDoctor() {
        return doctor;
    }
    public void setDoctor(ResponseDoctor doctor) {
        this.doctor = doctor;
    }
    public List<ResponseAssignmentActivity> getActivities() {
        return activities;
    }
    public void setActivities(List<ResponseAssignmentActivity> activities) {
        this.activities = activities;
    }
    
}
