package com.healthcare.healthcare.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class MedicalHistroy {
    
    @Id
    private int id;

    private int height;

    private int weight;

    private boolean is_smoker;

    private boolean drinks_alcohol;

    private String diseases;

    @OneToOne
    @MapsId
    private Patient patient;
    

    public MedicalHistroy() {
    }


    


    public MedicalHistroy(int id, int height, int weight, boolean is_smoker, boolean drinks_alcohol, String diseases,
            Patient patient) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.is_smoker = is_smoker;
        this.drinks_alcohol = drinks_alcohol;
        this.diseases = diseases;
        this.patient = patient;
    }





    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public int getWeight() {
        return weight;
    }


    public void setWeight(int weight) {
        this.weight = weight;
    }


    


    public boolean isDrinks_alcohol() {
        return drinks_alcohol;
    }


    public void setDrinks_alcohol(boolean drinks_alcohol) {
        this.drinks_alcohol = drinks_alcohol;
    }


    public String getDiseases() {
        return diseases;
    }


    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }


    public Patient getPatient() {
        return patient;
    }


    public void setPatient(Patient patient) {
        this.patient = patient;
    }


    @Override
    public String toString() {
        return "MedicalHistroy [id=" + id + ", height=" + height + ", weight=" + weight + ", is_smoker=" + is_smoker
                + ", drinks_alcohol=" + drinks_alcohol + ", diseases=" + diseases + ", patient=" + patient + "]";
    }





    public boolean isIs_smoker() {
        return is_smoker;
    }





    public void setIs_smoker(boolean is_smoker) {
        this.is_smoker = is_smoker;
    }
    

    

    
    
}
