package ru.clevertec.motor_show.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import ru.clevertec.motor_show.enums.car.CarBrand;
import ru.clevertec.motor_show.enums.car.CarBrandConverter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CarRequestDto {
    @NotBlank(message = "Car model should not be blank")
    @Size(min = 1, message = "Car model should contain at least 1 character")
    private String model;

    @Convert(converter = CarBrandConverter.class)
    @NotNull(message = "BrandCar not should by empty")
    private CarBrand brandCar;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate yearOfProduction;
    @NotEmpty
    @Size(min = 1, max = 1000000)
    private BigDecimal price;
}
