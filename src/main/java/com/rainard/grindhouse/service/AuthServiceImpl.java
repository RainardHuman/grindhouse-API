package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.request.LoginRequest;
import com.rainard.grindhouse.model.response.LoginResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Object> logout(String sessionToken, Long id) {
        return null;
    }
}
