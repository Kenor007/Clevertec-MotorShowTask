package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.motor_show.dto.CategoryRequestDto;
import ru.clevertec.motor_show.dto.CategoryResponseDto;
import ru.clevertec.motor_show.enums.category.CarCategory;
import ru.clevertec.motor_show.error_handling.exception.CategoryNotFoundException;
import ru.clevertec.motor_show.mapper.CategoryMapper;
import ru.clevertec.motor_show.model.Category;
import ru.clevertec.motor_show.repository.CategoryRepository;
import ru.clevertec.motor_show.service.CategoryService;

import java.util.Optional;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.CATEGORY_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = categoryMapper.categoryRequestDtoToCategory(categoryRequestDto);
        Category savedCategory = categoryRepository.save(category);
        log.debug("Category with id {} is saved", savedCategory.getId());
        return categoryMapper.categoryToCategoryResponseDto(savedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            Category deletedCategory = findCategoryByIdOrThrow(id);
            categoryRepository.deleteById(id);
            log.debug("Category with id {} is deleted", id);
        } else {
            log.error("Category with id {} not found", id);
            throw new CategoryNotFoundException(String.format(CATEGORY_NOT_FOUND, id));
        }
    }

    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, Long id) {
        Category category = findCategoryByIdOrThrow(id);
        Optional.ofNullable(categoryRequestDto.getCarCategory())
                .map(carCategory -> CarCategory.valueOf(carCategory.toUpperCase()))
                .ifPresent(category::setCarCategory);
        categoryRepository.save(category);
        return categoryMapper.categoryToCategoryResponseDto(category);
    }

    private Category findCategoryByIdOrThrow(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(() -> {
            log.error("Category with id {} not found", categoryId);
            return new CategoryNotFoundException(String.format(CATEGORY_NOT_FOUND, categoryId));
        });
    }
}
