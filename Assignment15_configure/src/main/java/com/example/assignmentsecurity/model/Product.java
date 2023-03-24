package com.example.assignmentsecurity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
   /* static List<Product> products = new ArrayList();

    public Product() {
        products.add(new Product("apple", 150));
        products.add(new Product("mango", 100));
        products.add(new Product("ringle", 250));
    }*/

/*    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }*/
}
