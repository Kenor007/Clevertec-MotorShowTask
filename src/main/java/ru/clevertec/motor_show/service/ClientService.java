package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.dto.ClientRequestDto;
import ru.clevertec.motor_show.dto.ClientResponseDto;

public interface ClientService {
    ClientResponseDto createClient(ClientRequestDto clientRequestDto);

    ClientResponseDto updateClient(ClientRequestDto clientRequestDto, Long id);

    void deleteClient(Long id);

    void buyCar(Long clientId, Long carId);
}
