package ru.clevertec.motor_show.dto;

import lombok.Getter;
import lombok.Setter;
import ru.clevertec.motor_show.enums.category.CarCategory;

@Getter
@Setter
public class CategoryResponseDto {
    private CarCategory carCategory;
}
