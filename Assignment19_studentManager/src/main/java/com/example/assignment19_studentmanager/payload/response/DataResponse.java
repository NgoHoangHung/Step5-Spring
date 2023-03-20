package com.example.assignment19_studentmanager.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class DataResponse {
    private HttpStatus status;
    private String message;
}
