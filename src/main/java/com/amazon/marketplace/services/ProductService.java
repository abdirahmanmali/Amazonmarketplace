package com.amazon.marketplace.services;

import com.amazon.marketplace.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(int id);

    ProductDto  updateProductPriceById(int id, double price);

    String deleteProductById(int id);

     List<ProductDto> getAllProducts();


}
// in the impl we created a class for that s obstract interface called producrservice ,
// that will have object of  producdto and create create product and and id .
