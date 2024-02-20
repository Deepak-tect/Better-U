package com.healthcare.healthcare.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.QuestionOption;

public interface OptionRepo extends JpaRepository<QuestionOption , Integer> {
    
}
