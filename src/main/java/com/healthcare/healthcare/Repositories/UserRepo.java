package com.healthcare.healthcare.Repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.healthcare.Models.User;


public interface UserRepo extends JpaRepository<User , Integer> {
    Optional<User> findByUsername(String username);
}
