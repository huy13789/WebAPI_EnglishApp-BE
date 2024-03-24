package com.example.WebAPI.controller;

import com.example.WebAPI.model.QuestionsScore;
import com.example.WebAPI.service.QuestionsScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questionsscrore")
public class QuestionsScroreController {
    @Autowired
    QuestionsScoreService questionsScoreService;
    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody List<QuestionsScore> questionsScores) {
        try {
            questionsScoreService.saveDetailScore(questionsScores);
            return ResponseEntity.ok("Quiz submitted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting quiz.");
        }
    }
}
