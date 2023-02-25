package com.example.librarymanager.model.dto;

import lombok.Data;

import java.util.Map;

@Data
public class BorrowBookDTO {
    private String borrowerName;
    private String borrowerPhone;
    private String borrowerCCCD;
    private Map<Integer,Integer> bookIds;
    private Double deposit;
}
