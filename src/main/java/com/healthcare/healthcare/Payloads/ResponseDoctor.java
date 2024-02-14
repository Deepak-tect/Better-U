package com.healthcare.healthcare.Payloads;

public class ResponseDoctor {
    
    private int id;
    private ResponseDoctorDetail doctorDetails;
    public ResponseDoctor() {
    }
    public ResponseDoctor(int id, ResponseDoctorDetail doctorDetails) {
        this.id = id;
        this.doctorDetails = doctorDetails;
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
    
    
    
    
}
