package com.example.service;

import com.example.model.dto.CategoryDto;
import com.example.model.dto.ProductDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto findById(Long id);
}
