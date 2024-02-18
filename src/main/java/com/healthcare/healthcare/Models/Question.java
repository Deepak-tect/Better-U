package com.healthcare.healthcare.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.*;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String question_title;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<QuestionOption> option = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Activity activity;

    @OneToMany(mappedBy = "question" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(int id, String question_title, List<QuestionOption> option, Activity activity, List<Answer> answers) {
        this.id = id;
        this.question_title = question_title;
        this.option = option;
        this.activity = activity;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public List<QuestionOption> getOption() {
        return option;
    }

    public void setOption(List<QuestionOption> option) {
        this.option = option;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    

    
    
}
