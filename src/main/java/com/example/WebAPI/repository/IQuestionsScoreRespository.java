package com.example.WebAPI.repository;

import com.example.WebAPI.model.QuestionsScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionsScoreRespository extends JpaRepository<QuestionsScore,Long> {
}
