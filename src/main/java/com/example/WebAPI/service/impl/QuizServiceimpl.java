package com.example.WebAPI.service.impl;

import com.example.WebAPI.model.Quiz;
import com.example.WebAPI.model.User;
import com.example.WebAPI.repository.IQuizRespository;
import com.example.WebAPI.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizServiceimpl implements QuizService {
    @Autowired
    private IQuizRespository iQuizRespository;
    @Override
    public List<Quiz> getQuizByCategoryID(Long id) {
        return iQuizRespository.findByCategoryId(id);
    }
    @Override
    public void save(Quiz quiz) {
        iQuizRespository.save(quiz);
    }
    @Override
    public Quiz saveQuiz(Quiz quiz) {
        iQuizRespository.save(quiz);
        Long categoryId= iQuizRespository.getQuizId(quiz.getQuizId());
        if(categoryId == 0)
            return quiz;
        return quiz;
    }
    @Override
    public void deleteQuizById(long id) {
        this.iQuizRespository.deleteById(id);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return iQuizRespository.findAll();
    }

    @Override
    public List<Quiz> getQuizReading() {
        List<Quiz> quizList = iQuizRespository.findAll();
        List<Quiz> readingQuizzes = quizList.stream()
                .filter(quiz -> quiz.getCategory().isReading())
                .collect(Collectors.toList());
        return readingQuizzes;
    }

    @Override
    public List<Quiz> getQuizListening() {
        List<Quiz> quizList = iQuizRespository.findAll();
        List<Quiz> readingQuizzes = quizList.stream()
                .filter(quiz -> !quiz.getCategory().isReading())
                .collect(Collectors.toList());
        return readingQuizzes;
    }


    @Override
    public Quiz getQuizById(Long quizId) {
        Optional<Quiz> optional = iQuizRespository.findById(quizId);
        if(optional.isPresent())
        {
            return optional.get();
        } else {
            throw new RuntimeException("User not found for id " + quizId);
        }
    }
    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return null;
    }

    @Override
    public void deleteQuiz(Long id) {

    }
}
