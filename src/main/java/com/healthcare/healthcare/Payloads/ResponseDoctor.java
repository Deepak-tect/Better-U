package com.healthcare.healthcare.Payloads;

import java.util.*;

public class ResponseDoctor {
    
    private int id;
    private ResponseDoctorDetail doctorDetails;
    List<ResponsePatients> patients;
    public ResponseDoctor() {
    }
    public ResponseDoctor(int id, ResponseDoctorDetail doctorDetails) {
        this.id = id;
        this.doctorDetails = doctorDetails;
    }
    
    public ResponseDoctor(int id, ResponseDoctorDetail doctorDetails, List<ResponsePatients> patients) {
        this.id = id;
        this.doctorDetails = doctorDetails;
        this.patients = patients;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public ResponseDoctorDetail getDoctorDetails() {
        return doctorDetails;
    }
    public void setDoctorDetails(ResponseDoctorDetail doctorDetails) {
        this.doctorDetails = doctorDetails;
    }
    
    @Override
    public String toString() {
        return "ResponseDoctor [id=" + id + ", doctorDetails=" + doctorDetails + "]";
    }
    public List<ResponsePatients> getPatients() {
        return patients;
    }
    public void setPatients(List<ResponsePatients> patients) {
        this.patients = patients;
    }
    
    
    
    
}
