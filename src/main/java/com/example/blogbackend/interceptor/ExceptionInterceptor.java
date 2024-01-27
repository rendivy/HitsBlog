package com.example.blogbackend.interceptor;


import com.example.blogbackend.dto.ErrorDTO;

import io.jsonwebtoken.security.SignatureException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleConstraintViolationException(ConstraintViolationException exception) {

        var firstViolation = exception
                .getConstraintViolations()
                .iterator()
                .next();

        var exceptionMessage = firstViolation
                .getMessageTemplate();

        var error = ErrorDTO
                .builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(exceptionMessage)
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



    
}

