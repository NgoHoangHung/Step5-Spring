package com.example.digitalwallet.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Entity
@Data
@Component
public class Account  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String password;
}
