package com.example.repository;

import com.example.model.entity.Product;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
