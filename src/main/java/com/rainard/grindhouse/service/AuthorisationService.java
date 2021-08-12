package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.LoginRequest;
import com.rainard.grindhouse.dto.response.LoginResponse;

import org.springframework.http.ResponseEntity;

public interface AuthorisationService {
    LoginResponse login(LoginRequest loginRequest);

    ResponseEntity<Object> logout(String sessionToken);
}
