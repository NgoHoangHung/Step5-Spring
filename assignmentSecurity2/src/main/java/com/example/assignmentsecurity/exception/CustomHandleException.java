package com.example.assignmentsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomHandleException {
    @ExceptionHandler(AkioException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AkioExceptionResponse handleNotFoundException(AkioException e) {
        return new AkioExceptionResponse(HttpStatus.NOT_FOUND, e.getMessage());
    }
//    @ExceptionHandler(AkioException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public static AkioExceptionResponse forbiddenException(AkioException e) {
//        return new AkioExceptionResponse(HttpStatus.FORBIDDEN, e.getMessage());
//    }
}
