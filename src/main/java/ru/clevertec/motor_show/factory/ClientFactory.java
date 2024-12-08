package ru.clevertec.motor_show.factory;

import ru.clevertec.motor_show.model.Client;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ClientFactory {
    public static Client createClient() {
        Set<String> cantacts = new HashSet<>();
        cantacts.add("max@gmail.com");
        cantacts.add("+375297777777");
        cantacts.add("Pobediteley st 6");
        return Client.builder()
                .name("Max")
                .contacts(cantacts)
                .dateOfRegistration(LocalDate.now())
                .build();
    }
}