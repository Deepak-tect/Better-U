package com.healthcare.healthcare.Services.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Models.Doctor;
import com.healthcare.healthcare.Models.DoctorDetails;
import com.healthcare.healthcare.Models.Patient;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.ResponseDoctor;
import com.healthcare.healthcare.Payloads.ResponseDoctorDetail;
import com.healthcare.healthcare.Payloads.ResponsePatients;
import com.healthcare.healthcare.Payloads.ResponseUser;
import com.healthcare.healthcare.Repositories.DoctorRepo;
import com.healthcare.healthcare.Services.DoctorService;
import java.util.*;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDoctor getAllPatientOfDoctor() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int id = user.getId();
        Doctor doctor = this.doctorRepo.findById(id).get();
        List<Patient> patients = doctor.getPatients();
        List<ResponsePatients> responsePatients = new ArrayList<>();
        ResponseDoctor result = this.modelMapper.map(doctor, ResponseDoctor.class);
        for(Patient patient : patients){
            responsePatients.add(this.modelMapper.map(patient, ResponsePatients.class));
        }
        result.setDoctorDetails(this.modelMapper.map(doctor.getDoctorDetails(), ResponseDoctorDetail.class));
        result.setPatients(responsePatients);
        return result;
    }

    @Override
    public ResponseDoctorDetail getDoctorDetails(int id) {
        Doctor doctor = this.doctorRepo.findById(id).get();
        DoctorDetails doctorDetails = doctor.getDoctorDetails();
        ResponseDoctorDetail result = this.modelMapper.map(doctorDetails, ResponseDoctorDetail.class);
        result.setUser(this.modelMapper.map(doctor.getUser(), ResponseUser.class));
        return result;
    }
    
}
