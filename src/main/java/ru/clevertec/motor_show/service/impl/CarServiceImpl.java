package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.motor_show.dto.CarRequestDto;
import ru.clevertec.motor_show.dto.CarResponseDto;
import ru.clevertec.motor_show.error_handling.exception.CarNotFoundException;
import ru.clevertec.motor_show.error_handling.exception.CarShowroomNotFoundException;
import ru.clevertec.motor_show.mapper.CarMapper;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.CarShowroom;
import ru.clevertec.motor_show.repository.CarRepository;
import ru.clevertec.motor_show.repository.CarShowroomRepository;
import ru.clevertec.motor_show.service.CarService;

import java.util.List;
import java.util.Optional;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.CAR_NOT_FOUND;
import static ru.clevertec.motor_show.constant.ExceptionAnswer.CAR_SHOWROOM_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarShowroomRepository carShowroomRepository;
    private final CarMapper carMapper;

    @Override
    @Transactional
    public CarResponseDto createCar(CarRequestDto carRequestDto) {
        Car car = carMapper.carRequestDtotoCar(carRequestDto);
        Car savedCar = carRepository.save(car);
        log.debug("Car with id {} is saved", savedCar.getId());
        return carMapper.carToCarResponseDto(savedCar);
    }

    @Override
    @Transactional(readOnly = true)
    public CarResponseDto findCarById(Long id) {
        Car car = findCarByIdOrThrow(id);
        log.debug("Car with id {} is found", car.getId());
        return carMapper.carToCarResponseDto(car);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarResponseDto> findAllCars() {
        List<Car> cars = carRepository.findAll();
        if (cars.isEmpty()) {
            log.debug("List of cars is empty");
        }
        log.debug("List of cars has been found");
        return cars.stream().map(carMapper::carToCarResponseDto).toList();
    }

    @Override
    @Transactional
    public CarResponseDto updateCar(CarRequestDto carRequestDto, Long id) {
        Car car = findCarByIdOrThrow(id);
        Optional.ofNullable(carRequestDto.getModel()).ifPresent(car::setModel);
        Optional.ofNullable(carRequestDto.getYearOfProduction()).ifPresent(car::setYearOfProduction);
        Optional.ofNullable(carRequestDto.getBrandCar()).ifPresent(car::setBrandCar);
        Optional.ofNullable(carRequestDto.getPrice()).ifPresent(car::setPrice);
        Car savedCar = carRepository.save(car);
        return carMapper.carToCarResponseDto(savedCar);
    }

    @Override
    @Transactional
    public void deleteCar(Long id) {
        if (carRepository.existsById(id)) {
            Car deletedCar = findCarByIdOrThrow(id);
            carRepository.deleteById(id);
            log.debug("Car with id {} is deleted", id);
        } else {
            log.error("Car with id {} not found", id);
            throw new CarNotFoundException(String.format(CAR_NOT_FOUND, id));
        }
    }

    @Override
    @Transactional
    public void assignCarToShowroom(Long carId, Long showroomId) {
        findCarByIdOrThrow(carId);
        CarShowroom showroom = carShowroomRepository.findById(showroomId)
                .orElseThrow(() -> new CarShowroomNotFoundException(String.format(CAR_SHOWROOM_NOT_FOUND, showroomId)));
        carRepository.assignCarToShowroom(carId, showroom);
    }

    private Car findCarByIdOrThrow(Long carId) {
        return carRepository.findById(carId).orElseThrow(() -> {
            log.error("Car with id {} not found", carId);
            return new CarNotFoundException(String.format(CAR_NOT_FOUND, carId));
        });
    }
}
