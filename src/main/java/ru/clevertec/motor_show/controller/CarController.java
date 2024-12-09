package ru.clevertec.motor_show.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.motor_show.dto.CarRequestDto;
import ru.clevertec.motor_show.dto.CarResponseDto;
import ru.clevertec.motor_show.service.CarService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.POSITIVE_ID;

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
        return carService.createCar(carRequestDto);
    }

    @GetMapping("/{id}")
    public CarResponseDto findCarById(@PathVariable @Positive(message = POSITIVE_ID) Long id) {
        log.debug("Getting car by id: {}", id);
        return carService.findCarById(id);
    }

    @GetMapping
    public List<CarResponseDto> findAllCars() {
        log.debug("Getting all cars");
        return carService.findAllCars();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id,
                                                      @Validated @RequestBody CarRequestDto carRequestDto) {
        CarResponseDto carResponseDto = carService.updateCar(carRequestDto, id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Car successfully updated.");
        response.put("updatedCar", carResponseDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{carId}/showroom/{showroomId}")
    public ResponseEntity<String> assignCarToShowroom(
            @PathVariable Long carId,
            @PathVariable Long showroomId) {
        carService.assignCarToShowroom(carId, showroomId);
        return ResponseEntity.ok("Car assigned to showroom successfully");
    }

}
