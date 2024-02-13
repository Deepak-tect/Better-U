package com.healthcare.healthcare.Payloads;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import jakarta.validation.constraints.NotEmpty;

public class ResponseDemographics {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private Date dob;
    private int age;
    @NotEmpty
    private String sex;

    private int calculateAge(Date dateOfBirth) {
        LocalDate birthDate = dateOfBirth.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Calculate the period between the birth date and current date
        Period period = Period.between(birthDate, currentDate);
        // Get the years from the period
        return period.getYears();
    }
    public ResponseDemographics() {
    }
    public ResponseDemographics(String firstName, String lastName, Date dob, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        
        this.sex = sex;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
        this.age = this.calculateAge(dob);
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    
    @Override
    public String toString() {
        return "ResponseDemographics [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", age="
                + age + ", sex=" + sex + "]";
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    
}
