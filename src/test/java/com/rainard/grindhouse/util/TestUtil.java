package com.rainard.grindhouse.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String getContentAsString(final Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
