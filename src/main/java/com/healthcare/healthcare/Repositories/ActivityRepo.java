package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Activity;

public interface ActivityRepo extends JpaRepository<Activity , Integer> {
    
}
