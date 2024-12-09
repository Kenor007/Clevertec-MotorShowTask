package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.clevertec.motor_show.model.Client;
import ru.clevertec.motor_show.service.ClientService;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    @Override
    public void createClient() {

    }

    @Override
    public void updateClient(Client clientUpdate, Long id) {

    }

    @Override
    public void deleteClient(Long id) {

    }

    @Override
    public void buyCar(Long clientId, Long carId) {

    }
}
