package com.healthcare.healthcare.Services;

import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Payloads.ResponseDemographics;
import com.healthcare.healthcare.Payloads.ResponseDoctor;
import com.healthcare.healthcare.Payloads.ResponsePatients;
import com.healthcare.healthcare.Payloads.ResponseUser;
import java.util.*;

@Service
public interface UserService {
    public ResponseUser createUser(ResponseUser respnseUser);
    public ResponseUser getUserById(int id);
    public ResponseUser checkEmail(String email);
    public ResponsePatients addPatient(ResponsePatients responsePatients);
    public ResponseDoctor addDoctor(ResponseDoctor responseDoctor);
    public List<ResponseDoctor> getAllDoctor();
    public ResponseUser getUserFromEmail(String email);
    public ResponseDemographics getUserDemographics(int id);
    public Boolean changePassword(String password); 
}
