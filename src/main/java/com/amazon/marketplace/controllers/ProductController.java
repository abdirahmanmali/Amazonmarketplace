package com.amazon.marketplace.controllers;

import com.amazon.marketplace.dto.ProductDto;
import com.amazon.marketplace.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(
                productService.createProduct(productDto), HttpStatus.CREATED
        );
    }

    // Get Product by ID: REST API
    // Here we invoke productService.getProductById() and pass the ID from the client.
    // Next, we return the object. The ok() method also returns the HTTP status 200.
    // @PathVariable takes the /{id} from @GetMapping and maps it to the id in the
    // method's argument.
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
        ProductDto productDto = productService.getProductById(id);
        return ResponseEntity.ok(productDto);
    }

    //update product price by id .
    @PutMapping("/{id}/price")
    public ResponseEntity<ProductDto> updateProductPriceById(@PathVariable int id, @RequestBody Map<String,  Double> request) {
// updated price assigned the value assocaited with the key "price" in the map
        double updatedPrice = request.get("price");
        ProductDto productDto = productService.updateProductPriceById(id, updatedPrice);

        return ResponseEntity.ok(productDto);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id ){
        String responseMessage  = productService.deleteProductById(id);
        return ResponseEntity.ok(responseMessage);

    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
      return ResponseEntity.ok(products);

    }


}
