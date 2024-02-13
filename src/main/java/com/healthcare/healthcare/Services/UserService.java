package com.healthcare.healthcare.Services;

import org.springframework.stereotype.Service;

import com.healthcare.healthcare.Payloads.ResponseUser;

@Service
public interface UserService {
    public ResponseUser createUser(ResponseUser respnseUser);
    public ResponseUser getUserById(int id);
    public ResponseUser checkEmail(String email);
}
