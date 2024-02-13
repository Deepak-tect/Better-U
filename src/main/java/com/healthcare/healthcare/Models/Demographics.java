package com.healthcare.healthcare.Models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Demographics {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private int age;
    private String sex;
    
    @OneToOne
    @MapsId
    private User user;
    public Demographics() {
    }
    public Demographics(int id, String firstName, String lastName, Date dob, int age, String sex, User user) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.age = age;
        this.sex = sex;
        this.user = user;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString() {
        return "Demographics [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
                + ", age=" + age + ", sex=" + sex + ", user=" + user + "]";
    }
    

}
