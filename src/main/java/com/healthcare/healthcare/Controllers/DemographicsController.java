package com.healthcare.healthcare.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.healthcare.healthcare.Payloads.ResponseDemographics;
import com.healthcare.healthcare.Services.DemographicsService;
import com.healthcare.healthcare.Utils.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/demographic")
public class DemographicsController {

    @Autowired
    private DemographicsService demographicService;


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR','USER')")
    public ResponseEntity<ApiResponse<ResponseDemographics>> getMethodName(@PathVariable int id) {
        ResponseDemographics responseDemographics = this.demographicService.getDemographic(id);
        return new ResponseEntity<>(new ApiResponse<>(200 , responseDemographics , "Succesfully fetched demographics"),HttpStatus.OK);
    }

    @PostMapping("/update-demographics")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ResponseDemographics>> updateDemographicsController(@RequestBody ResponseDemographics entity) {
        ResponseDemographics result = this.demographicService.updateDemographics(entity);
        return new ResponseEntity<>(new ApiResponse<>(200  , result , "Succssfully updated demographics"),HttpStatus.OK);
    }
    
    
}
