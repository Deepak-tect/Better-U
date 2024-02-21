package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Demographics;



public interface DemographicRepo extends JpaRepository<Demographics , Integer> {
    
}
