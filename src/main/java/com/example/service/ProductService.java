package com.example.service;

import com.example.model.dto.ProductDto;

import java.util.List;

public interface ProductService {

    void save(ProductDto productDto);

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    void delete(Long id);

    ProductDto update(Long id,ProductDto productDto);
}
