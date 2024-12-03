package ru.clevertec.motor_show.controller;

import ru.clevertec.motor_show.factory.ClientFactory;
import ru.clevertec.motor_show.service.ClientService;
import ru.clevertec.motor_show.service.impl.ClientServiceImpl;

public class ClientController {
    public static void main(String[] args) {
        ClientService client = new ClientServiceImpl();
        //add client
//        client.createClient();

        //client update
//        client.updateClient(ClientFactory.createClient(), 3L);

        //delete client
//        client.deleteClient(1l);

        //buyCar
        client.buyCar(2L, 3L);
    }
}