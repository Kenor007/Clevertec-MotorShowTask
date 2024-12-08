package ru.clevertec.motor_show.enums.category;

import jakarta.persistence.Converter;
import ru.clevertec.motor_show.enums.EnumConverter;

@Converter(autoApply = true)
public class CarCategoryConverter extends EnumConverter<CarCategory> {
    public CarCategoryConverter() {
        super(CarCategory.class);
    }
}