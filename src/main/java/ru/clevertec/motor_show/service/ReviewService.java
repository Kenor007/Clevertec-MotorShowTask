package ru.clevertec.motor_show.service;

import ru.clevertec.motor_show.dto.ReviewRequestDto;
import ru.clevertec.motor_show.dto.ReviewResponseDto;

public interface ReviewService {
    ReviewResponseDto createReview(ReviewRequestDto reviewRequestDto, Long clientId, Long carId);

    void deleteReview(Long id);

    ReviewResponseDto updateReview(ReviewRequestDto reviewRequestDto, Long id);
}
