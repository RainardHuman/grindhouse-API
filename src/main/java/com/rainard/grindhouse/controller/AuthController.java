package com.rainard.grindhouse.controller;

import com.rainard.grindhouse.controller.middleware.SessionMiddleware;
import com.rainard.grindhouse.model.request.LoginRequest;
import com.rainard.grindhouse.model.response.LoginResponse;
import com.rainard.grindhouse.service.AuthService;
import com.rainard.grindhouse.util.AuthUtil;

import io.netty.handler.ssl.ApplicationProtocolNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthUtil authUtil = new AuthUtil();
    private final SessionMiddleware middleware;

    @PostMapping(value = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping(value = "/auth/logout")
    public ResponseEntity<Object> logout(
        @NotBlank(message = "no session token provided")
        @RequestHeader("Authorization") String sessionToken) {
        var id = middleware.isSession(sessionToken);
        return Objects.isNull(id) ? authUtil.unauthorisedUser() : authService.logout(sessionToken, id);
    }
}
