package com.rainard.grindhouse.util;

import com.rainard.grindhouse.persistence.entity.EmployeeEntity;

import com.rainard.grindhouse.persistence.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public class AuthUtil {

    public EmployeeEntity validateSession(String sessionToken) {
        return null;
    }

    public ResponseEntity<Object> unauthorisedUser() {
        return ResponseEntity.status(401).body("Please login.");
    }

}
