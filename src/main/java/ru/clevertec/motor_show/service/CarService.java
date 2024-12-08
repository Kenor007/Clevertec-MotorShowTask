package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.dto.CarRequestDto;
import ru.clevertec.motor_show.dto.CarResponseDto;
import ru.clevertec.motor_show.enums.car.CarBrand;
import ru.clevertec.motor_show.enums.category.CarCategory;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.CarShowroom;

import java.time.LocalDate;
import java.util.List;

public interface CarService {
    void findCarById(Long id);

    void findCarByParams(CarBrand carBrand,
                         LocalDate yearOfProduction,
                         CarCategory category,
                         String price);

    void findCarsSortedByPriceAsc();

    void findCarsSortedByPriceDesc();

    void findAllCars(int pageNumber, int pageSize);

    CarResponseDto addCar(CarRequestDto carRequestDto);

    void updateCar(Car car, long id);

    void deleteCarById(Long id);

    void addCarToShowroom(Car car, CarShowroom showroom);

    List<Car> findAllCars();
}