package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.model.response.LoginResponse;
import com.rainard.grindhouse.model.table.AuditLog;
import com.rainard.grindhouse.model.table.Coffee;
import com.rainard.grindhouse.model.table.Employee;
import com.rainard.grindhouse.repository.AuditLogRepository;
import com.rainard.grindhouse.repository.CoffeeRepository;
import com.rainard.grindhouse.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@RestController()
public class AuthController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private AuditLogRepository auditLogRepository;

    @GetMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestParam String empNumber, @RequestParam String empPassword) {
        Employee employee = employeeRepository.findEmployeeByEmpNumberAndEmpPassword(empNumber,empPassword);
        if (Objects.nonNull(employee)) {
            List<Coffee> coffees = new ArrayList<>();
            coffeeRepository.findAll().iterator().forEachRemaining(coffees::add);
            LoginResponse response = LoginResponse.builder()
                    .coffees(coffees)
                    .employee_id(employee.getId())
                    .employee_name(employee.getEmpName())
                    .build();
            AuditLog auditLog = AuditLog.builder()
                    .empId(employee.getId())
                    .actionType("Login")
                    .notes("Successful")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            employee.setIsLoggedIn(true);
            employeeRepository.save(employee);
            auditLogRepository.save(auditLog);
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
        Employee employee = employeeRepository.findEmployeeById(empId);
        if (Objects.nonNull(employee)) {
            employee.setIsLoggedIn(false);
            employeeRepository.save(employee);
            AuditLog auditLog = AuditLog.builder()
                    .empId(employee.getId())
                    .actionType("Log out")
                    .notes("Successful")
                    .timestamp(new Timestamp(System.currentTimeMillis()))
                    .build();
            auditLogRepository.save(auditLog);
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
