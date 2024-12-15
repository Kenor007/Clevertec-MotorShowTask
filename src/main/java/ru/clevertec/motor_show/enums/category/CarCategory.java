package ru.clevertec.motor_show.enums.category;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import ru.clevertec.motor_show.service.Describable;
import ru.clevertec.motor_show.util.CarCategoryDeserializer;

@Getter
@JsonDeserialize(using = CarCategoryDeserializer.class)
public enum CarCategory implements Describable {
    SEDAN("SEDAN"),
    HATCHBACK("HATCHBACK"),
    CROSSOVER("CROSSOVER"),
    COUPE("COUPE"),
    CONVERTIBLE("CABRIOLET"),
    WAGON("WAGON"),
    MINIVAN("MINIVAN"),
    PICKUP("PICKUP"),
    SPORTCAR("SPORTCAR"),
    ELECTRIC("ELECTRIC"),
    OFFROAD("OFFROAD"),
    MICROCAR("MICROCAR"),
    TRUCK("TRUCK"),
    VAN("VAN"),
    BUS("BUS");

    private final String description;

    CarCategory(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
