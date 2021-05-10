package com.rainard.grindhouse.service;

import com.rainard.grindhouse.model.Coffee;
import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.model.response.LoginResponse;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import com.rainard.grindhouse.persistence.repository.AuditLogRepository;
import com.rainard.grindhouse.persistence.repository.CoffeeRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;

import com.rainard.grindhouse.util.MapUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;
    private final CoffeeRepository coffeeRepository;
    private final AuditLogRepository auditLogRepository;
    private final MapUtil mapper = new MapUtil();
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();



    @Override
    public ResponseEntity<Object> login(final String employeeNumber, final String employeePassword) {
        var optionalEmployeeEntity = employeeRepository
            .findEmployeeEntityByEmployeeNumberAndAndEmployeePassword(employeeNumber, employeePassword);

        if (optionalEmployeeEntity.isPresent()) {
            var employee = optionalEmployeeEntity.get();

            employee.setIsLoggedIn(true);

            var coffeeEntityList = coffeeRepository.findAll();

            var auditLog = AuditLogEntity
                .builder()
                .employee(employee)
                .actionType("Login")
                .notes("Successful")
                .build();

            // cascade = CascadeType.ALL will save relationship attached
            auditLogRepository.save(auditLog);
            employeeRepository.save(employee);

            return ResponseEntity
                .ok(LoginResponse.builder()
                    .sessionToken(generateNewToken())
                    .coffees(mapper.mapCoffees(coffeeEntityList))
                    .employeeId(employee.getId())
                    .employeeName(employee.getEmployeeName())
                    .build());
        } else {
            return ResponseEntity
                .status(400)
                .body(FailResponse.builder()
                    .error("Login failed")
                    .message("Incorrect employee number or password.")
                    .build());
        }
    }

    @Override
    public ResponseEntity<Object> logout(final Long employeeId) {
        var optionalEmployeeEntity = employeeRepository.findById(employeeId);
        if (optionalEmployeeEntity.isPresent()) {
            var employee = optionalEmployeeEntity.get();

            employee.setIsLoggedIn(false);

            var auditLog = AuditLogEntity.builder()
                .employee(employee)
                .created(Timestamp.from(Instant.now()))
                .actionType("Log out")
                .notes("Successful")
                .build();

            auditLogRepository.save(auditLog);
            employeeRepository.save(employee);

            return ResponseEntity.ok("Logged out");
        } else {
            return ResponseEntity
                .status(400)
                .body(FailResponse.builder()
                    .error("Logout failed")
                    .message("Employee not found")
                    .build());
        }
    }

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }



}
