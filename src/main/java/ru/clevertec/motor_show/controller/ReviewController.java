package ru.clevertec.motor_show.controller;

import ru.clevertec.motor_show.service.ReviewService;
import ru.clevertec.motor_show.service.impl.ReviewServiceImpl;

public class ReviewController {
    public static void main(String[] args) {
        ReviewService reviewService = new ReviewServiceImpl();
        //add review
//        reviewService.addReview(1L, 3L);

        // update review
//        reviewService.updateReview(1L);

        //delete review
//        reviewService.deleteReview(2L);

        //search reviews by keywords
//        String keyWords = "Great car";
//        reviewService.searchReviewsByKeywords(keyWords);

        //search by Lucene
//        String keywords = "car";
//        Integer minRank = 1;
//        Integer maxRank = 2;
//        reviewService.searchReviews(keywords, minRank, maxRank);
    }
}