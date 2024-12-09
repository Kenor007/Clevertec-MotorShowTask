package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.dto.CarShowroomRequestDto;
import ru.clevertec.motor_show.dto.CarShowroomResponseDto;

public interface CarShowroomService {
    CarShowroomResponseDto createCarShowroom(CarShowroomRequestDto carShowroomRequestDto);

    void delete(Long id);

    CarShowroomResponseDto updateCarShowroom(CarShowroomRequestDto carShowroomRequestDto, Long id);
}
