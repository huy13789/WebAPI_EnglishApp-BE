package com.example.WebAPI.service;

import com.example.WebAPI.model.Questions;
import org.springframework.stereotype.Service;

import java.util.List;

public interface QuestionsService {
    void save(Questions questions);
    Questions saveQuestion(Questions questions);
    void deleteQuestionById(long id);
    List<Questions> getAllQuestion();

    List<Questions> getQuestionReading();

    List<Questions> getQuestionListening();
    Questions getQuestionById(Long id);

    Questions updateQuestion(Questions questions);

    void deleteQuestion(Long id);
}

