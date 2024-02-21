package com.healthcare.healthcare.Payloads;


public class ResponseAssignmentActivity {
    private int id;
    private ResponseActivity responseActivity;
    private int item_level;
    private boolean completed;
    public ResponseAssignmentActivity() {
    }
    public ResponseAssignmentActivity(int id, ResponseActivity responseActivity, int item_level, boolean completed) {
        this.id = id;
        this.responseActivity = responseActivity;
        this.item_level = item_level;
        this.completed = completed;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ResponseActivity getResponseActivity() {
        return responseActivity;
    }
    public void setResponseActivity(ResponseActivity responseActivity) {
        this.responseActivity = responseActivity;
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
