package ru.clevertec.motor_show.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDto {
    @NotBlank(message = "Review should not be blank")
    @Size(min = 10, message = "Review should contain at least 10 characters")
    private String reviewText;

    @NotNull(message = "Rank should not be empty")
    @Min(1)
    @Max(value = 5, message = "Rank should be between 1 and 5 number")
    private int rank;
}
