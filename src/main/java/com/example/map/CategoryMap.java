package com.example.map;

import com.example.model.dto.CategoryDto;
import com.example.model.entity.Category;
import org.mapstruct.*;

@Mapper(
        componentModel = MappingConstants.ComponentModel.JSR330,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CategoryMap {

    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateEntityFromDto(CategoryDto categoryDto, @MappingTarget Category category);
}
