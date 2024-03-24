package com.example.WebAPI.repository;

import com.example.WebAPI.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionsRepository extends JpaRepository<Questions,Long> {
    @Query("SELECT p FROM Questions  p WHERE p.quiz.id = :id")
    List<Questions> findQByQuizId(Long id);
    @Query("SELECT c.id FROM Questions c WHERE c.id = :id")
    Long getQuestionId(long id);
    @Query("SELECT c FROM Questions c WHERE id = :id")
    Questions findByQuestionId(Long id);

    @Query("SELECT q FROM Questions q WHERE q.quiz.category.isReading = true")
    List<Questions> findReadingQuestions();

    @Query("SELECT q FROM Questions q WHERE q.quiz.category.isReading = false")
    List<Questions> findReadingListening();
}
