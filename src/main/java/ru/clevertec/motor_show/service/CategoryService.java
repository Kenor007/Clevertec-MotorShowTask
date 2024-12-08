package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.model.Category;

import java.util.List;

public interface CategoryService {
    void addCategory();

    void deleteCategory(Long id);

    void updateCategory(Category category, Long id);

    void linkCategoryWithCars(Long categoryId, List<Long> carIds);
}