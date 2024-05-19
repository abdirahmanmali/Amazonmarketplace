package com.amazon.marketplace.services.impl;

import com.amazon.marketplace.dto.ProductDto;
import com.amazon.marketplace.mapper.ProductMapper;
import com.amazon.marketplace.models.Product;
import com.amazon.marketplace.repositories.ProductRepository;
import com.amazon.marketplace.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {
    // inject the dependies into the productserviceimpl
    // specify the dependies of this class
    //

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductMapper productMapper;
    // we need to tell the compiler to create "mocks" of the depedencies
// create a test for a creating product
    @BeforeEach //
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProduct(){
        ProductDto dto = new ProductDto(1, "headphones", 499.99, "cheap headphones");
        Product product = new Product(1, "headphones", 499.99, "cheap headphones");
        Product savedProduct = new Product(1, "headphones", 499.99, "cheap headphones");

        when(productMapper.mapToProduct(dto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(savedProduct);
        when(productMapper.mapToProductDto(savedProduct)).thenReturn(new ProductDto(1, "headphones", 499.99, "cheap headphones"));



        // mock calls for a methods invocation that use a dependency within
        ProductDto responseDto = productService.createProduct(dto);

        assertEquals(dto.getId(), responseDto.getId());
        assertEquals(dto.getProductName(), responseDto.getProductName());
        assertEquals(dto.getPrice(), responseDto.getPrice());
        assertEquals(dto.getDescription(), responseDto.getDescription());

    }

}