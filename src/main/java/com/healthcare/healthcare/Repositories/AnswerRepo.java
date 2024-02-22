package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.Answer;

public interface AnswerRepo extends JpaRepository<Answer , Integer> {
    
}
