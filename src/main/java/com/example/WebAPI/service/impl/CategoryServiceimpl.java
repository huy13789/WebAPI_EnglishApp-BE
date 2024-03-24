package com.example.WebAPI.service.impl;

import com.example.WebAPI.model.Category;
import com.example.WebAPI.repository.ICategoryRespository;
import com.example.WebAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    private ICategoryRespository iCategoryRespository;
    @Override
    public List<Category> CATEGORY_LIST_LISTEN() {
        List<Category> allCategories = iCategoryRespository.findAll();
        // Sử dụng Java Stream để lọc dữ liệu thỏa mãn điều kiện IsReading == true
        List<Category> readingCategories = allCategories.stream()
                .filter(category -> !category.isReading()) // Sử dụng getter của IsReading
                .collect(Collectors.toList());

        return readingCategories;
    }

    @Override
    public List<Category> CATEGORY_LIST_READING() {
        List<Category> allCategories = iCategoryRespository.findAll();
        // Sử dụng Java Stream để lọc dữ liệu thỏa mãn điều kiện IsReading == true
        List<Category> readingCategories = allCategories.stream()
                .filter(category -> category.isReading()) // Sử dụng getter của IsReading
                .collect(Collectors.toList());

        return readingCategories;
    }
    @Override
    public void save(Category category) {
        iCategoryRespository.save(category);
    }

    @Override
    public Category saveCategory(Category category) {
        iCategoryRespository.save(category);
        Long categoryId= iCategoryRespository.getCategoryId(category.getId());
        if(categoryId == 0)
            return category;
        return category;
    }
    @Override
    public void deleteCategoryById(long id) {
        this.iCategoryRespository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return iCategoryRespository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = iCategoryRespository.findByCategoryId(id);
        if(category!=null)
        {
            return category;
        } else {
            throw new RuntimeException("Category not found for id " + id);
        }
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
