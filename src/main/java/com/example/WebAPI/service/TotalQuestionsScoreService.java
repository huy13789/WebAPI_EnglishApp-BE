package com.example.WebAPI.service;

import com.example.WebAPI.model.Quiz;
import com.example.WebAPI.model.TotalQuestionsScore;
import com.example.WebAPI.repository.ITotalQuestionsScoreRespository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface TotalQuestionsScoreService {

    TotalQuestionsScore saveTotalScore(TotalQuestionsScore totalQuestionsScore);

    List<TotalQuestionsScore> getTotalQuestionsScoresByUserId(Long userId);

    List<TotalQuestionsScore> getTotalScoresByUserId(Long userId);

    List<TotalQuestionsScore> getalltotal();
}
