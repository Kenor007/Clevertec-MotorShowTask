package ru.clevertec.motor_show.error_handling.exception;

public class CarShowroomNotFoundException extends RuntimeException {
    public CarShowroomNotFoundException(String message) {
        super(message);
    }
}
