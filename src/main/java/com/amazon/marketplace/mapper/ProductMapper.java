package com.amazon.marketplace.mapper;

import com.amazon.marketplace.dto.ProductDto;
import com.amazon.marketplace.models.Product;
import org.springframework.stereotype.Component;

/*
The purpose of this class is to contain logic for converting DTO objects into JPA entities
AND vice versa -- convert JPA entities into DTO objects.
 */
@Component
public class ProductMapper {

    // Convert DTO into JPA entity
    public Product mapToProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getId(),
                productDto.getProductName(),
                productDto.getPrice(),
                productDto.getDescription()
        );
        return product;
    }

    // Convert JPA entity into DTO
    public  ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                product.getDescription()
        );
        return productDto;
    }

}