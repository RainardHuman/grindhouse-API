package com.rainard.grindhouse.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rainard.grindhouse.model.request.LoginRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
class AuthorizationControllerTest {

    private final String AUTH_LOGIN_URL = "/auth/login";
    private final String AUTH_LOGOUT_URL = "/auth/logout";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private MockMvc mockMvc;

    @InjectMocks
    private AuthorisationController authorizationController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authorizationController).build();
    }

    @Test
    void shouldReturnDefaultMessage() throws Exception {

        var loginRequest = LoginRequest.builder()
            .employeeNumber("employeeNumber")
            .employeePassword("employeePassword")
            .build();

        System.out.println("=================================================================");
        System.out.println(getContentAsString(loginRequest));
        System.out.println("=================================================================");

        var x = mockMvc.perform(MockMvcRequestBuilders.post(AUTH_LOGIN_URL)
                .content(getContentAsString(loginRequest))
            )
            .andDo(print())
            .andExpect(status().isOk())
            .adn;
    }

    @Test
    void loginBlankTest() throws Exception {
        var loginRequest = LoginRequest.builder()
            .employeeNumber("employeeNumber")
            .employeePassword("employeePassword")
            .build();

        mockMvc.perform(MockMvcRequestBuilders.post(AUTH_LOGIN_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginRequest.toString())
            )
            .andExpect(status().isBadRequest());
    }


    private String getContentAsString(final Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    private static Stream<Arguments> blankEmployeeDetails() {
        return Stream.of(
            arguments("f5384532", "5"),
            arguments("", "password"),
            arguments("f5384532", null),
            arguments(null, "password"),
            arguments("", ""),
            arguments(null, null)
        );
    }

}
