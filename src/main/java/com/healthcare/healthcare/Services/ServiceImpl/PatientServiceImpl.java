package com.healthcare.healthcare.Services.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Exceptions.ResourceNotFoundExecption;
import com.healthcare.healthcare.Models.Mood;
import com.healthcare.healthcare.Models.Patient;
import com.healthcare.healthcare.Models.PatientMood;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.ResponseMood;
import com.healthcare.healthcare.Repositories.MoodRepo;
import com.healthcare.healthcare.Repositories.PatientMoodRepo;
import com.healthcare.healthcare.Repositories.PatientRepo;
import com.healthcare.healthcare.Services.PatientService;
import java.util.*;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private PatientMoodRepo patientMoodRepo;

    @Autowired
    private MoodRepo moodRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addPatientMood(JsonNode moods) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("user----------"+user.getPatient());
        Patient patient = user.getPatient();
        for(JsonNode id : moods){
            Optional<Mood> option = this.moodRepo.findById(id.asInt());
            Mood mood = option.get();
            PatientMood patientMood = new PatientMood();
            patientMood.setMood(mood);
            patientMood.setPatient(patient);
            patientMood.setDate(new Date());
            this.patientMoodRepo.save(patientMood);
        }
    }

    @Override
    public void getMood(int id) {
        // just for checking
        Optional<Mood> optional = this.moodRepo.findById(id);
        Mood mood = optional.get();
        System.out.println(mood.getPatientMoods());
    }
    @Override
    public List<ResponseMood> getPatientMood(int id) {
        Optional<Patient> optional = this.patientRepo.findById(id);
        List<ResponseMood> result = new ArrayList<>();
        if(optional.isPresent()){
            Patient patient = optional.get();
            List<PatientMood> moods = this.patientMoodRepo.findByPatient(patient);
            for(PatientMood patientMood : moods){
                ResponseMood responseMood = this.modelMapper.map(patientMood, ResponseMood.class);
                responseMood.setDescription(patientMood.getMood().getDescription());
                result.add(responseMood);
            }
            return result;
        }
        throw new ResourceNotFoundExecption("id", "patient not found", id);
    }
    
}
