package ru.clevertec.motor_show.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ClientResponseDto {
    private String name;
    private Set<String> contact = new HashSet<>();
}
