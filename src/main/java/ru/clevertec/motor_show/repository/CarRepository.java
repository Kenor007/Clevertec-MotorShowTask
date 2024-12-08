package ru.clevertec.motor_show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.motor_show.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findCarById(Long id);
}
