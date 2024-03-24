package com.example.WebAPI.service.impl;

import com.example.WebAPI.model.Questions;
import com.example.WebAPI.repository.IQuestionsRepository;
import com.example.WebAPI.service.QuestionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceimpl implements QuestionsService {
    @Autowired
    private IQuestionsRepository iQuestionsRepository;
    @Override
    public void save(Questions questions) {
        iQuestionsRepository.save(questions);
    }

    @Override
    public Questions saveQuestion(Questions questions) {
        iQuestionsRepository.save(questions);
        Long categoryId= iQuestionsRepository.getQuestionId(questions.getId());
        if(categoryId == 0)
            return questions;
        return questions;
    }

    @Override
    public void deleteQuestionById(long id) {
        this.iQuestionsRepository.deleteById(id);
    }

    @Override
    public List<Questions> getAllQuestion() {
        return iQuestionsRepository.findAll();
    }

    @Override
    public List<Questions> getQuestionReading() {
        return iQuestionsRepository.findReadingQuestions();
    }

    @Override
    public List<Questions> getQuestionListening() {
        return iQuestionsRepository.findReadingListening();
    }

    @Override
    public Questions getQuestionById(Long id) {
        Questions questions = iQuestionsRepository.findByQuestionId(id);
        if(questions!=null)
        {
            return questions;
        } else {
            throw new RuntimeException("Category not found for id " + id);
        }
    }

    @Override
    public Questions updateQuestion(Questions questions) {
        return null;
    }

    @Override
    public void deleteQuestion(Long id) {

    }
}
