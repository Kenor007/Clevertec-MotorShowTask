package ru.clevertec.motor_show.factory;

import ru.clevertec.motor_show.enums.car.CarBrand;
import ru.clevertec.motor_show.model.Car;

import java.time.LocalDate;

public class CarFactory {
    public static Car getCar() {
        return Car.builder()
                .model("C-6")
                .brandCar(CarBrand.DODGE)
                .yearOfProduction(LocalDate.of(2010, 1, 10))
                .price("15000")
                .build();
    }
}