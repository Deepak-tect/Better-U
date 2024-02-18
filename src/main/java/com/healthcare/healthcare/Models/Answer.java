package com.healthcare.healthcare.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String choice;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Question question;

    public Answer() {
    }

    public Answer(int id, String choice, Patient patient, Question question) {
        this.id = id;
        this.choice = choice;
        this.patient = patient;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    
}
