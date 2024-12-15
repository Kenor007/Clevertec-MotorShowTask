package ru.clevertec.motor_show.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.clevertec.motor_show.dto.ClientRequestDto;
import ru.clevertec.motor_show.dto.ClientResponseDto;
import ru.clevertec.motor_show.model.Client;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateOfRegistration", ignore = true)
    @Mapping(target = "cars", ignore = true)
    @Mapping(target = "reviews", ignore = true)
    Client clientRequestDtoToClient(ClientRequestDto clientRequestDto);

    ClientResponseDto clientToClientResponseDto(Client client);
}
