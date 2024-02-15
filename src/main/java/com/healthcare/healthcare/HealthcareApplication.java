package com.healthcare.healthcare;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.healthcare.healthcare.Constants.AppConstant;
import com.healthcare.healthcare.Models.Role;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.ResponseUser;
import com.healthcare.healthcare.Repositories.RoleRepo;

@SpringBootApplication
public class HealthcareApplication implements CommandLineRunner {

	@Autowired
	private RoleRepo roleRepo;

	
	public static void main(String[] args) {
		SpringApplication.run(HealthcareApplication.class, args);
		System.out.println("--------------------Welcome------------------------");
	}
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
		PropertyMap<User, ResponseUser> userMap = new PropertyMap<>() {
            protected void configure() {
                map().setRole(source.getRoles().getId());
            }
        };
		modelMapper.addMappings(userMap);
		return modelMapper;
	}
	@Override
	public void run(String... args) throws Exception {
		Role role1 = new Role(AppConstant.Admin , "ADMIN");
		Role role2 = new Role(AppConstant.User , "USER");
		Role role3 = new Role(AppConstant.Doctor , "DOCTOR");
		roleRepo.save(role1);
		roleRepo.save(role2);
		roleRepo.save(role3);

	}

}
