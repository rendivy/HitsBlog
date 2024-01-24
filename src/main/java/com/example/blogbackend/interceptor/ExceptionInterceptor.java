package com.example.blogbackend.interceptor;


import com.example.blogbackend.dto.ErrorDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleConstraintViolationException(ConstraintViolationException exception) {

        ConstraintViolation<?> firstViolation = exception.getConstraintViolations().iterator().next();
        String exceptionMessage = firstViolation.getMessageTemplate();

        var error = ErrorDTO
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exceptionMessage)
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

