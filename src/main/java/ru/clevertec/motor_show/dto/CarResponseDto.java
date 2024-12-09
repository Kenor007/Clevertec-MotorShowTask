package ru.clevertec.motor_show.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Convert;
import lombok.Getter;
import lombok.Setter;
import ru.clevertec.motor_show.enums.car.CarBrand;
import ru.clevertec.motor_show.enums.car.CarBrandConverter;
import ru.clevertec.motor_show.model.CarShowroom;
import ru.clevertec.motor_show.model.Category;
import ru.clevertec.motor_show.model.Client;
import ru.clevertec.motor_show.model.Review;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CarResponseDto {
    private Long id;
    private String model;
    @Convert(converter = CarBrandConverter.class)
    private CarBrand brandCar;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate yearOfProduction;
    private BigDecimal price;
    private CarShowroom showroom;
    private List<Review> reviews = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private Category category;
}
