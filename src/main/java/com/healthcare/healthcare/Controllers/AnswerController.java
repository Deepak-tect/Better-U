package com.healthcare.healthcare.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Services.AnswerService;
import com.healthcare.healthcare.Utils.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {
    
    @Autowired
    private AnswerService answerService;

    @PostMapping("/save-answer")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<?>> postMethodName(@RequestBody JsonNode entity) {

        // make sure saare question ke answer (of one activity or many activity) beje..
        this.answerService.addAnswerOfPatient(entity);
        return new ResponseEntity<>(new ApiResponse<>(201 , null , "Successfully added answer"),HttpStatus.CREATED);
    }
    
}
