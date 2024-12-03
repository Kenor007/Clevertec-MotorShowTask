package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.model.CarShowroom;

public interface CarShowroomService {
    void addCarShowroom();

    void removeCarShowroom(Long id);

    void updateCarShowroom(CarShowroom carShowroom, Long id);

    void findAllCarShowrooms();
}