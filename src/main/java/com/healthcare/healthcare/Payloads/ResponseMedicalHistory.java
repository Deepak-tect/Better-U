package com.healthcare.healthcare.Payloads;


public class ResponseMedicalHistory {
    
    private int id;

    private int height;

    private int weight;

    private boolean is_smoker;

    private boolean drinks_alcohol;

    private String diseases;

    private ResponsePatients responsePatients;

    public ResponseMedicalHistory() {
    }

    



    public ResponseMedicalHistory(int id, int height, int weight, boolean is_smoker, boolean drinks_alcohol,
            String diseases, ResponsePatients responsePatients) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.is_smoker = is_smoker;
        this.drinks_alcohol = drinks_alcohol;
        this.diseases = diseases;
        this.responsePatients = responsePatients;
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

    public ResponsePatients getResponsePatients() {
        return responsePatients;
    }

    public void setResponsePatients(ResponsePatients responsePatients) {
        this.responsePatients = responsePatients;
    }

    @Override
    public String toString() {
        return "ResponseMedicalHistory [id=" + id + ", height=" + height + ", weight=" + weight + ", isSmoker="
                + is_smoker + ", drinks_alcohol=" + drinks_alcohol + ", diseases=" + diseases + ", responsePatients="
                + responsePatients + "]";
    }


    public boolean isIs_smoker() {
        return is_smoker;
    }


    public void setIs_smoker(boolean is_smoker) {
        this.is_smoker = is_smoker;
    }

    



    

    

}
