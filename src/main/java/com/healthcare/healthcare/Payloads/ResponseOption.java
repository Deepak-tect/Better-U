package com.healthcare.healthcare.Payloads;

public class ResponseOption {

    private String optionType;

    public ResponseOption() {
    }

    public ResponseOption(String optionType) {
        this.optionType = optionType;
    }


    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    @Override
    public String toString() {
        return "ResponseOption [optionType=" + optionType + "]";
    }
    
    
}
