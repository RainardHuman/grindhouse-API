package com.rainard.grindhouse.exception;

import com.rainard.grindhouse.model.Problem;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.SneakyThrows;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private static final String VALIDATION_ERROR = "Request validation error";
    private static final String EMPLOYEE_NOT_FOUND_ERROR = "Employee not found error";
    private static final String HTTP_HEADER_MISSING = "Required HTTP header missing";

    private static String toFriendlyMessage(final List<ObjectError> errors) {

        final Set<String> errorMessages = new HashSet<>() {
        };

        for (ObjectError error : errors) {
            String msg = error.getDefaultMessage();
            if (msg != null) {
                errorMessages.add(msg);
            }
        }
        return String.join("|", errorMessages);
    }

    @SneakyThrows
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Problem problem = Problem.builder()
            .instance(new URI(((ServletWebRequest) request).getRequest().getRequestURI()))
            .messageTitle(VALIDATION_ERROR)
            .detail(toFriendlyMessage(ex.getBindingResult().getAllErrors()))
            .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException, WebRequest request) throws URISyntaxException {

        final Problem problem = Problem.builder()
            .instance(new URI(((ServletWebRequest) request).getRequest().getRequestURI()))
            .messageTitle(EMPLOYEE_NOT_FOUND_ERROR)
            .detail(employeeNotFoundException.getMessage())
            .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<Object> handleMissingRequestHeaderException(MissingRequestHeaderException missingRequestHeaderException, WebRequest request) throws URISyntaxException {

        final Problem problem = Problem.builder()
            .instance(new URI(((ServletWebRequest) request).getRequest().getRequestURI()))
            .messageTitle(HTTP_HEADER_MISSING)
            .detail(missingRequestHeaderException.getMessage())
            .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }

}
