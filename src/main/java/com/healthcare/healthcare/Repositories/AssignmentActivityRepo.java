package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.AssignmentActivity;

public interface AssignmentActivityRepo extends JpaRepository<AssignmentActivity , Integer> {
    
}
