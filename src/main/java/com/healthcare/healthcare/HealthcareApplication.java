package com.healthcare.healthcare;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.healthcare.healthcare.Constants.AppConstant;
import com.healthcare.healthcare.Models.Mood;
import com.healthcare.healthcare.Models.Role;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.ResponseUser;
import com.healthcare.healthcare.Repositories.MoodRepo;
import com.healthcare.healthcare.Repositories.RoleRepo;

@SpringBootApplication
public class HealthcareApplication implements CommandLineRunner {

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private MoodRepo moodRepo;

	
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

		Mood mood1 = new Mood(AppConstant.Happy, "Happy" , AppConstant.HappyDescription);
		Mood mood2 = new Mood(AppConstant.Confused, "Confused" , AppConstant.ConfusedDescription);
		Mood mood3 = new Mood(AppConstant.Sad, "Sad" , AppConstant.SadDescription);
		Mood mood4 = new Mood(AppConstant.Anxious, "Anxious" , AppConstant.AnxiousDescription);
		Mood mood5 = new Mood(AppConstant.Disprassed, "Disprassed" , AppConstant.DisprassedDescription);
		moodRepo.save(mood1);
		moodRepo.save(mood2);
		moodRepo.save(mood3);
		moodRepo.save(mood4);
		moodRepo.save(mood5);
	}

}
