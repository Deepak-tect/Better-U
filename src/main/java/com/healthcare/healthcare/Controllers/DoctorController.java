package com.healthcare.healthcare.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.healthcare.Payloads.ResponseDoctor;
import com.healthcare.healthcare.Payloads.ResponseDoctorDetail;
import com.healthcare.healthcare.Services.DoctorService;
import com.healthcare.healthcare.Utils.ApiResponse;




@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    

    @GetMapping("/doctors-patients")
    @PreAuthorize("hasAnyAuthority('DOCTOR')")
    public ResponseEntity<ApiResponse<ResponseDoctor>> getPatientsOdDoctorController() {
        ResponseDoctor responseDoctor = this.doctorService.getAllPatientOfDoctor();
        return new ResponseEntity<>(new ApiResponse<>(200 , responseDoctor , "Successfully fetched the patients of doctor"), HttpStatus.OK);
    }

    @GetMapping("/doctors-details/{id}")
    @PreAuthorize("hasAnyAuthority('DOCTOR','USER', 'ADMIN')")
    public ResponseEntity<ApiResponse<ResponseDoctorDetail>> getDoctorDetailsController(@PathVariable int id) {
        ResponseDoctorDetail responseDoctor = this.doctorService.getDoctorDetails(id);
        return new ResponseEntity<>(new ApiResponse<>(200 , responseDoctor , "Successfully fetched the Doctor details"), HttpStatus.OK);
    }
    
}
