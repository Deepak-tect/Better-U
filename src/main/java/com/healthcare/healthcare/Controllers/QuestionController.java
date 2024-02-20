package com.healthcare.healthcare.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Payloads.ResponseOption;
import com.healthcare.healthcare.Payloads.ResponseQuestion;
import com.healthcare.healthcare.Services.QuestionService;
import com.healthcare.healthcare.Utils.ApiResponse;




@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add-question")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<ResponseQuestion>> postMethodName(@RequestBody JsonNode entity) {
        ResponseQuestion responseQuestion = new ResponseQuestion();
        int activityId = entity.get("activity").asInt();
        responseQuestion.setQuestion_title(entity.get("question_title").asText());
        JsonNode optionsNode = entity.get("option");
        List<ResponseOption> array = new ArrayList<>();
        for (JsonNode optionNode : optionsNode) {
            ResponseOption responseOption = new ResponseOption();
            responseOption.setOptionType(optionNode.get("optionType").asText());
            array.add(responseOption);
        }
        responseQuestion.setOption(array);
        
        ResponseQuestion result = this.questionService.addQuestion(responseQuestion, activityId);
        return new ResponseEntity<>(new ApiResponse<>(201 , result , "Successfully added question"),HttpStatus.CREATED);
    }


    @GetMapping("/get-question")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ApiResponse<List<ResponseQuestion>>> getAllQuestionController() {
        List<ResponseQuestion> result = this.questionService.getAllQuestion();
        return new ResponseEntity<>(new ApiResponse<>(200 , result , "successfully fetched questions"),HttpStatus.OK);
    }
    
    
    
}
