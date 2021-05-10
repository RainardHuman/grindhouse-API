package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.controller.middleware.SessionMiddleware;
import com.rainard.grindhouse.model.request.LoginRequest;
import com.rainard.grindhouse.service.AuthService;
import com.rainard.grindhouse.util.AuthUtil;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import lombok.RequiredArgsConstructor;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthUtil authUtil = new AuthUtil();
    private final SessionMiddleware middleware;

    @PostMapping("/auth/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        return authService.login(request.getEmployeeNumber(), request.getEmployeePassword());
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<Object> logout(@RequestBody String sessionToken) {
        var id = middleware.isSession(sessionToken);
        return Objects.isNull(id) ? authUtil.unauthorisedUser() : authService.logout(sessionToken, id);
    }


}
