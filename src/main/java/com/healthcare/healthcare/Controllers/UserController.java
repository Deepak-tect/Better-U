package com.healthcare.healthcare.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Payloads.ResponseDemographics;
import com.healthcare.healthcare.Payloads.ResponseDoctor;
import com.healthcare.healthcare.Payloads.ResponsePatients;
import com.healthcare.healthcare.Payloads.ResponseUser;
import com.healthcare.healthcare.Services.UserService;
import com.healthcare.healthcare.Utils.ApiResponse;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/create-user")
    public ResponseEntity<ApiResponse<ResponseUser>> createUserController(@RequestBody ResponseUser entity) {
        ResponseUser respnseUser =this.userService.createUser(entity);
        return new ResponseEntity<>(new ApiResponse<>(201 , respnseUser ,"User created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{id}")
    public ResponseEntity<ApiResponse<ResponseUser>> getUserByIdController(@PathVariable int id) {
        ResponseUser responseUser = this.userService.getUserById(id);
        return new ResponseEntity<>(new ApiResponse<>(200 , responseUser , "Succesfully fetched user"),HttpStatus.OK);
    }


    @GetMapping("/check-email")
    public ResponseEntity<ApiResponse<ResponseUser>> checkEmailController(@RequestParam MultiValueMap<String, String> requestParams) {
        String email = requestParams.getFirst("email");
        ResponseUser responseUser = this.userService.checkEmail(email);
        return new ResponseEntity<>(new ApiResponse<>(200 , responseUser , "Succesfully find the username"),HttpStatus.OK);
    }

    @PostMapping("/add-patient")
    public ResponseEntity<ApiResponse<ResponsePatients>> addPatientController(@RequestBody ResponsePatients entity) {
        ResponsePatients responsePatients = this.userService.addPatient(entity);
        return new ResponseEntity<>(new ApiResponse<>(201, responsePatients , "Successfully added parent"),HttpStatus.CREATED);
    }

    @PostMapping("/add-doctor")
    public ResponseEntity<ApiResponse<ResponseDoctor>> addDoctorController(@RequestBody ResponseDoctor entity) {
        // only admin able to do this
        ResponseDoctor responseDoctor = this.userService.addDoctor(entity);
        return new ResponseEntity<>(new ApiResponse<>(201, responseDoctor , "Successfully added doctor"),HttpStatus.CREATED);
    }

    @GetMapping("/get-doctors")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<ApiResponse<List<ResponseDoctor>>> getAllDoctor() {
        
        List<ResponseDoctor> responseUser = this.userService.getAllDoctor();
        return new ResponseEntity<>(new ApiResponse<>(200 , responseUser , "Succesfully find the username"),HttpStatus.OK);
    }
    @GetMapping("/get-user-email")
    public ResponseEntity<ApiResponse<ResponseUser>> getUserEmailController(@RequestParam MultiValueMap<String, String> requestParams) {
        String email = requestParams.getFirst("email");
        ResponseUser responseUser = this.userService.getUserFromEmail(email);
        return new ResponseEntity<>(new ApiResponse<>(200 , responseUser , "Succesfully find the username"),HttpStatus.OK);
    }

    @GetMapping("/get-user-demographic/{id}")
    public ResponseEntity<ApiResponse<ResponseDemographics>> getUserDemographicController(@PathVariable int id) {
        
        ResponseDemographics responseUser = this.userService.getUserDemographics(id);
        return new ResponseEntity<>(new ApiResponse<>(200 , responseUser , "Succesfully find the username"),HttpStatus.OK);
    }

    @PostMapping("/change-password")
    @PreAuthorize("hasAnyAuthority('ADMIN','DOCTOR','USER')")
    public ResponseEntity<ApiResponse<?>> postMethodName(@RequestBody JsonNode  entity) {
        System.out.println(entity.get("password").asText());
        this.userService.changePassword(entity.get("password").asText());
        return new ResponseEntity<>(new ApiResponse<>(200 , null , "Successfully added password"),HttpStatus.OK);
    }
    

    
    
    
}
