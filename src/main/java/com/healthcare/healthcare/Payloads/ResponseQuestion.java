package com.healthcare.healthcare.Payloads;

import java.util.*;

public class ResponseQuestion {
    
    private String question_title;

    private List<ResponseOption> option;

    private ResponseActivity RresponseActivity;

    public ResponseQuestion() {
    }

    

    public ResponseQuestion(String question_title, List<ResponseOption> option, ResponseActivity rresponseActivity) {
        this.question_title = question_title;
        this.option = option;
        RresponseActivity = rresponseActivity;
    }



    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public List<ResponseOption> getOption() {
        return option;
    }

    public void setOption(List<ResponseOption> option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "ResponseQuestion [question_title=" + question_title + ", option=" + option + "]";
    }



    public ResponseActivity getRresponseActivity() {
        return RresponseActivity;
    }



    public void setRresponseActivity(ResponseActivity rresponseActivity) {
        RresponseActivity = rresponseActivity;
    }
    

    
}
