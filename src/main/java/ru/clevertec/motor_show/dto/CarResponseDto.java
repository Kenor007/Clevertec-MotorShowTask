package ru.clevertec.motor_show.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
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
    private CarBrand brandCar;
    private LocalDate yearOfProduction;
    private BigDecimal price;
    private CarShowroom showroom;
    private List<Review> reviews = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private Category category;
}
