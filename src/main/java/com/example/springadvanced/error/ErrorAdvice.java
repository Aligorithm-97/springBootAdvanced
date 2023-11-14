package com.example.springadvanced.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj errorHandler(IllegalArgumentException exp) {
        return ErrorObj.builder()
                .withMessage(exp.getMessage())
                .withErrorCode(1034)
                .build();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> errorHandler(Exception exp) {
        if (exp instanceof NullPointerException){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(ErrorObj.builder()
                            .withMessage(exp.getMessage())
                            .withErrorCode(4001)
                            .build());

        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorObj.builder()
                        .withMessage(exp.getMessage())
                        .withErrorCode(5000)
                        .build());
    }
}
