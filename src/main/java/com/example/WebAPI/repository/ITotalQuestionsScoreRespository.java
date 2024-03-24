package com.example.WebAPI.repository;

import com.example.WebAPI.model.Questions;
import com.example.WebAPI.model.Quiz;
import com.example.WebAPI.model.TotalQuestionsScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITotalQuestionsScoreRespository extends JpaRepository<TotalQuestionsScore,Long> {
//    @Query("SELECT t FROM TotalQuestionsScore t WHERE t.user.id = :userId")
//    List<TotalQuestionsScore> findByUserId(@Param("userId") Long userId);
@Query("SELECT t FROM TotalQuestionsScore t WHERE t.user.id = :userId")
List<TotalQuestionsScore> findByUserId(@Param("userId") Long userId);


}
