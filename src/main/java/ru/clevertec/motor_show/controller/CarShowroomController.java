package ru.clevertec.motor_show.controller;

import ru.clevertec.motor_show.factory.CarShowroomFactory;
import ru.clevertec.motor_show.service.CarShowroomService;
import ru.clevertec.motor_show.service.impl.CarShowroomServiceImpl;

public class CarShowroomController {
    public static void main(String[] args) {
        CarShowroomService showroom = new CarShowroomServiceImpl();

        //add showroom
//        showroom.addCarShowroom();

        //delete showroom
//        showroom.removeCarShowroom(1l);

        //update showroom
//        showroom.updateCarShowroom(CarShowroomFactory.getCarShowroom(), 2L);
    }
}