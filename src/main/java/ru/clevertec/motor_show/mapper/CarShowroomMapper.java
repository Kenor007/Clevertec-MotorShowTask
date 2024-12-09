package ru.clevertec.motor_show.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.clevertec.motor_show.dto.CarShowroomRequestDto;
import ru.clevertec.motor_show.dto.CarShowroomResponseDto;
import ru.clevertec.motor_show.model.CarShowroom;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface CarShowroomMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cars", ignore = true)
    CarShowroom carShowroomRequestDtoToCarShowroom(CarShowroomRequestDto carShowroomRequestDto);

    CarShowroomResponseDto carShowroomToCarShowroomResponseDto(CarShowroom carShowroom);
}
