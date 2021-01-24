package com.demo.warehouse.service;

import com.demo.warehouse.DTO.DTOProduct;
import com.demo.warehouse.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.demo.warehouse.repository.ProductRepository;

import java.util.NoSuchElementException;

@Service
public class ProductService {

    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ResponseEntity saveProduct(DTOProduct product) {
        Product newProduct = DTOProductToProduct(product);
        productRepository.save(newProduct);
        DTOProduct savedProduct = productToDTOProduct(productRepository.findByProductNameOrderByProductId(product.getProductName()).get());
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    public Product DTOProductToProduct(DTOProduct dtoProduct){
        Product product =Product.builder()
                .productId(dtoProduct.getProductId())
                .productCod(dtoProduct.getProductCod())
                .categoryName(dtoProduct.getCategoryName())
                .productName(dtoProduct.getProductName())
                .quantity(dtoProduct.getQuantity())
                .unit(dtoProduct.getUnit())
                .notes(dtoProduct.getNotes())
                .build();
        return product;
    }
    public  DTOProduct productToDTOProduct(Product product){
        DTOProduct dtoProduct =DTOProduct.builder()
                .productId(product.getProductId())
                .productCod(product.getProductCod())
                .categoryName(product.getCategoryName())
                .productName(product.getProductName())
                .quantity(product.getQuantity())
                .unit(product.getUnit())
                .notes(product.getNotes())
                .build();
        return dtoProduct;
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException());
    }

    public Iterable<Product> getAllProducts() {
        return  productRepository.findAll();
    }
}
