package ru.clevertec.motor_show.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.GenericField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Indexed
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @FullTextField(analyzer = "standard")
    private String reviewText;

    @GenericField
    private int rank;
    @ManyToOne
    private Client client;
    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Car cars;
    @ManyToOne
    @JoinColumn(name = "clients_id")
    private Client clients;
}