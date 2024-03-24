package com.example.WebAPI.service;

import com.example.WebAPI.model.QuestionsScore;
import com.example.WebAPI.model.TotalQuestionsScore;

import java.util.List;

public interface QuestionsScoreService {
    void saveDetailScore(List<QuestionsScore> questionsScores);
}
