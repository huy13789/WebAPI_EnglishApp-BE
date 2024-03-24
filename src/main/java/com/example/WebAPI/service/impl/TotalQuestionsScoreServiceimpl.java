package com.example.WebAPI.service.impl;

import com.example.WebAPI.model.Category;
import com.example.WebAPI.model.TotalQuestionsScore;
import com.example.WebAPI.repository.ITotalQuestionsScoreRespository;
import com.example.WebAPI.service.TotalQuestionsScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TotalQuestionsScoreServiceimpl implements TotalQuestionsScoreService {
    @Autowired
    private ITotalQuestionsScoreRespository repository;
    @Override
    public TotalQuestionsScore saveTotalScore(TotalQuestionsScore totalQuestionsScore) {
        return repository.save(totalQuestionsScore);
    }

    @Override
    public List<TotalQuestionsScore> getTotalQuestionsScoresByUserId(Long userId) {
        return null;
    }

    @Override
    public List<TotalQuestionsScore> getTotalScoresByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<TotalQuestionsScore> getalltotal() {
        List<TotalQuestionsScore> allCategories = repository.findAll();
        return allCategories;
    }


}
