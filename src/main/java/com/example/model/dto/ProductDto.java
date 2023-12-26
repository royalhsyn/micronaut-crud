package com.example.model.dto;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Serdeable
public class ProductDto {

    @NotEmpty(message = "Product should have a name")
    private String name;

    private String description;

    private Double price;

    private Long categoryId;


}