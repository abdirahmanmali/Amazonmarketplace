package com.amazon.marketplace.services.impl;

import com.amazon.marketplace.dto.ProductDto;
import com.amazon.marketplace.mapper.ProductMapper;
import com.amazon.marketplace.models.Product;
import com.amazon.marketplace.repositories.ProductRepository;
import com.amazon.marketplace.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired // is just used to specify this is now a dependisies of the application that you need to pull in that class
    //by do that we can comment ou the constructor of this class /
    // autowire will take care of it .
    // pull in the dependisies of these class

    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

//    @Autowired
//    public ProductServiceImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    /*
    This method will take a productDto object and convert it into a JPA object which
    will be stored in the database. To handle this conversion, we will create and
    use a mapper (can be found in mapper.ProductMapper)

    @Autowired
    */
    //@Autowired
    //private ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        // Convert the productDto into a JPA entity
        Product product = productMapper.mapToProduct(productDto);

        // Spring's CrudRepository interface comes with several methods for interacting with a database.
        // The .save() method saves data to a database. It also returns the saved JPA entity.
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    // Spring JPA has an existing method for finding objects in a database by ID. We can access this because
    // our ProductRepository extends Spring's JpaRepository. The .findeById() method MUST throw a
    // RuntimeException if the ID doesn't exist. We can catch that exception using a lambda to print a response.
    @Override
    public ProductDto getProductById(int id) {
        Product product = productRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("Product of this ID does not exist"));

        return productMapper.mapToProductDto(product);
    }

    @Override
    public ProductDto updateProductPriceById(int id, double price) {
        // before we update the product, we should first check  if the product ith the id exist
        // if it doesnt exist , then we throw an error
        Product product = productRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("Product of this ID does not exist"));
         product.setPrice(price);

        // Spring's CrudRepository interface comes with several methods for interacting with a database.
        // The .save() method saves data to a database. It also returns the saved JPA entity.
        Product savedProduct = productRepository.save(product);
        return productMapper.mapToProductDto(savedProduct);
    }

    @Override
    public String deleteProductById(int id) {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return  "successfully deleted product ID " + id;
        }
        return "no record of that id was found";

    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos= new ArrayList<>();

        for(Product product: products){
            productDtos.add(productMapper.mapToProductDto(product));

        }

        return productDtos;
    }
}

//    Postman <-----> controller <-----> service <---> DB
//                                      // translate the DTO into JPA