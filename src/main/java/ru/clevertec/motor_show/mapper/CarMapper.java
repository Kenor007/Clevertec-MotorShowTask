package ru.clevertec.motor_show.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.clevertec.motor_show.dto.CarRequestDto;
import ru.clevertec.motor_show.dto.CarResponseDto;
import ru.clevertec.motor_show.enums.car.CarBrandConverter;
import ru.clevertec.motor_show.model.Car;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = CarBrandConverter.class)
public interface CarMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "showroom", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    @Mapping(target = "clients", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "yearOfProduction", source = "yearOfProduction", dateFormat = "yyyy-MM-dd")
    Car carRequestDtotoCar(CarRequestDto carRequestDto);

    @Mapping(target = "model", source = "model")
    @Mapping(target = "brandCar", source = "brandCar")
    @Mapping(target = "yearOfProduction", source = "yearOfProduction")
    @Mapping(target = "price", source = "price")
    CarResponseDto carToCarResponseDto(Car car);
}
