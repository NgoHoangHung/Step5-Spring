package com.example.librarymanager.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name  = "book_ticket")
@Getter
@Setter

public class BookQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "ticket_book_id")
    private TicketBook ticketBook;
}

