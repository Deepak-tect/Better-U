package com.healthcare.healthcare.Models;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Mood {
    @Id
    private int id;

    private String mood;

    private String description;

    @OneToMany(mappedBy = "mood" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<PatientMood> patientMoods = new ArrayList<>();

    public Mood() {
    }

    public Mood(int id, String mood, String description) {
        this.id = id;
        this.mood = mood;
        this.description = description;
    }



    public Mood(int id, String mood, String description, List<PatientMood> patientMoods) {
        this.id = id;
        this.mood = mood;
        this.description = description;
        this.patientMoods = patientMoods;
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


    public List<PatientMood> getPatientMoods() {
        return patientMoods;
    }


    public void setPatientMoods(List<PatientMood> patientMoods) {
        this.patientMoods = patientMoods;
    }
    
}
