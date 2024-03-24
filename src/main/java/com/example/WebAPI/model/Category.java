package com.example.WebAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameCategory", length = 50, nullable = false, unique = true)
    @Size(max = 50, message = "nameCategory must be less than 250 characters")
    private String nameCategory;

    @Column(name = "isReading", nullable = false)
    private boolean isReading;
}
