package ru.clevertec.motor_show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.motor_show.model.CarShowroom;

@Repository
public interface CarShowroomRepository extends JpaRepository<CarShowroom, Long> {
}
