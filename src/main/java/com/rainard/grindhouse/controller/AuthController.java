package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.model.response.LoginResponse;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;
import com.rainard.grindhouse.persistence.entity.CoffeeEntity;
import com.rainard.grindhouse.persistence.entity.EmployeeEntity;
import com.rainard.grindhouse.persistence.repository.CoffeeRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController()
public class AuthController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private com.rainard.grindhouse.persistence.repository.AuditLogRepository auditLogRepository;

    @GetMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestParam String empNumber, @RequestParam String empPassword) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeByEmpNumberAndEmpPassword(empNumber,empPassword);
        if (Objects.nonNull(employeeEntity)) {
            List<CoffeeEntity> coffeeEntities = new ArrayList<>();
            coffeeRepository.findAll().iterator().forEachRemaining(coffeeEntities::add);
            LoginResponse response = LoginResponse.builder()
                    .coffees(coffeeEntities)
                    .employeeId(employeeEntity.getId())
                    .employeeName(employeeEntity.getEmpName())
                    .build();
            AuditLogEntity auditLogEntity = AuditLogEntity.builder()
                    .empId(employeeEntity.getId())
                    .actionType("Login")
                    .notes("Successful")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            employeeEntity.setIsLoggedIn(true);
            employeeRepository.save(employeeEntity);
            this.auditLogRepository.save(auditLogEntity);
            return ResponseEntity.ok(response);
        } else {
            FailResponse response = FailResponse.builder()
                    .error("Login failed")
                    .message("Incorrect employee number or password.")
                    .build();
            return ResponseEntity.status(400).body(response);
        }

    }

    @GetMapping("/auth/logout")
    public ResponseEntity<Object> logout(@RequestParam int empId) {
        EmployeeEntity employeeEntity = employeeRepository.findEmployeeById(empId);
        if (Objects.nonNull(employeeEntity)) {
            employeeEntity.setIsLoggedIn(false);
            employeeRepository.save(employeeEntity);
            AuditLogEntity auditLogEntity = AuditLogEntity.builder()
                    .empId(employeeEntity.getId())
                    .actionType("Log out")
                    .notes("Successful")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            this.auditLogRepository.save(auditLogEntity);
            return ResponseEntity.ok("Logged out");
        }
         else {
            FailResponse response = FailResponse.builder()
                    .error("Logout failed")
                    .message("Employee not found")
                    .build();
            return ResponseEntity.status(400).body(response);
        }
    }
}
