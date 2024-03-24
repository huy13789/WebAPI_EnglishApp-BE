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
@Table(name = "questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "questions", length = 250, nullable = false)
    @Size(max = 250, message = "questions must be less than 250 characters")
    private String questions;

    @Column(name = "answersA", length = 50, nullable = true)
    @Size(max = 50, message = "Answers must be less than 50 characters")
    private String answersA;

    @Column(name = "answersB", length = 50, nullable = true)
    @Size(max = 50, message = "Answers must be less than 50 characters")
    private String answersB;

    @Column(name = "answersC", length = 50, nullable = true)
    @Size(max = 50, message = "Answers must be less than 50 characters")
    private String answersC;

    @Column(name = "answersD", length = 50, nullable = true)
    @Size(max = 50, message = "Answers must be less than 50 characters")
    private String answersD;

    @ManyToOne
    @JoinColumn(name = "answers_id", nullable = false)
    private Answers answers;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;
}
