package com.healthcare.healthcare.Services.ServiceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Models.Demographics;
import com.healthcare.healthcare.Models.User;
import com.healthcare.healthcare.Payloads.ResponseDemographics;
import com.healthcare.healthcare.Repositories.DemographicRepo;
// import com.healthcare.healthcare.Repositories.DemographicRepo;
import com.healthcare.healthcare.Repositories.UserRepo;
import com.healthcare.healthcare.Services.DemographicsService;


@Service
public class DemographicServiceImpl implements DemographicsService {

    @Autowired
    private DemographicRepo demographicRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDemographics getDemographic(int id) {
        User user = this.userRepo.findById(id).get();
        Demographics demographics = user.getDemographics();
        ResponseDemographics result = this.modelMapper.map(demographics, ResponseDemographics.class);
        return result;
    }
    @Override
    public ResponseDemographics updateDemographics(ResponseDemographics responseDemographics) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Demographics existingDemographics = user.getDemographics();
        this.modelMapper.map(responseDemographics, existingDemographics);
        Demographics updatedDemographics = this.demographicRepo.save(existingDemographics);
        return this.modelMapper.map(updatedDemographics, ResponseDemographics.class);
    }
    
}
