package ru.clevertec.motor_show.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarShowroomRequestDto {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 3, message = "Name should contain at least 3 character")
    private String name;

    @NotBlank(message = "Address should not be blank")
    @Size(min = 3, message = "Address should contain at least 3 character")
    private String address;
}
