package com.example.assignment6carservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomHandleException {
    @ExceptionHandler(NotFoundExcepton.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handleNotFoundException(NotFoundExcepton e){
        return new ExceptionResponse(HttpStatus.NOT_FOUND,   e.getMessage());
    }
}
