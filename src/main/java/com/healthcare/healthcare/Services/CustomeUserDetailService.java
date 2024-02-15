package com.healthcare.healthcare.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Repositories.UserRepo;


@Service
public class CustomeUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // load user from database
        User user = this.userRepo.findByUsername(username).orElseThrow(()->new RuntimeException("user not found"));
        System.out.println("---------inside custome " + user.getUsername());
        return user;
    }
    
}
