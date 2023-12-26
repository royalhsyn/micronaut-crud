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
        Product product=productMap.toEntity(productDto);
        Optional<Category> category=categoryRepo.findById(productDto.getCategoryId());
        if(category.isPresent()){
            product.setCategory(category.get());
        }
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
    public ProductDto update(Long id, ProductDto productDto) {
        Optional<Product> ent=productRepo.findById(id);
        Product product=null;
        if (ent.isPresent()){
            product=ent.get();
        }
        product=productMap.toEntity(productDto);
        product.setId(id);
        Optional<Category> category=categoryRepo.findById(productDto.getCategoryId());
        if (category.isPresent()){
            product.setCategory(category.get());

        }
        productRepo.save(product);
        return productDto;
    }
}
