package com.amazon.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
@Entity
public class Product {

    @Id // this makes the int id the primary key for the products table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increments the primary key
    private int id;

    @Column(name="product_name")
    private String productName;
    @Column(name="price")
    private double price;
    @Column(name="description")
    private String description;
}
