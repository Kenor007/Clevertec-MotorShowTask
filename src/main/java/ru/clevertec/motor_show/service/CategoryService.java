package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.dto.CategoryRequestDto;
import ru.clevertec.motor_show.dto.CategoryResponseDto;

public interface CategoryService {
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);

    void deleteCategory(Long id);

    CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, Long id);
}
