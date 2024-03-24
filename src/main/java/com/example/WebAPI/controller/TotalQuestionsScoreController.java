package com.example.WebAPI.controller;

import com.example.WebAPI.model.Category;
import com.example.WebAPI.model.Questions;
import com.example.WebAPI.model.Quiz;
import com.example.WebAPI.model.TotalQuestionsScore;
import com.example.WebAPI.repository.ITotalQuestionsScoreRespository;
import com.example.WebAPI.service.TotalQuestionsScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/totalScore")
public class TotalQuestionsScoreController {

    @Autowired
    private TotalQuestionsScoreService service;
    @Autowired
    private ITotalQuestionsScoreRespository iTotalQuestionsScoreRespository;
    @PostMapping("/save")
    public ResponseEntity<String> saveTotalScore(@RequestBody TotalQuestionsScore totalScore) {
        try {
            TotalQuestionsScore savedScore = service.saveTotalScore(totalScore);
            return ResponseEntity.ok(savedScore.getTotalScoreId().toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving total score: " + e.getMessage());
        }
    }
    @GetMapping("/getUserId/{userId}")
    public ResponseEntity<List<TotalQuestionsScore>> getUserTotalQuestionsScores(@PathVariable Long userId) {
        List<TotalQuestionsScore> scores = iTotalQuestionsScoreRespository.findByUserId(userId);
        if (scores.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(scores);
    }
    @GetMapping("/getall")
    public List<TotalQuestionsScore> getAllCategories() {
        return service.getalltotal();
    }

}
