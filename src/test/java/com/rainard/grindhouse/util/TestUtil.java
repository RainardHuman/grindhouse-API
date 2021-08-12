package com.rainard.grindhouse.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class TestUtil {
    public static final String UTF_8 = "utf-8";
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static String getContentAsString(final Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static ResultMatcher compareJsonValue(final String jsonPath, final String jsonValue) {
        return jsonPath(String.format("%s%s","$.",jsonPath), is(jsonValue));
    }
}
