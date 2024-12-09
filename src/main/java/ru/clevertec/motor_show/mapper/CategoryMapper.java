package ru.clevertec.motor_show.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.clevertec.motor_show.dto.CategoryRequestDto;
import ru.clevertec.motor_show.dto.CategoryResponseDto;
import ru.clevertec.motor_show.model.Category;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cars", ignore = true)
    Category categoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto);

    CategoryResponseDto categoryToCategoryResponseDto(Category category);
}
