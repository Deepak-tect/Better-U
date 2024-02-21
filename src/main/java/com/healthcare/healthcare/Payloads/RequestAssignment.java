package com.healthcare.healthcare.Payloads;

import java.util.*;

public class RequestAssignment {
    private int id;
    private List<Integer> activity;
    private int item_level;
    private boolean completed;
    public RequestAssignment() {
    }
    public RequestAssignment(int id, List<Integer> activity, int item_level, boolean completed) {
        this.id = id;
        this.activity = activity;
        this.item_level = item_level;
        this.completed = completed;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Integer> getActivity() {
        return activity;
    }
    public void setActivity(List<Integer> activity) {
        this.activity = activity;
    }
    public int getItem_level() {
        return item_level;
    }
    public void setItem_level(int item_level) {
        this.item_level = item_level;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
}
