package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.AuthorisationLoginDTO;
import com.rainard.grindhouse.dto.response.AuthorisationLoginResponse;
import com.rainard.grindhouse.exception.EmployeeNotFoundException;
import com.rainard.grindhouse.persistence.entity.AuditLogEntity;
import com.rainard.grindhouse.persistence.repository.AuditLogRepository;
import com.rainard.grindhouse.persistence.repository.EmployeeRepository;
import com.rainard.grindhouse.service.interfaces.AuthorisationService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorisationServiceImpl implements AuthorisationService {

    private final EmployeeRepository employeeRepository;
    private final AuditLogRepository auditLogRepository;

    @Override
    public AuthorisationLoginResponse login(final AuthorisationLoginDTO authorisationLoginDTO) {

        var employeeEntity = employeeRepository.findByEmpNumberAndEmpPassword(
            authorisationLoginDTO.getEmployeeNumber(),
            authorisationLoginDTO.getEmployeePassword());

        if (Objects.isNull(employeeEntity)) {
            throw new EmployeeNotFoundException("Failed login: employee not found");
        }

        var audit = new AuditLogEntity();
        audit.setActionType("Login");
        audit.setCreated(Timestamp.from(Instant.now()));
        audit.setNote(String.format("%s successfully logged in", employeeEntity.getEmpName()));
        auditLogRepository.save(audit);


        return AuthorisationLoginResponse.builder()
            .employeeName(employeeEntity.getEmpName())
            .sessionToken("00000000000x")
            .build();
    }

    @Override
    public ResponseEntity<Object> logout(final String sessionToken) {
        return null;
    }
}
