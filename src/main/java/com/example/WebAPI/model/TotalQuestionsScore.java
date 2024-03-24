package com.example.WebAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "totalquestionsscore")
public class TotalQuestionsScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalScoreId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(name = "total_score", nullable = true)
    private double totalScore;

    @OneToMany(mappedBy = "totalQuestionsScore", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<QuestionsScore> questionsScores;

    public Long getTotalScoreId() {
        return totalScoreId;
    }
}
