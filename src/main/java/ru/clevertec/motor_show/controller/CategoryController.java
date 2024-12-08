package ru.clevertec.motor_show.controller;

import ru.clevertec.motor_show.factory.CategoryFactory;
import ru.clevertec.motor_show.service.CategoryService;
import ru.clevertec.motor_show.service.impl.CategoryServiceImpl;

import java.util.List;

public class CategoryController {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();

        //add category
//        categoryService.addCategory();

        //delete category
//        categoryService.deleteCategory(1l);

        //update category
//        categoryService.updateCategory(CategoryFactory.getCategory(), 2L);

        //add category in car
        List<Long> listCarIdJoinWitnCategoryId = List.of(10L);
        categoryService.linkCategoryWithCars(2l, listCarIdJoinWitnCategoryId);
    }
}