package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.dto.request.EmployeeRegisterDTO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> register(
        @RequestHeader("Authorization") String sessionToken,
        @Valid @RequestBody EmployeeRegisterDTO employeeRegisterDTO) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/update/status")
    public ResponseEntity<Object> updateStatus(
        @RequestHeader("Authorization") String sessionToken,
        @RequestBody EmployeeRegisterDTO employeeRegisterDTO) {
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/update/password")
    public ResponseEntity<Object> updatePassword(
        @RequestHeader("Authorization") String sessionToken,
        @RequestBody EmployeeRegisterDTO employeeRegisterDTO) {
        return ResponseEntity.ok().build();
    }
}
