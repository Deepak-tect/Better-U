package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.MedicalHistroy;

public interface MedicalHistoryRepo extends JpaRepository<MedicalHistroy , Integer> {

    
}
