package com.example.map;

import com.example.model.dto.ProductDto;
import com.example.model.entity.Category;
import com.example.model.entity.Product;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMap {

    @Mapping(target = "categoryId", expression = "java(toSet(product.getCategory()))")
    ProductDto toDto(Product product);


    Product toEntity(ProductDto productDto);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product updateEntityFromDto(ProductDto productDto, @MappingTarget Product product);

    default Long toSet(Category category) {
        return category.getId();
    }
}
