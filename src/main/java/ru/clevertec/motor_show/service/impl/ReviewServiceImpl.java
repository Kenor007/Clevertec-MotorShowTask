package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.clevertec.motor_show.service.ReviewService;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    @Override
    public void addReview(Long clientId, Long cardId) {

    }

    @Override
    public void deleteReview(Long id) {

    }

    @Override
    public void updateReview(Long id) {

    }

    @Override
    public void searchReviewsByKeywords(String keywords) {

    }
}
