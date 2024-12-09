package ru.clevertec.motor_show.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.clevertec.motor_show.enums.car.CarBrand;
import ru.clevertec.motor_show.enums.car.CarBrandConverter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    @Convert(converter = CarBrandConverter.class)
    @Column(name = "brand_car")
    private CarBrand brandCar;
    private LocalDate yearOfProduction;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "car_showroom_id")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private CarShowroom showroom;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "cars", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @Builder.Default
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private List<Client> clients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Category category;
}
