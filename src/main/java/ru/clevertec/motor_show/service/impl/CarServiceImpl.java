package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.CarShowroom;
import ru.clevertec.motor_show.repository.CarRepository;
import ru.clevertec.motor_show.service.CarService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> findCarsByFilters(String brand, String category, int year, double minPrice, double maxPrice) {
        return List.of();
    }

    @Override
    public void assignCarToShowroom(Car car, CarShowroom showroom) {
        car.setShowroom(showroom);
        carRepository.save(car);
    }
}
