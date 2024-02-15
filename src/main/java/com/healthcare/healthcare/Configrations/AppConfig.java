package com.healthcare.healthcare.Configrations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.healthcare.healthcare.Services.CustomeUserDetailService;



@Configuration
public class AppConfig {


    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomeUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
