package com.healthcare.healthcare.Services.ServiceImpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Exceptions.ResourceNotFoundExecption;
import com.healthcare.healthcare.Models.Demographics;
import com.healthcare.healthcare.Models.Patient;
import com.healthcare.healthcare.Models.Role;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.ResponsePatients;
import com.healthcare.healthcare.Payloads.ResponseUser;
import com.healthcare.healthcare.Repositories.DemographicRepo;
import com.healthcare.healthcare.Repositories.PatientRepo;
import com.healthcare.healthcare.Repositories.RoleRepo;
import com.healthcare.healthcare.Repositories.UserRepo;
import com.healthcare.healthcare.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired 
    private RoleRepo roleRepo;

    @Autowired
    private DemographicRepo demographicRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Override
    public ResponseUser createUser(ResponseUser respnseUser) {
        String userName = respnseUser.getUsername();
        
        Optional<User> option = userRepo.findByUsername(userName);
        if(option.isPresent()){
            throw new ResourceNotFoundExecption("Username already exist", "username", 0);
        }
        Optional<Role> role = this.roleRepo.findById(respnseUser.getRole());
        User user = modelMapper.map(respnseUser, User.class);
        user.setRoles(role.get());
        
        Demographics demographics = user.getDemographics();
        demographics.setUser(user);

        this.demographicRepo.save(demographics);

        User createUser = this.userRepo.save(user);
        
        ResponseUser result = this.modelMapper.map(createUser, ResponseUser.class);
        result.setRole(user.getRoles().getId());
        return result;
    }

    @Override
    public ResponseUser getUserById(int id) {
        Optional<User> optional = this.userRepo.findById(id);
        if(optional.isPresent()){
            User user = optional.get();
            ResponseUser responseUser = this.modelMapper.map(user, ResponseUser.class);
            responseUser.setRole(user.getRoles().getId());
            return responseUser;
        }
        throw new ResourceNotFoundExecption("User", "id", id);
    }

    @Override
    public ResponseUser checkEmail(String email) {
        Optional<User> optional = this.userRepo.findByUsername(email);
        if(optional.isPresent()){
            return this.modelMapper.map(optional.get(), ResponseUser.class);
        }
        throw new ResourceNotFoundExecption("User", "email", 0);
    }

    @Override
    public ResponsePatients addPatient(ResponsePatients responsePatients) {
        int userId = responsePatients.getId();
        Optional<User> optional = this.userRepo.findById(userId);
        if(optional.isPresent()){
            User user = optional.get();
            Patient patient = this.modelMapper.map(responsePatients, Patient.class);
            patient.setUser(user);
            user.setPatient(patient);
            Patient createPatient = this.patientRepo.save(patient);
            this.userRepo.save(user);
            ResponsePatients result = this.modelMapper.map(createPatient, ResponsePatients.class);
            result.getUser().setRole(user.getRoles().getId());
            return result;

        }
        throw new ResourceNotFoundExecption("User", "id", userId);
    }
    
    
}
