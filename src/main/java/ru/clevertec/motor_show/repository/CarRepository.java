package ru.clevertec.motor_show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.CarShowroom;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Modifying
    @Query("UPDATE Car c SET c.showroom = :showroom WHERE c.id = :carId")
    void assignCarToShowroom(@Param("carId") Long carId, @Param("showroom") CarShowroom showroom);
}
