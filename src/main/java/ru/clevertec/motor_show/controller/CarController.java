package ru.clevertec.motor_show.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.motor_show.dto.CarRequestDto;
import ru.clevertec.motor_show.dto.CarResponseDto;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Validated
@Slf4j
public class CarController {
    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponseDto createCar(@Valid @RequestBody CarRequestDto carRequestDto) {
        log.debug("Creating car: {}", carRequestDto);
        return carService.addCar(carRequestDto);
    }

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
//        carService.findCarsSortedByPriceAsc();
//
    //list car search DESC
//        carService.findCarsSortedByPriceDesc();

    //foundAllCarWithPagination
//        carService.findAllCars(1, 5);
//}
    @GetMapping
    public ResponseEntity<List<Car>> show() {
        List<Car> car = carService.findAllCars();
        return ResponseEntity.ok(car);
    }
}
