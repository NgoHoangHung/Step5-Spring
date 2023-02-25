package com.example.librarymanager.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private double price;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToMany
    @JoinColumn(name = "ticket_id")
    private List<TicketBook> ticketBooks;


}
