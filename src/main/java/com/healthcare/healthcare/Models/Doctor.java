package com.healthcare.healthcare.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctor {
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @MapsId
    @JsonBackReference
    private User user;

    @OneToOne(mappedBy = "doctor" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JsonManagedReference
    private DoctorDetails doctorDetails;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Assignment> assingment = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(int id, User user, DoctorDetails doctorDetails, List<Patient> patients) {
        this.id = id;
        this.user = user;
        this.doctorDetails = doctorDetails;
        this.patients = patients;
    }
    

    public Doctor(int id, User user, DoctorDetails doctorDetails, List<Patient> patients, List<Assignment> assingment) {
        this.id = id;
        this.user = user;
        this.doctorDetails = doctorDetails;
        this.patients = patients;
        this.assingment = assingment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DoctorDetails getDoctorDetails() {
        return doctorDetails;
    }

    public void setDoctorDetails(DoctorDetails doctorDetails) {
        this.doctorDetails = doctorDetails;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
    
    public List<Assignment> getAssingment() {
        return assingment;
    }

    public void setAssingment(List<Assignment> assingment) {
        this.assingment = assingment;
    }
    
    @Override
    public String toString() {
        return "Doctor [id=" + id + ", user=" + user + ", doctorDetails=" + doctorDetails + ", patients=" + patients
                + "]";
    }
}
