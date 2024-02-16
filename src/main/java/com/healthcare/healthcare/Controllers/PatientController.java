package com.healthcare.healthcare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Exceptions.ResourceNotFoundExecption;
import com.healthcare.healthcare.Payloads.ResponseMood;
import com.healthcare.healthcare.Services.PatientService;
import com.healthcare.healthcare.Utils.ApiResponse;




@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {


    @Autowired
    private PatientService patientService;


    @PostMapping("/add-mood")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<ApiResponse<?>> addMoodController(@RequestBody JsonNode entity) {
        JsonNode moodArray = entity.get("mood");

        if (moodArray != null && moodArray.isArray()) {
            System.out.println(moodArray);
            this.patientService.addPatientMood(moodArray);
        } else {
            throw new ResourceNotFoundExecption("Mood", "Please send the mood", 0);
        }
        return new ResponseEntity<>(new ApiResponse<>(201 , null , "Successfully added mood of patient"),HttpStatus.OK);
    }

    @PostMapping("/get-mood-patient/{id}")
    public String getmoodpatient(@PathVariable int id) {
        // just for checking
        this.patientService.getMood(id);
        return "ok";
    }

    @GetMapping("/get-patient-mood/{id}")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<ApiResponse<List<ResponseMood>>> getMethodName(@PathVariable int id) {
        List<ResponseMood> result = this.patientService.getPatientMood(id);
        return new ResponseEntity<>(new ApiResponse<>(200 , result , "successully fetch the mood"),HttpStatus.OK);
    }
    
    
    
}
