package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.Client;
import ru.clevertec.motor_show.model.Review;
import ru.clevertec.motor_show.repository.ReviewRepository;
import ru.clevertec.motor_show.service.ReviewService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public void addReview(Client client, Car car, String text, int rating) {
        Review review = new Review();
        review.setClient(client);
        review.setCar(car);
        review.setText(text);
        review.setRating(rating);
        reviewRepository.save(review);
    }

    @Override
    public List<Review> searchReviews(String keyword) {
        return List.of();
    }
}
