package com.healthcare.healthcare.Payloads;

public class ResponseDoctorDetail {
    private int id;
    private String qualification;
    private String specialization;
    private int experience;
    private ResponseUser user;
    public ResponseDoctorDetail() {
    }
    public ResponseDoctorDetail(int id, String qualification, String specialization, int experience,
            ResponseUser user) {
        this.id = id;
        this.qualification = qualification;
        this.specialization = specialization;
        this.experience = experience;
        this.user = user;
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
    public ResponseUser getUser() {
        return user;
    }
    public void setUser(ResponseUser user) {
        this.user = user;
    }
    
    
}
