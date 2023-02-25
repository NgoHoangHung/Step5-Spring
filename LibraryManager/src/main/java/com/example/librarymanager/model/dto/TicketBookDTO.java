package com.example.librarymanager.model.dto;

import com.example.librarymanager.model.entity.Servicez;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class TicketBookDTO {
    private Integer id;
    private BorrowerDTO borrower;
    private Servicez servicez;
    private List<BookDTO> bookList;
    private int returnDay;

}
