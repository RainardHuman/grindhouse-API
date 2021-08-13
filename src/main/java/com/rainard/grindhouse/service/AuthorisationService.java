package com.rainard.grindhouse.service;

import com.rainard.grindhouse.dto.request.AuthorisationLoginDTO;
import com.rainard.grindhouse.dto.response.AuthorisationLoginResponse;

import org.springframework.http.ResponseEntity;

public interface AuthorisationService {
    AuthorisationLoginResponse login(AuthorisationLoginDTO authorisationLoginDTO);

    ResponseEntity<Object> logout(String sessionToken);
}
