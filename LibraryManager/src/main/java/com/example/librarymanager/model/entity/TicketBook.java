package com.example.librarymanager.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table
@Getter
@Setter
public class TicketBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne()
    @JoinColumn(name = "borrower_id")
    private Borrower borrower;

    private Servicez servicez;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_ticket",
            joinColumns = @JoinColumn(name = "ticket_book_id", referencedColumnName = "id", columnDefinition = "INT(11)"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id", columnDefinition = "INT(11)"))
    private List<Book> books;

    private LocalDate creatAt;
    private LocalDate returnDay;
    private String status;
    private String note;
    private double totalPrice;


}
