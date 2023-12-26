package com.example.repository;

import com.example.model.entity.Category;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Optional;
@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String name);
}
