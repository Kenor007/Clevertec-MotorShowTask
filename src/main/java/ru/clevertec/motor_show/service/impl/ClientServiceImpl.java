package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.motor_show.dto.ClientRequestDto;
import ru.clevertec.motor_show.dto.ClientResponseDto;
import ru.clevertec.motor_show.error_handling.exception.CarNotFoundException;
import ru.clevertec.motor_show.error_handling.exception.ClientNotFoundException;
import ru.clevertec.motor_show.mapper.ClientMapper;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.Client;
import ru.clevertec.motor_show.repository.CarRepository;
import ru.clevertec.motor_show.repository.ClientRepository;
import ru.clevertec.motor_show.service.ClientService;

import java.util.Optional;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.CAR_NOT_FOUND;
import static ru.clevertec.motor_show.constant.ExceptionAnswer.CLIENT_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final ClientMapper clientMapper;


    @Override
    public ClientResponseDto createClient(ClientRequestDto clientRequestDto) {
        Client client = clientMapper.clientRequestDtoToClient(clientRequestDto);
        Client savedClient = clientRepository.save(client);
        log.debug("Client with id {} is saved", savedClient.getId());
        return clientMapper.clientToClientResponseDto(savedClient);
    }

    @Override
    public ClientResponseDto updateClient(ClientRequestDto clientRequestDto, Long id) {
        Client client = findClientByIdOrThrow(id);
        Optional.ofNullable(clientRequestDto.getName()).ifPresent(client::setName);
        Optional.ofNullable(clientRequestDto.getContact()).ifPresent(client::setContacts);
        Client savedClient = clientRepository.save(client);
        return clientMapper.clientToClientResponseDto(savedClient);
    }

    @Override
    public void deleteClient(Long id) {
        if (clientRepository.existsById(id)) {
            Client deletedClient = findClientByIdOrThrow(id);
            clientRepository.deleteById(id);
            log.debug("Client with id {} is deleted", id);
        } else {
            log.error("Client with id {} not found", id);
            throw new ClientNotFoundException(String.format(CLIENT_NOT_FOUND, id));
        }
    }

    @Override
    public void buyCar(Long clientId, Long carId) {
        Client client = findClientByIdOrThrow(clientId);
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException(String.format(CAR_NOT_FOUND, carId)));
        log.error("Car not found with id {}", carId);
        client.getCars().add(car);
        clientRepository.save(client);
    }

    private Client findClientByIdOrThrow(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> {
            log.error("Client with id {} not found", clientId);
            return new ClientNotFoundException(String.format(CLIENT_NOT_FOUND, clientId));
        });
    }
}
