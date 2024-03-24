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
@Table(name = "answers")
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correct", length = 50, nullable = false, unique = true)
    @Size(max = 50, message = "correct must be less than 250 characters")
    private String correct;
}
