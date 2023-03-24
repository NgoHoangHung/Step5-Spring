package com.example.assignmentsecurity.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Data
public class AkioExceptionResponse {
    private HttpStatus status;
    private String message;
}
