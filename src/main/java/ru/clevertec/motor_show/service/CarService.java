package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.dto.CarRequestDto;
import ru.clevertec.motor_show.dto.CarResponseDto;

import java.util.List;

public interface CarService {
    CarResponseDto createCar(CarRequestDto carRequestDto);

    CarResponseDto findCarById(Long id);

    List<CarResponseDto> findAllCars();

    CarResponseDto updateCar(CarRequestDto carRequestDto, Long id);

    void deleteCar(Long id);

    void assignCarToShowroom(Long carId, Long showroomId);
}
