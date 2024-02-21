package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Assignment;
import com.healthcare.healthcare.Models.Patient;


public interface AssignmentRepo extends JpaRepository<Assignment , Integer> {
    Assignment findByPatient(Patient patient);
}
