package com.rainard.grindhouse.service;

import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<Object> login(String employeeNumber, String employeePassword);

    ResponseEntity<Object> logout(String sessionToken, Long id);

}
