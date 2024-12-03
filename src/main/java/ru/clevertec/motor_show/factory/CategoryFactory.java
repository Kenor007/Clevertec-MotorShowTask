package ru.clevertec.motor_show.factory;

import ru.clevertec.motor_show.enums.category.CarCategory;
import ru.clevertec.motor_show.model.Category;

public class CategoryFactory {
    public static Category getCategory() {
        return Category.builder()
                .carCategory(CarCategory.COUPE)
                .build();
    }
}