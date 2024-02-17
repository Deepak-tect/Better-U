package com.healthcare.healthcare.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Patient {
    
    @Id
    private int id;

    private Date joiningDate;

    private boolean wants_doc;

    @OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @MapsId
    @JsonBackReference
    private User user;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Doctor doctor;

    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<PatientMood> patientMoods = new ArrayList<>();


    @OneToOne(mappedBy = "patient" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private MedicalHistroy medicalHistroy;

    public Patient() {
    }


    // public Patient(int id, Date joiningDate, boolean wants_doc, User user, Doctor doctor) {
    //     this.id = id;
    //     this.joiningDate = joiningDate;
    //     this.wants_doc = wants_doc;
    //     this.user = user;
    //     this.doctor = doctor;
    // }

    
    



    public Patient(int id, Date joiningDate, boolean wants_doc, User user, Doctor doctor,
            List<PatientMood> patientMoods, MedicalHistroy medicalHistroy) {
        this.id = id;
        this.joiningDate = joiningDate;
        this.wants_doc = wants_doc;
        this.user = user;
        this.doctor = doctor;
        this.patientMoods = patientMoods;
        this.medicalHistroy = medicalHistroy;
    }



    public MedicalHistroy getMedicalHistroy() {
        return medicalHistroy;
    }



    public void setMedicalHistroy(MedicalHistroy medicalHistroy) {
        this.medicalHistroy = medicalHistroy;
    }



    public Patient(int id, Date joiningDate, boolean wants_doc, User user, Doctor doctor,
            List<PatientMood> patientMoods) {
        this.id = id;
        this.joiningDate = joiningDate;
        this.wants_doc = wants_doc;
        this.user = user;
        this.doctor = doctor;
        this.patientMoods = patientMoods;
    }
    



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public boolean isWants_doc() {
        return wants_doc;
    }

    public void setWants_doc(boolean wants_doc) {
        this.wants_doc = wants_doc;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }



    @Override
    public String toString() {
        return "Patient [id=" + id + ", joiningDate=" + joiningDate + ", wants_doc=" + wants_doc + ", user=" + user
                + ", doctor=" + doctor + "]";
    }



    public List<PatientMood> getPatientMoods() {
        return patientMoods;
    }



    public void setPatientMoods(List<PatientMood> patientMoods) {
        this.patientMoods = patientMoods;
    }

    

    

}
