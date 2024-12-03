package ru.clevertec.motor_show.enums.car;

import jakarta.persistence.Converter;
import ru.clevertec.motor_show.enums.EnumConverter;

@Converter(autoApply = true)
public class CarBrandConverter extends EnumConverter<CarBrand> {
    public CarBrandConverter() {
        super(CarBrand.class);
    }
}