package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Mood;

public interface MoodRepo extends JpaRepository<Mood , Integer> {
    
}
