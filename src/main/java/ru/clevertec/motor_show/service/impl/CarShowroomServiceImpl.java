package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.motor_show.dto.CarShowroomRequestDto;
import ru.clevertec.motor_show.dto.CarShowroomResponseDto;
import ru.clevertec.motor_show.error_handling.exception.CarShowroomNotFoundException;
import ru.clevertec.motor_show.mapper.CarShowroomMapper;
import ru.clevertec.motor_show.model.CarShowroom;
import ru.clevertec.motor_show.repository.CarShowroomRepository;
import ru.clevertec.motor_show.service.CarShowroomService;

import java.util.Optional;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.CAR_SHOWROOM_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CarShowroomServiceImpl implements CarShowroomService {
    private final CarShowroomRepository carShowroomRepository;
    private final CarShowroomMapper carShowroomMapper;

    @Override
    public CarShowroomResponseDto createCarShowroom(CarShowroomRequestDto carShowroomRequestDto) {
        CarShowroom carShowroom = carShowroomMapper.carShowroomRequestDtoToCarShowroom(carShowroomRequestDto);
        CarShowroom savedCarShowroom = carShowroomRepository.save(carShowroom);
        log.debug("CarShowroom with id {} is saved", savedCarShowroom.getId());
        return carShowroomMapper.carShowroomToCarShowroomResponseDto(savedCarShowroom);
    }

    @Override
    public void delete(Long id) {
        if (carShowroomRepository.existsById(id)) {
            CarShowroom deletedCarShowroom = findCarShowroomByIdOrThrow(id);
            carShowroomRepository.deleteById(id);
            log.debug("CarShowroom with id {} is deleted", id);
        } else {
            log.error("CarShowroom with id {} not found", id);
            throw new CarShowroomNotFoundException(String.format(CAR_SHOWROOM_NOT_FOUND, id));
        }
    }

    @Override
    public CarShowroomResponseDto updateCarShowroom(CarShowroomRequestDto carShowroomRequestDto, Long id) {
        CarShowroom carShowroom = findCarShowroomByIdOrThrow(id);
        Optional.ofNullable(carShowroomRequestDto.getName()).ifPresent(carShowroom::setName);
        Optional.ofNullable(carShowroomRequestDto.getAddress()).ifPresent(carShowroom::setAddress);
        carShowroomRepository.save(carShowroom);
        return carShowroomMapper.carShowroomToCarShowroomResponseDto(carShowroom);
    }

    private CarShowroom findCarShowroomByIdOrThrow(Long carShowroomId) {
        return carShowroomRepository.findById(carShowroomId).orElseThrow(() -> {
            log.error("CarShowroom with id {} not found", carShowroomId);
            return new CarShowroomNotFoundException(String.format(CAR_SHOWROOM_NOT_FOUND, carShowroomId));
        });
    }
}
