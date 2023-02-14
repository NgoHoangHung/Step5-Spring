package com.example.assignmentcontest.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String phone;

    @OneToOne()
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @JsonBackReference
    @OneToMany(mappedBy = "customer")
    private List<Vote> votes;
}
