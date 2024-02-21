package com.healthcare.healthcare.Controllers;

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

import com.healthcare.healthcare.Payloads.RequestAssignment;
import com.healthcare.healthcare.Payloads.ResponseAssignment;
import com.healthcare.healthcare.Services.AssignmentService;
import com.healthcare.healthcare.Utils.ApiResponse;




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

    @GetMapping("/get-assignment")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ApiResponse<ResponseAssignment>> getAssignmentController() {
        ResponseAssignment result = this.assignmentService.getAssignment();
        return new ResponseEntity<>(new ApiResponse<>(200 , result , "Successfully fetched assignment"),HttpStatus.OK);
    }

    @GetMapping("/get-assignment/{id}")
    @PreAuthorize("hasAuthority('DOCTOR')")
    public ResponseEntity<ApiResponse<ResponseAssignment>> getAssignmentByDoctorController(@PathVariable int id) {
        ResponseAssignment result = this.assignmentService.getAssignmentByDoctor(id);
        return new ResponseEntity<>(new ApiResponse<>(200 , result , "Successfully fetched assignment"),HttpStatus.OK);
    }
    
    
}
