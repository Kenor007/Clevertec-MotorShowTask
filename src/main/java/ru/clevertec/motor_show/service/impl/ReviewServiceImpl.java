package ru.clevertec.motor_show.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.motor_show.dto.ReviewRequestDto;
import ru.clevertec.motor_show.dto.ReviewResponseDto;
import ru.clevertec.motor_show.error_handling.exception.CarNotFoundException;
import ru.clevertec.motor_show.error_handling.exception.ClientNotFoundException;
import ru.clevertec.motor_show.error_handling.exception.ReviewNotFoundException;
import ru.clevertec.motor_show.mapper.ReviewMapper;
import ru.clevertec.motor_show.model.Car;
import ru.clevertec.motor_show.model.Client;
import ru.clevertec.motor_show.model.Review;
import ru.clevertec.motor_show.repository.CarRepository;
import ru.clevertec.motor_show.repository.ClientRepository;
import ru.clevertec.motor_show.repository.ReviewRepository;
import ru.clevertec.motor_show.service.ReviewService;

import java.util.Optional;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.CAR_NOT_FOUND;
import static ru.clevertec.motor_show.constant.ExceptionAnswer.CLIENT_NOT_FOUND;
import static ru.clevertec.motor_show.constant.ExceptionAnswer.REVIEW_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ClientRepository clientRepository;
    private final CarRepository carRepository;
    private final ReviewMapper reviewMapper;

    @Override
    public ReviewResponseDto createReview(ReviewRequestDto reviewRequestDto, Long clientId, Long carId) {
        Review review = reviewMapper.reviewRequestDtoToReview(reviewRequestDto);
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(String.format(CLIENT_NOT_FOUND, clientId)));
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException(String.format(CAR_NOT_FOUND, carId)));
        review.setClients(client);
        review.setCar(car);
        Review savedReview = reviewRepository.save(review);
        log.debug("Review with id {} is saved", savedReview.getId());
        return reviewMapper.reviewToReviewResponseDto(savedReview);
    }

    @Override
    public void deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            Review deletedReview = findReviewByIdOrThrow(id);
            reviewRepository.deleteById(id);
            log.debug("Review with id {} is deleted", id);
        } else {
            log.error("Review with id {} not found", id);
            throw new ReviewNotFoundException(String.format(REVIEW_NOT_FOUND, id));
        }
    }

    @Override
    public ReviewResponseDto updateReview(ReviewRequestDto reviewRequestDto, Long id) {
        Review review = findReviewByIdOrThrow(id);
        Optional.ofNullable(reviewRequestDto.getReviewText()).ifPresent(review::setReviewText);
        Optional.of(reviewRequestDto.getRank()).ifPresent(review::setRank);
        Review savedReview = reviewRepository.save(review);
        return reviewMapper.reviewToReviewResponseDto(savedReview);
    }

    private Review findReviewByIdOrThrow(Long reviewId) {
        return reviewRepository.findById(reviewId).orElseThrow(() -> {
            log.error("Review with id {} not found", reviewId);
            return new ReviewNotFoundException(String.format(REVIEW_NOT_FOUND, reviewId));
        });
    }
}
