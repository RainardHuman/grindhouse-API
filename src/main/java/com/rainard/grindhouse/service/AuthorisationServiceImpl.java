package com.rainard.grindhouse.service;

import com.rainard.grindhouse.cache.repository.EmployeeRedisRepository;
import com.rainard.grindhouse.dto.request.LoginRequest;
import com.rainard.grindhouse.dto.response.LoginResponse;

import com.rainard.grindhouse.exception.EmployeeNotFoundException;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;
import com.rainard.grindhouse.persistence.repository.AuditLogRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import static com.rainard.grindhouse.util.AuthUtil.generateNewToken;

@Service
@RequiredArgsConstructor
public class AuthorisationServiceImpl implements AuthorisationService {

    private final EmployeeRepository employeeRepository;
    private final AuditLogRepository auditLogRepository;

    private final EmployeeRedisRepository employeeRedisRepository;

    @Override
    public LoginResponse login(final LoginRequest loginRequest) {

        var employeeEntity = employeeRepository.findByEmpNumberAndEmpPassword(
            loginRequest.getEmployeeNumber(),
            loginRequest.getEmployeePassword());

        if (Objects.isNull(employeeEntity)) {
            throw new EmployeeNotFoundException("Failed login: employee not found");
        }

        employeeRedisRepository.save(generateNewToken(), employeeEntity.getEmpId());

        auditLogRepository.save(AuditLogEntity.builder()
                .actionType("Login")
                .created(Timestamp.from(Instant.now()))
                .note(String.format("%s successfully logged in", employeeEntity.getEmpName()))
            .build()
        );

        return LoginResponse.builder()
            .employeeName(employeeEntity.getEmpName())
            .sessionToken("00000000000x")
            .build();
    }

    @Override
    public ResponseEntity<Object> logout(final String sessionToken) {
        return null;
    }
}
