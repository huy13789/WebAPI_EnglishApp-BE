package com.example.WebAPI.repository;

import com.example.WebAPI.model.Answers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAnswersRespository extends JpaRepository<Answers,Long> {


}
