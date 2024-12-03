package ru.clevertec.motor_show.model;

import jakarta.persistence.*;
import lombok.*;
import ru.clevertec.motor_show.enums.category.CarCategory;
import ru.clevertec.motor_show.enums.category.CarCategoryConverter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CarCategoryConverter.class)
    @Column(name = "name_category_car")
    private CarCategory carCategory;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Car> cars = new ArrayList<>();
}