package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Patient;

public interface PatientRepo extends JpaRepository<Patient , Integer> {
    
}
