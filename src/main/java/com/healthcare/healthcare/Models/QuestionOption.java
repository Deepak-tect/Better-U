package com.healthcare.healthcare.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class QuestionOption {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String optionType;

    @ManyToOne
    private Question question;

    public QuestionOption() {
    }

    public QuestionOption(int id, String optionType, Question question) {
        this.id = id;
        this.optionType = optionType;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionType() {
        return optionType;
    }

    public void setOptionType(String optionType) {
        this.optionType = optionType;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "QuestionOption [id=" + id + ", optionType=" + optionType + ", question=" + question + "]";
    }

    

    

}
