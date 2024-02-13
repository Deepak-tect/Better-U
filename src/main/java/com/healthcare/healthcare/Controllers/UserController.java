package com.healthcare.healthcare.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.healthcare.Payloads.ResponseUser;
import com.healthcare.healthcare.Services.UserService;
import com.healthcare.healthcare.Utils.ApiResponse;



@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("/create-user")
    public ResponseEntity<ApiResponse<ResponseUser>> postMethodName(@RequestBody ResponseUser entity) {
        ResponseUser respnseUser =this.userService.createUser(entity);
        return new ResponseEntity<>(new ApiResponse<>(201 , respnseUser ,"User created successfully"), HttpStatus.CREATED);
    }
    
}
