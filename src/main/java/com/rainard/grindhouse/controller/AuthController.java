package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.service.AuthService;

import com.rainard.grindhouse.util.AuthUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthUtil authUtil;

    @GetMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestParam String employeeNumber, @RequestParam String employeePassword) {
        return authService.login(employeeNumber, employeePassword);
    }

    @GetMapping("/auth/logout")
    public ResponseEntity<Object> logout(@RequestParam Long employeeId) {
        return authUtil.validateSession(authService.logout(employeeId));
    }

}
