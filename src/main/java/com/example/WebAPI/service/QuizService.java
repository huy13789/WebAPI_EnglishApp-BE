package com.example.WebAPI.service;

import com.example.WebAPI.model.Quiz;

import java.util.List;

public interface QuizService {
    void save(Quiz quiz);
    Quiz saveQuiz(Quiz quiz);
    void deleteQuizById(long id);
    List<Quiz> getAllQuiz();

    List<Quiz> getQuizReading();
    List<Quiz> getQuizListening();

    Quiz updateQuiz(Quiz quiz);

    void deleteQuiz(Long id);
    List<Quiz> getQuizByCategoryID(Long id);

    Quiz getQuizById(Long quizId); // Thêm phương thức này
}
