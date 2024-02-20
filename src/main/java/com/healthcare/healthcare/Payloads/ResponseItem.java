package com.healthcare.healthcare.Payloads;

public class ResponseItem {
    private int id;
    private String type;
    private ResponseActivity activity;
    public ResponseItem() {
    }
    public ResponseItem(int id, String type, ResponseActivity activity) {
        this.id = id;
        this.type = type;
        this.activity = activity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ResponseActivity getActivity() {
        return activity;
    }
    public void setActivity(ResponseActivity activity) {
        this.activity = activity;
    }
    

    
}
