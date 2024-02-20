package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Question;

public interface QuestionRepo extends JpaRepository<Question , Integer> {
    
}
