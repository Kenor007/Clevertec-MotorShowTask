package ru.clevertec.motor_show.factory;

import ru.clevertec.motor_show.model.CarShowroom;

public class CarShowroomFactory {
    public static CarShowroom getCarShowroom() {
        return CarShowroom.builder()
                .name("Big auto")
                .address("Korganovo 18")
                .build();
    }
}