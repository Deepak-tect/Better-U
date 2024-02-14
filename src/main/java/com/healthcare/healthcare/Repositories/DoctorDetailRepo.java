package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.DoctorDetails;

public interface DoctorDetailRepo extends JpaRepository<DoctorDetails , Integer> {
    
}
