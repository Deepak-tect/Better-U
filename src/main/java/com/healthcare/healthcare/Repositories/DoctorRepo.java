package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor , Integer> {
    
}
