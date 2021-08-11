package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dto.request.LoginRequest;
import com.rainard.grindhouse.dto.response.LoginResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthorisationController {

    @PostMapping(path = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return null;
    }

    @PostMapping(path = "/auth/logout")
    public ResponseEntity<Object> logout(
        @RequestHeader("Authorization") String sessionToken) {
        return null;
    }
}
