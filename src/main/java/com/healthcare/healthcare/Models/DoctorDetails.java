package com.healthcare.healthcare.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class DoctorDetails {
    @Id
    private int id;
    private String qualification;
    private String specialization;
    private int experience;
    
    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @MapsId
    @JsonBackReference
    private Doctor doctor;

    public DoctorDetails() {
    }
    
    public DoctorDetails(int id, String qualification, String specialization, int experience, Doctor doctor) {
        this.id = id;
        this.qualification = qualification;
        this.specialization = specialization;
        this.experience = experience;
        this.doctor = doctor;
    }
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getQualification() {
        return qualification;
    }
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    @Override
    public String toString() {
        return "DoctorDetails [id=" + id + ", qualification=" + qualification + ", specialization=" + specialization
                + ", experience=" + experience + "]";
    }
    

}
