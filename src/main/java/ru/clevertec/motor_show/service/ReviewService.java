package ru.clevertec.motor_show.service;

public interface ReviewService {
    void addReview(Long clientId, Long cardId);

    void deleteReview(Long id);

    void updateReview(Long id);

    void searchReviewsByKeywords(String keywords);

    void searchReviews(String keywords, Integer minRank, Integer maxRank);
}