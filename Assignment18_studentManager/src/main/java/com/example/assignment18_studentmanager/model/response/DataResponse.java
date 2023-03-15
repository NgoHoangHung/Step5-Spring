package com.example.assignment18_studentmanager.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class DataResponse {
    private HttpStatus status;
    private String message;
}
