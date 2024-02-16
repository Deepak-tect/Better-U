package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Patient;
import com.healthcare.healthcare.Models.PatientMood;
import java.util.List;





public interface PatientMoodRepo extends JpaRepository<PatientMood , Integer> {
    public List<PatientMood> findByPatient(Patient patient);
}
