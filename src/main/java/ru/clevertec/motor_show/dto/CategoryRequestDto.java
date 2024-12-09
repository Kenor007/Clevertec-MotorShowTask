package ru.clevertec.motor_show.dto;

import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ru.clevertec.motor_show.annotation.EnumValidator;
import ru.clevertec.motor_show.enums.category.CarCategory;
import ru.clevertec.motor_show.enums.category.CarCategoryConverter;

@Getter
@Setter
public class CategoryRequestDto {
    @Convert(converter = CarCategoryConverter.class)
    @NotBlank(message = "Car category should not be blank")
    @EnumValidator(enumClass = CarCategory.class, message = "Invalid category. Must match one of car category value")
    private String carCategory;
}
