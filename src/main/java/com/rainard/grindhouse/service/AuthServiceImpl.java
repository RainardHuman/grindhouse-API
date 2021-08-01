package com.rainard.grindhouse.service;

import com.rainard.grindhouse.cache.repository.EmployeeRedisRepository;
import com.rainard.grindhouse.model.request.LoginRequest;
import com.rainard.grindhouse.model.response.FailResponse;
import com.rainard.grindhouse.model.response.LoginResponse;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;
import com.rainard.grindhouse.persistence.repository.AuditLogRepository;
import com.rainard.grindhouse.persistence.repository.CoffeeRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;
import com.rainard.grindhouse.util.AuthUtil;
import com.rainard.grindhouse.util.MapUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;
    private final CoffeeRepository coffeeRepository;
    private final AuditLogRepository auditLogRepository;
    private final EmployeeRedisRepository employeeRedisRepository;
    private final MapUtil mapper = new MapUtil();
    private final AuthUtil authUtil = new AuthUtil();

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var optionalEmployeeEntity = employeeRepository
            .findEmployeeEntityByEmployeeNumberAndAndEmployeePassword(loginRequest.getEmployeeNumber(), loginRequest.getEmployeePassword());

        if (optionalEmployeeEntity.isPresent()) {
            var employee = optionalEmployeeEntity.get();

            employee.setIsLoggedIn(true);
            employee.setUpdated(Timestamp.from(Instant.now()));
            String sessionToken = authUtil.generateNewToken();
            employeeRedisRepository.save(sessionToken, employee.getId());

            var coffeeEntityList = coffeeRepository.findAll();

            var auditLog = AuditLogEntity
                .builder()
                .created(Timestamp.from(Instant.now()))
                .employee(employee)
                .actionType("Login")
                .notes("Successful")
                .build();

            auditLogRepository.save(auditLog);
            employeeRepository.save(employee);

            return LoginResponse.builder()
                    .sessionToken(sessionToken)
                    .coffees(mapper.mapCoffees(coffeeEntityList))
                    .employeeName(employee.getEmployeeName())
                    .build();
        } else {
            throw new RuntimeException("This just fucking broke");
        }
    }

    @Override
    public ResponseEntity<Object> logout(String sessionToken, Long id) {
        if (Objects.nonNull(id)) {
            var optionalEmployeeEntity = employeeRepository.findById(id);
            if (optionalEmployeeEntity.isPresent()) {
                var employee = optionalEmployeeEntity.get();
                employee.setIsLoggedIn(false);
                employee.setUpdated(Timestamp.from(Instant.now()));

                var auditLog = AuditLogEntity.builder()
                    .employee(employee)
                    .created(Timestamp.from(Instant.now()))
                    .actionType("Log out")
                    .notes("Successful")
                    .build();

                employeeRedisRepository.delete(sessionToken);
                auditLogRepository.save(auditLog);
                employeeRepository.save(employee);
            }
                return ResponseEntity.ok("Logged out");

        } else {
            throw new RuntimeException("employee entity not found");
        }
    }
}
