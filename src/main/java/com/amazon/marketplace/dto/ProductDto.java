package com.amazon.marketplace.dto;

// DTO stands for Data Transfer Object. A DTO is the object in Java which will be
// used to create a JPA model to add to the database.

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private int id;
    private String productName;
    private double price;
    private String description;
}
