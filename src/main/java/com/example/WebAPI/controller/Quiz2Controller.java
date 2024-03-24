package com.example.WebAPI.controller;

import com.example.WebAPI.model.Quiz;
import com.example.WebAPI.service.CategoryService;
import com.example.WebAPI.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/quizListen")
public class Quiz2Controller {
    @Autowired
    private QuizService quizService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listquiz", quizService.getQuizListening());
        return "/admin/quiz/indexListen";
    }
    @GetMapping("/addquiz")
    public String AddQuiz(Model model) {
        model.addAttribute("quiz",new Quiz());
        model.addAttribute("listcategory", categoryService.CATEGORY_LIST_LISTEN());
        return "admin/quiz/addquizListen";
    }
    @PostMapping("/savequiz")
    public String saveCategory(@ModelAttribute("quiz") Quiz quiz) {
        quizService.save(quiz);
        return "redirect:/quizListen";
    }
    @GetMapping("/deletequiz/{id}")
    public String DeleteCategory(@PathVariable(value = "id") long id) {
        this.quizService.deleteQuizById(id);
        return "redirect:/quizListen";
    }
    @GetMapping("/editquiz/{id}")
    public String editCategory(@PathVariable(value = "id") long id, Model model) {
        Quiz quiz= quizService.getQuizById(id);
        model.addAttribute("quiz", quiz);
        model.addAttribute("listcategory", categoryService.CATEGORY_LIST_LISTEN());
        return "admin/quiz/editquizListen";
    }
}
