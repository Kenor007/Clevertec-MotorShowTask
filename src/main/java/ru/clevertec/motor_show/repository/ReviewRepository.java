package ru.clevertec.motor_show.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.motor_show.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
