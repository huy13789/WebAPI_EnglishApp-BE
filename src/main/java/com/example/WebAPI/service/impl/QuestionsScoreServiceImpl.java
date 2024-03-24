package com.example.WebAPI.service.impl;

import com.example.WebAPI.model.QuestionsScore;
import com.example.WebAPI.repository.IQuestionsScoreRespository;
import com.example.WebAPI.service.QuestionsScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsScoreServiceImpl implements QuestionsScoreService {
    @Autowired
    IQuestionsScoreRespository iQuestionsScoreRespository;


    @Override
    public void saveDetailScore(List<QuestionsScore> questionsScores) {
        for (QuestionsScore score : questionsScores) {
            iQuestionsScoreRespository.save(score);
        }
    }
}
