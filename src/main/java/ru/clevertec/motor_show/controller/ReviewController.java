package ru.clevertec.motor_show.controller;

import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.clevertec.motor_show.dto.ReviewRequestDto;
import ru.clevertec.motor_show.dto.ReviewResponseDto;
import ru.clevertec.motor_show.service.ReviewService;

import java.util.HashMap;
import java.util.Map;

import static ru.clevertec.motor_show.constant.ExceptionAnswer.POSITIVE_ID;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
@Validated
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/{clientId}/car/{carId}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponseDto createReview(@PathVariable @Positive(message = POSITIVE_ID) Long clientId,
                                          @PathVariable @Positive(message = POSITIVE_ID) Long carId,
                                          @Validated @RequestBody ReviewRequestDto reviewRequestDto) {
        return reviewService.createReview(reviewRequestDto, clientId, carId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Positive(message = POSITIVE_ID) Long id) {
        reviewService.deleteReview(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id,
                                                      @Validated @RequestBody ReviewRequestDto reviewRequestDto) {
        ReviewResponseDto reviewResponseDto = reviewService.updateReview(reviewRequestDto, id);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Review successfully updated");
        response.put("updatedReview", reviewResponseDto);
        return ResponseEntity.ok(response);
    }
}
