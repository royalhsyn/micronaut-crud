package com.example.controller;

import com.example.model.dto.ProductDto;
import com.example.service.ProductService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Controller("/product")
@Validated
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Get("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @Get
    public List<ProductDto> findAll() {
        return productService.findAll();
    }

    @Post
    @Status(HttpStatus.CREATED)
    public void save(@Body @Valid ProductDto productDto) {
        productService.save(productDto);
    }

    @Delete("/{id}")
    @Status(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @Put("/{id}")
    @Status(HttpStatus.CREATED)
    public void update(@PathVariable Long id,@Body @Valid ProductDto productDto){
        productService.update(id,productDto);
    }
}
