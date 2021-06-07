package com.demo.warehouse.controller;


import com.demo.warehouse.DTO.DTOProduct;
import com.demo.warehouse.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.demo.warehouse.service.ProductService;

import javax.transaction.Transactional;

@CrossOrigin(origins = "http://warehouse-angular.s3-website.eu-central-1.amazonaws.com/")
@Transactional @Validated
@RestController
@RequestMapping(path = "/api")
public class ProductController {
    private final ProductService  productService;
    private Long productId;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody DTOProduct product){
        return productService.saveProduct(product);
    }

    @GetMapping(path = "/products")
        public @ResponseBody Iterable<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
        public Product getProductById(@PathVariable("id") Long productId) {
        return productService.getProductById(productId);
    }
}
