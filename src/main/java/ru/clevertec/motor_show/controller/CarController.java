package ru.clevertec.motor_show.controller;

import ru.clevertec.motor_show.enums.car.CarBrand;
import ru.clevertec.motor_show.enums.category.CarCategory;
import ru.clevertec.motor_show.factory.CarFactory;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.CarShowroom;
import ru.clevertec.motor_show.service.CarService;
import ru.clevertec.motor_show.service.CarShowroomService;
import ru.clevertec.motor_show.service.impl.CarServiceImpl;
import ru.clevertec.motor_show.service.impl.CarShowroomServiceImpl;

import java.time.LocalDate;

public class CarController {
    public static void main(String[] args) {
        CarService carService = new CarServiceImpl();
        CarShowroomService carShowroomService = new CarShowroomServiceImpl();

        // add new car
//        carService.addCar();

        //delete car
//        carService.deleteCarById(1L);

        //update car
//        carService.updateCar(CarFactory.getCar(), 2L);

        //join CarShowroom with Car
//        carService.findAllCars(1, 5);
//        carShowroomService.findAllCarShowrooms();
//        Car car = new Car();
//        car.setId(4L);
//        CarShowroom carShowroom = new CarShowroom();
//        carShowroom.setId(2L);
//        carService.addCarToShowroom(car, carShowroom);

        //search by params
//        CarBrand carBrand = CarBrand.DODGE;
//        LocalDate year = LocalDate.of(2005,2,2);
//        CarCategory category = CarCategory.COUPE;
//        String price = "10000-15000";
//        carService.findCarByParams(carBrand, year, category, price);

        //list car search ASC
        carService.findCarsSortedByPriceAsc();
//
        //list car search DESC
//        carService.findCarsSortedByPriceDesc();

        //foundAllCarWithPagination
//        carService.findAllCars(1, 5);
    }
}