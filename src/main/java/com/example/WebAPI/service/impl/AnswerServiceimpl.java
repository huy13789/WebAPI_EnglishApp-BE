package com.example.WebAPI.service.impl;

import com.example.WebAPI.model.Answers;
import com.example.WebAPI.repository.IAnswersRespository;
import com.example.WebAPI.service.AnswersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceimpl implements AnswersService {
    @Autowired
    private IAnswersRespository iAnswersRespository;
    @Override
    public List<Answers> getAllAnswers() {
        return iAnswersRespository.findAll();
    }

}
