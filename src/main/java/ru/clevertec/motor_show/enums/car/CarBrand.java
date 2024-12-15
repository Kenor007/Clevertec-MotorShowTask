package ru.clevertec.motor_show.enums.car;

import lombok.Getter;
import ru.clevertec.motor_show.service.Describable;

@Getter
public enum CarBrand implements Describable {
    TOYOTA("Toyota"),
    HONDA("Honda"),
    FORD("Ford"),
    CHEVROLET("Chevrolet"),
    BMW("BMW"),
    MERCEDES("Mercedes-Benz"),
    AUDI("Audi"),
    VOLKSWAGEN("Volkswagen"),
    TESLA("Tesla"),
    NISSAN("Nissan"),
    KIA("Kia"),
    HYUNDAI("Hyundai"),
    SUBARU("Subaru"),
    MAZDA("Mazda"),
    JEEP("Jeep"),
    DODGE("Dodge"),
    PORSCHE("Porsche"),
    FERRARI("Ferrari"),
    LAMBORGHINI("Lamborghini"),
    ROLLS_ROYCE("Rolls-Royce"),
    BENTLEY("Bentley"),
    VOLVO("Volvo"),
    LAND_ROVER("Land Rover"),
    JAGUAR("Jaguar"),
    PEUGEOT("Peugeot"),
    RENAULT("Renault"),
    FIAT("Fiat"),
    SKODA("Skoda"),
    SEAT("SEAT "),
    SUZUKI("Suzuki"),
    MITSUBISHI("Mitsubishi"),
    LEXUS("Lexus");

    private final String description;

    CarBrand(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
