package com.example.librarymanager.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
public class TypeDTO {
    private Integer id;
    private String name;
//    private BookDTO book;
}
