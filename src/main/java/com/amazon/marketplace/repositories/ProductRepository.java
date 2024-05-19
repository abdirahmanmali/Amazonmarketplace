package com.amazon.marketplace.repositories;

import com.amazon.marketplace.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository has existing methods to work with a database.
// So just by creating an interface that extends JpaRespository, we have access
// to all those methods.

// To use the JpaRepository for a given database table, we have to specify the
// object type, and the data type of that object's primary key.
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
