package ru.clevertec.motor_show.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarRequestDto {
    @NotBlank(message = "Car model should not be blank")
    @Size(min = 1, message = "Car model should contain at least 1 character")
    private String model;
    @NotBlank(message = "Car brand should not be blank")
    @Size(min = 1, message = "Car brand should contain at least 1 character")
    private String brandCar;
    private LocalDate yearOfProduction;
//    private BigDecimal price;
//    private CarShowroom showroom;
//    private List<Review> reviews = new ArrayList<>();
//    private List<Client> clients = new ArrayList<>();
//    private Category category;
}
