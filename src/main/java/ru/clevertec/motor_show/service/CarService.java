package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.CarShowroom;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    List<Car> findCarsByFilters(String brand, String category, int year, double minPrice, double maxPrice);

    void assignCarToShowroom(Car car, CarShowroom showroom);
}
