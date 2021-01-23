package com.demo.warehouse.repository;

import com.demo.warehouse.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    public Optional<Product> findByProductNameOrderByProductId(String name);

}
