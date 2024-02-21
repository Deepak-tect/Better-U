package com.healthcare.healthcare.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AssignmentActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Assignment assignment;

    @ManyToOne
    private Activity activity;

    private int item_level;

    private boolean completed;

    public AssignmentActivity() {
    }

    public AssignmentActivity(int id, Assignment assignment, Activity activity, int item_level, boolean completed) {
        this.id = id;
        this.assignment = assignment;
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

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
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
