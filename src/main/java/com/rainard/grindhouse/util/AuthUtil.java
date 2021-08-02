package com.rainard.grindhouse.util;

import lombok.experimental.UtilityClass;

import org.springframework.http.ResponseEntity;

import java.security.SecureRandom;
import java.util.Base64;

@UtilityClass
public class AuthUtil {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static ResponseEntity<Object> unauthorisedUser() {
        return ResponseEntity.status(401).body("Please login.");
    }

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

}
