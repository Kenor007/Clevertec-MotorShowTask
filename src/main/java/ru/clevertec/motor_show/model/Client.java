package ru.clevertec.motor_show.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate registrationDate;

    @ElementCollection
    private List<String> contacts;

    @ManyToMany
    @JoinTable(name = "client_cars")
    private List<Car> cars;

    @OneToMany(mappedBy = "client")
    private List<Review> reviews;
}
