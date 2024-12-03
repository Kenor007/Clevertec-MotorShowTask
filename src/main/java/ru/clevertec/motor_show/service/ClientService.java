package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.model.Client;

public interface ClientService {
    void createClient();

    void updateClient(Client clientUpdate, Long id);

    void deleteClient(Long id);

    void buyCar(Long clientId, Long carId);
}