package com.healthcare.healthcare.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.healthcare.Repositories.UserRepo;
import com.healthcare.healthcare.Security.JwtHelper;
import com.healthcare.healthcare.Services.CustomeUserDetailService;
// import com.healthcare.healthcare.Services.UserService;
import com.healthcare.healthcare.Utils.JwtRequest;
import com.healthcare.healthcare.Utils.JwtResponse;


@RestController
@RequestMapping("/auth")
public class AuthController {
    // @Autowired
    // private UserDetailsService userDetailsService;

    @Autowired
    private CustomeUserDetailService customeUserDetailService;

    @Autowired
    private AuthenticationManager manager;

    // @Autowired
    // private UserService userService;



    @Autowired
    private JwtHelper helper;

    @Autowired
    private UserRepo userRepo;

    // private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        System.out.println("controller " + request.getUsername());
        System.out.println("controller " + userRepo.findByUsername(request.getUsername()).get().getPassword());
        this.doAuthenticate(request.getUsername(), request.getPassword());

        UserDetails userDetails = customeUserDetailService.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            System.out.println("--------------inside---------------");
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

    // @PostMapping("/create-user")
    // public User createUser(@RequestBody User user){
    //     return this.userService.createUsers(user);
    // }
}
