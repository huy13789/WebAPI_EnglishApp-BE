package com.example.WebAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "questionscore")
public class QuestionsScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

    @ManyToOne
    @JoinColumn(name = "user_answer_id", nullable = false)
    private Answers userAnswer;

    @Column(name = "is_correct", nullable = false)
    private Boolean  isCorrect;

    @ManyToOne
    @JoinColumn(name = "total_questions_score_id", nullable = false)
    @JsonBackReference
    private TotalQuestionsScore totalQuestionsScore;
}
