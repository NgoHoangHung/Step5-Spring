package com.example.assignment19_jwt_bookmanager.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Setter
@Getter
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;

}
