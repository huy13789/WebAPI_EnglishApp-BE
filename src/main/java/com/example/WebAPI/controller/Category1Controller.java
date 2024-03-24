package com.example.WebAPI.controller;

import com.example.WebAPI.model.Category;
import com.example.WebAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/category")
public class Category1Controller {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listcategory", categoryService.getAllCategory());
        return "/admin/category/index";
    }
    @GetMapping("/addcategory")
    public String AddCategory(Model model) {
        Category category= new Category();
        model.addAttribute("category", category);
        List<Boolean> isReading = Arrays.asList(true, false);
        model.addAttribute("isReading", isReading);
        return "admin/category/addcategory";
    }
    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/deletecategory/{id}")
    public String DeleteCategory(@PathVariable(value = "id") long id) {
        this.categoryService.deleteCategoryById(id);
        return "redirect:/category";
    }
    @GetMapping("/editcategory/{id}")
    public String editCategory(@PathVariable(value = "id") long id, Model model) {
        Category category= categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "admin/category/editcategory";
    }

}
