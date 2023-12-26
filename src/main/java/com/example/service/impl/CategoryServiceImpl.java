package com.example.service.impl;

import com.example.map.CategoryMap;
import com.example.model.dto.CategoryDto;
import com.example.repository.CategoryRepo;
import com.example.service.CategoryService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    private final CategoryMap categoryMap;


    @Override
    @Transactional
    public List<CategoryDto> findAll() {
        return categoryRepo.findAll()
                .stream()
                .map(categoryMap::toDto)
                .toList();
    }

    @Override
    @Transactional
    public CategoryDto findById(Long id) {
        return categoryRepo.findById(id)
                .map(categoryMap::toDto)
                .orElseThrow();
    }
}
