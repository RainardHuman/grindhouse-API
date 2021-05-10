package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.request.LoginRequest;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;
import com.rainard.grindhouse.service.AuthService;

import com.rainard.grindhouse.util.AuthUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthUtil authUtil = new AuthUtil();
    private final EmployeeRepository employeeRepository;

    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        return authService.login(request.getEmployeeNumber(), request.getEmployeePassword());
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<Object> logout(@RequestBody String sessionToken) {
        var employee = employeeRepository.findEmployeeEntityByEmployeeNumberAndAndEmployeePassword("5384532","password").get();
        return Objects.isNull(employee) ? authUtil.unauthorisedUser() : authService.logout(employee.getId());
    }

}
