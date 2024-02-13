package com.healthcare.healthcare;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.healthcare.healthcare.Constants.AppConstant;
import com.healthcare.healthcare.Models.Role;
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
		return new ModelMapper();
	}
	@Override
	public void run(String... args) throws Exception {
		Role role1 = new Role(AppConstant.Admin , "ROLE_ADMIN");
		Role role2 = new Role(AppConstant.User , "ROLE_USER");
		Role role3 = new Role(AppConstant.Doctor , "ROLE_DOCTOR");
		roleRepo.save(role1);
		roleRepo.save(role2);
		roleRepo.save(role3);

	}

}
