package com.healthcare.healthcare.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class Assignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentActivity> assignmentActivities = new ArrayList<>();
    

    public Assignment() {
    }


    public Assignment(int id, Patient patient, Doctor doctor, List<AssignmentActivity> assignmentActivities) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.assignmentActivities = assignmentActivities;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    public Doctor getDoctor() {
        return doctor;
    }


    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public List<AssignmentActivity> getAssignmentActivities() {
        return assignmentActivities;
    }


    public void setAssignmentActivities(List<AssignmentActivity> assignmentActivities) {
        this.assignmentActivities = assignmentActivities;
    }

    

    
}
