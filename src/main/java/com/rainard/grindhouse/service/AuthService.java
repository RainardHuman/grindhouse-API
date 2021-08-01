package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.request.LoginRequest;
import com.rainard.grindhouse.model.response.LoginResponse;

import org.springframework.http.ResponseEntity;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

    ResponseEntity<Object> logout(String sessionToken, Long id);

}
