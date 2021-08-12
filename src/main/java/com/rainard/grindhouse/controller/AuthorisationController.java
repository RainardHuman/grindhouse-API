package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dto.request.LoginRequest;
import com.rainard.grindhouse.dto.response.LoginResponse;
import com.rainard.grindhouse.service.AuthorisationService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
@RequiredArgsConstructor
public class AuthorisationController {

    private final AuthorisationService authorisationService;

    @PostMapping(path = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authorisationService.login(loginRequest);
    }

    @GetMapping(path = "/auth/logout")
    public ResponseEntity<Object> logout(
        @RequestHeader("Authorization") String sessionToken) {
        return authorisationService.logout(sessionToken);
    }
}
