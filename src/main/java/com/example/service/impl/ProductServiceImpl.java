package com.example.service.impl;

import com.example.exception.NotFoundException;
import com.example.map.ProductMap;
import com.example.model.dto.CategoryDto;
import com.example.model.dto.ProductDto;
import com.example.model.entity.Category;
import com.example.model.entity.Product;
import com.example.repository.CategoryRepo;
import com.example.repository.ProductRepo;
import com.example.service.ProductService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final CategoryRepo categoryRepo;

    private final ProductMap productMap;


    @Override
    @Transactional
    public void save(ProductDto productDto) {
        Product product = productMap.toEntity(productDto);
        categoryRepo.findById(productDto.getCategoryId())
                .ifPresent(product::setCategory);
        productRepo.save(product);
    }


    @Override
    @Transactional
    public List<ProductDto> findAll() {
        return productRepo.findAll()
                .stream()
                .map(productMap::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ProductDto findById(Long id) {
        return productRepo.findById(id)
                .map(productMap::toDto)
                .orElseThrow();
    }

    @Override
    public void delete(Long id) {
        if(productRepo.existsById(id)) {
            try{
            productRepo.deleteById(id);
        }catch (RuntimeException ex) {
            throw new RuntimeException("An error occurred during delete");
        }
    }
    }

    @Override
    @Transactional
    public void update(Long id, ProductDto productDto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productMap.updateEntityFromDto(productDto, product);
        categoryRepo.findById(productDto.getCategoryId())
                .ifPresent(product::setCategory);
        productRepo.save(product);
    }

}
