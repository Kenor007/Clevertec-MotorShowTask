package ru.clevertec.motor_show.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ClientRequestDto {
    @NotBlank(message = "Name should not be blank")
    @Size(min = 5, message = "Name should contain at least 5 character")
    private String name;

    @NotNull(message = "Contact set should not be null")
    @NotEmpty(message = "Contact set should not be empty")
    private Set<@Pattern(regexp = "^\\+?[0-9]{1,4}?[\\s\\-]?[0-9]+[\\s\\-]?[0-9]+$", message = "Invalid phone number") String> contact = new HashSet<>();
}
