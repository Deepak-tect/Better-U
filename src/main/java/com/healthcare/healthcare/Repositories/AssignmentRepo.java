package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Assignment;

public interface AssignmentRepo extends JpaRepository<Assignment , Integer> {
    
}
