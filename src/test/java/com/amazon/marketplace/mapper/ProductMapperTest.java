package com.amazon.marketplace.mapper;

import com.amazon.marketplace.dto.ProductDto;
import com.amazon.marketplace.models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMapperTest {
    private ProductMapper productMapper;

    @Test
    public void testMappingfromProductDtoToProduct() {
        ProductDto productDto = new ProductDto(1, "iphone", 499.99, "Cheap head phones");
        Product product = productMapper.mapToProduct(productDto);

        assertEquals(productDto.getProductName(), product.getProductName());
        assertEquals(productDto.getPrice(), product.getPrice());
        assertEquals(productDto.getDescription(), product.getDescription());

    }

    @Test
    public void testMappingFromProductToProductDto(){
        Product product = new Product(1, "iphone", 499.99, "Cheap head phones");
        ProductDto productDto = productMapper.mapToProductDto(product);

        assertEquals(product.getProductName(), productDto.getProductName());
        assertEquals(product.getPrice(), productDto.getPrice());
        assertEquals(product.getDescription(), productDto.getDescription());

    }

}