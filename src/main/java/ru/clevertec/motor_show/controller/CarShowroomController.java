package ru.clevertec.motor_show.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.motor_show.dto.CarShowroomRequestDto;
import ru.clevertec.motor_show.dto.CarShowroomResponseDto;
import ru.clevertec.motor_show.error_handling.exception.CarShowroomNotFoundException;
import ru.clevertec.motor_show.service.CarShowroomService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/showrooms")
@RequiredArgsConstructor
@Validated
@Slf4j
public class CarShowroomController {
    private final CarShowroomService showroomService;

    @PostMapping
    public CarShowroomResponseDto createCarShowroom(@Validated @RequestBody CarShowroomRequestDto carShowroomRequestDto) {
        log.debug("Creating showroom: {}", carShowroomRequestDto);
        return showroomService.createCarShowroom(carShowroomRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            showroomService.delete(id);
            return ResponseEntity.ok("CarShowroom successfully deleted with id: " + id);
        } catch (CarShowroomNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CarShowroom not found with id: " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id,
                                                      @Validated @RequestBody CarShowroomRequestDto carShowroomRequestDto) {
        CarShowroomResponseDto carShowroomResponseDto = showroomService.updateCarShowroom(carShowroomRequestDto, id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Car showroom successfully updated.");
        response.put("updatedShowroom", carShowroomResponseDto);
        return ResponseEntity.ok(response);
    }

}
