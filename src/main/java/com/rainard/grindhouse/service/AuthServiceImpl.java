package com.rainard.grindhouse.service;


import com.rainard.grindhouse.domain.mapper.CoffeeMapper;
import com.rainard.grindhouse.domain.mapper.EmployeeMapper;
import com.rainard.grindhouse.domain.model.AuditLog;
import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.model.response.LoginResponse;
import com.rainard.grindhouse.persistence.entity.mapper.AuditLogEntityMapper;
import com.rainard.grindhouse.persistence.repository.AuditLogRepository;
import com.rainard.grindhouse.persistence.repository.CoffeeRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;
    private final CoffeeRepository coffeeRepository;
    private final AuditLogRepository auditLogRepository;
    private final EmployeeMapper employeeMapper;
    private final CoffeeMapper coffeeMapper;
    private final AuditLogEntityMapper auditLogEntityMapper;

    @Override
    public ResponseEntity<Object> login(final String employeeNumber, final String employeePassword) {
        var optionalEmployeeEntity = employeeRepository
            .findEmployeeEntityByEmployeeNumberAndAndEmployeePassword(employeeNumber, employeePassword);

        if (optionalEmployeeEntity.isPresent()) {
            var employee = employeeMapper.map(optionalEmployeeEntity.get());

            employee.setIsLoggedIn(true);

            var coffees = coffeeMapper.map(coffeeRepository.findAll());

            var auditLog = AuditLog
                .builder()
                .employee(employee)
                .actionType("Login")
                .notes("Successful")
                .build();

            // cascade = CascadeType.ALL will save relationship attached
            auditLogRepository.save(auditLogEntityMapper.map(auditLog));

            return ResponseEntity
                .ok(LoginResponse.builder()
                    .coffees(coffees)
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
            var employee = employeeMapper.map(optionalEmployeeEntity.get());

            employee.setIsLoggedIn(false);

            var auditLog = AuditLog.builder()
                .employee(employee)
                .actionType("Log out")
                .notes("Successful")
                .build();

            this.auditLogRepository.save(auditLogEntityMapper.map(auditLog));

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
}
