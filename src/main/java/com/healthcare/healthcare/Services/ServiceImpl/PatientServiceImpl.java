package com.healthcare.healthcare.Services.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.healthcare.healthcare.Exceptions.ResourceNotFoundExecption;
import com.healthcare.healthcare.Models.Doctor;
import com.healthcare.healthcare.Models.MedicalHistroy;
import com.healthcare.healthcare.Models.Mood;
import com.healthcare.healthcare.Models.Patient;
import com.healthcare.healthcare.Models.PatientMood;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.ResponseDoctor;
import com.healthcare.healthcare.Payloads.ResponseMedicalHistory;
import com.healthcare.healthcare.Payloads.ResponseMood;
import com.healthcare.healthcare.Payloads.ResponsePatients;
import com.healthcare.healthcare.Repositories.DoctorRepo;
import com.healthcare.healthcare.Repositories.MedicalHistoryRepo;
import com.healthcare.healthcare.Repositories.MoodRepo;
import com.healthcare.healthcare.Repositories.PatientMoodRepo;
import com.healthcare.healthcare.Repositories.PatientRepo;
import com.healthcare.healthcare.Services.PatientService;

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

    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public void addPatientMood(JsonNode moods) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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

    @Override
    public ResponseMedicalHistory addPatientMedicalHistory(ResponseMedicalHistory responseMedicalHistory) {
        Optional<Patient> optional = this.patientRepo.findById(responseMedicalHistory.getId());

        if(optional.isPresent()){
            Patient patient = optional.get();
            MedicalHistroy medicalHistroy = this.modelMapper.map(responseMedicalHistory, MedicalHistroy.class);
            medicalHistroy.setPatient(patient);
            System.out.println(medicalHistroy);
            this.medicalHistoryRepo.save(medicalHistroy);
            ResponseMedicalHistory result = this.modelMapper.map(medicalHistroy, ResponseMedicalHistory.class);
            result.setResponsePatients(this.modelMapper.map(patient, ResponsePatients.class));
            return result;
        }
        
        throw new ResourceNotFoundExecption("Patient id doesnot match", "ID", responseMedicalHistory.getId());
    }

    @Override
    public ResponseMedicalHistory getPatientMedicalHistory(int id) {
        if(id == -1){
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Patient patient = user.getPatient();
            MedicalHistroy medicalHistroy = patient.getMedicalHistroy();
            ResponseMedicalHistory result = this.modelMapper.map(medicalHistroy, ResponseMedicalHistory.class);
            result.setResponsePatients(this.modelMapper.map(patient, ResponsePatients.class));
            return result;
        }
        Optional<Patient> optional = this.patientRepo.findById(id);

        if(optional.isPresent()){
            Patient patient = optional.get();
            MedicalHistroy medicalHistroy = patient.getMedicalHistroy();
            ResponseMedicalHistory result = this.modelMapper.map(medicalHistroy, ResponseMedicalHistory.class);
            result.setResponsePatients(this.modelMapper.map(patient, ResponsePatients.class));
            return result;
        }
        throw new ResourceNotFoundExecption("Patient id doesnot match", "ID", id);
    
    }

    @Override
    public List<ResponsePatients> getAllPatients() {
        List<Patient> patients = this.patientRepo.findAll();
        List<ResponsePatients> result = new ArrayList<>();
        for(Patient patient : patients){
            ResponsePatients responsePatients = this.modelMapper.map(patient, ResponsePatients.class);
            // responsePatients.setResponseDoctor(this.modelMapper.map(patient.getDoctor(), ResponseDoctor.class));
            result.add(responsePatients);
        }
        return result;
    }

    @Override
    public ResponsePatients assignDoctor(int id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = user.getPatient();
        Optional<Doctor> optional = this.doctorRepo.findById(id);
        if(optional.isPresent()){
            Doctor doctor  = optional.get();
            patient.setDoctor(doctor);
            this.patientRepo.save(patient);
            ResponsePatients responsePatients = this.modelMapper.map(patient, ResponsePatients.class);
            responsePatients.setResponseDoctor(this.modelMapper.map(doctor, ResponseDoctor.class));
            return responsePatients;
        }
        throw new ResourceNotFoundExecption("Doctor id does not match", "ID", id);
    }
    
}
