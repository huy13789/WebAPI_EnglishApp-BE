package com.example.WebAPI.repository;

import com.example.WebAPI.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRespository extends JpaRepository<Category,Long> {
    @Query("SELECT c.id FROM Category c WHERE c.id = ?1")
    Long getCategoryId(long id);
    @Query("SELECT c FROM Category c WHERE id = ?1")
    Category findByCategoryId(Long id);

}

