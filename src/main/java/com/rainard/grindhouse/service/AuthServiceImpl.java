package com.rainard.grindhouse.service;

import com.rainard.grindhouse.cache.repository.EmployeeRedisRepository;
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
    public ResponseEntity<Object> login(final String employeeNumber, final String employeePassword) {
        var optionalEmployeeEntity = employeeRepository
            .findEmployeeEntityByEmployeeNumberAndAndEmployeePassword(employeeNumber, employeePassword);

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

            return ResponseEntity
                .ok(LoginResponse.builder()
                    .sessionToken(sessionToken)
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
            return ResponseEntity
                .status(400)
                .body(FailResponse.builder()
                    .error("Logout failed")
                    .message("Employee not found")
                    .build());
        }
    }
}
