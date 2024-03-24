package com.example.WebAPI.service;

import com.example.WebAPI.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> CATEGORY_LIST_READING();
    List<Category> CATEGORY_LIST_LISTEN();
    void save(Category category);
    Category saveCategory(Category category);
    void deleteCategoryById(long id);
    List<Category> getAllCategory();

    Category getCategoryById(Long id);

    Category updateCategory(Category category);

    void deleteCategory(Long id);
}
