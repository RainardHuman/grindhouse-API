package com.rainard.grindhouse.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(final String message) {
        super(message);
    }
}
