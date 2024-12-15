package ru.clevertec.motor_show.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewResponseDto {
    private String reviewText;
    private int rank;
}
