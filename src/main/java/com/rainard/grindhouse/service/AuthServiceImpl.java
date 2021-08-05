package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.request.LoginRequest;
import com.rainard.grindhouse.model.response.LoginResponse;

import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        var empTemp = new EmployeeEntity();
        empTemp.setEmpPassword(loginRequest.getEmployeePassword());
        empTemp.setEmpNumber(loginRequest.getEmployeeNumber());

        employeeRepository.save(empTemp);

        var x = employeeRepository.findByEmpNumberAndEmpPassword("123456", "pass");

        if (Objects.nonNull(x)) {
            log.info(x.toString());
        }

        return null;
    }

    @Override
    public ResponseEntity<Object> logout(String sessionToken, Long id) {
        return null;
    }
}
