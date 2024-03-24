package com.example.WebAPI.controller;

import com.example.WebAPI.model.Quiz;
import com.example.WebAPI.model.User;
import com.example.WebAPI.repository.IQuizRespository;
import com.example.WebAPI.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuizById(@PathVariable Long id) {
        Quiz quiz = quizService.getQuizById(id);
        if (quiz != null) {
            return ResponseEntity.ok(quiz);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
