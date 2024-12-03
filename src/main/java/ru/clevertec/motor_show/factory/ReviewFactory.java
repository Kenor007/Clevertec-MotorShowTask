package ru.clevertec.motor_show.factory;

import ru.clevertec.motor_show.model.Review;

public class ReviewFactory {
    public static Review createReview() {
        return Review.builder()
                .reviewText("Bad car")
                .rank(1)
                .build();
    }
}