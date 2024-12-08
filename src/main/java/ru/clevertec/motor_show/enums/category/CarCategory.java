package ru.clevertec.motor_show.enums.category;

import lombok.Getter;
import ru.clevertec.motor_show.service.Describable;

@Getter
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