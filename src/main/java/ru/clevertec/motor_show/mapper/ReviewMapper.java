package ru.clevertec.motor_show.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.clevertec.motor_show.dto.ReviewRequestDto;
import ru.clevertec.motor_show.dto.ReviewResponseDto;
import ru.clevertec.motor_show.model.Review;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReviewMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "cars", ignore = true)
    @Mapping(target = "clients", ignore = true)
    Review reviewRequestDtoToReview(ReviewRequestDto reviewRequestDto);

    ReviewResponseDto reviewToReviewResponseDto(Review review);
}
