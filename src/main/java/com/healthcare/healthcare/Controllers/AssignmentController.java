package com.healthcare.healthcare.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.healthcare.healthcare.Payloads.RequestAssignment;
import com.healthcare.healthcare.Payloads.ResponseAssignment;
import com.healthcare.healthcare.Services.AssignmentService;
import com.healthcare.healthcare.Utils.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/assignment")
public class AssignmentController {
    

    @Autowired
    private AssignmentService assignmentService;
    @PostMapping("/add-assignment")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<ApiResponse<ResponseAssignment>> postMethodName(@RequestBody RequestAssignment entity) {
        ResponseAssignment result = this.assignmentService.addAssignment(entity);
        return new ResponseEntity<>(new ApiResponse<>(200 , result , "Successfully assigned assignment"),HttpStatus.OK);
    }
    
}
