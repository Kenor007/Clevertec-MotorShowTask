package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.Client;
import ru.clevertec.motor_show.model.Review;

import java.util.List;

public interface ReviewService {
    void addReview(Client client, Car car, String text, int rating);

    List<Review> searchReviews(String keyword);
}
