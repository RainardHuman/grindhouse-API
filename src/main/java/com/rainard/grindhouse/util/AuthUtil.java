package com.rainard.grindhouse.util;

import com.rainard.grindhouse.model.response.FailResponse;

import org.springframework.http.ResponseEntity;

public class AuthUtil {
    public ResponseEntity<Object> validateSession(ResponseEntity<Object> response) {
        //validate session token on redis installation
        if (false) {
            return ResponseEntity
                .status(400)
                .body(FailResponse.builder()
                    .error("Unauthorized")
                    .message("Please log in and retry")
                    .build());
        } else
            return response;
    }
}
