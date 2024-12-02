package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.Client;

public interface ClientService {
    void addClient(Client client);

    void buyCar(Client client, Car car);
}
