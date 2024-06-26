package com.example.WebAPI.controller;

import com.example.WebAPI.model.Questions;
import com.example.WebAPI.service.AnswersService;
import com.example.WebAPI.service.QuestionsService;
import com.example.WebAPI.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/questionListen")
public class Question2Controller {
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private AnswersService answersService;
    @Autowired
    private QuizService quizService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listquestion", questionsService.getQuestionListening());
        return "/admin/question/indexlistening";
    }
    @GetMapping("/addquestion")
    public String AddQuestion(Model model) {
        Questions questions= new Questions();
        model.addAttribute("question", questions);
        model.addAttribute("listanswer", answersService.getAllAnswers());
        model.addAttribute("listquiz", quizService.getQuizListening());
        return "admin/question/addquestionlistening";
    }
    @PostMapping("/savequestion")
    public String saveQuestion(@ModelAttribute("question") Questions questions) {
        questionsService.save(questions);
        return "redirect:/questionListen";
    }
    @GetMapping("/deletequestion/{id}")
    public String DeleteQuestion(@PathVariable(value = "id") long id) {
        this.questionsService.deleteQuestionById(id);
        return "redirect:/questionListen";
    }
    @GetMapping("/editquestion/{id}")
    public String editQuestion(@PathVariable(value = "id") long id, Model model) {
        Questions questions= questionsService.getQuestionById(id);
        model.addAttribute("question", questions);
        model.addAttribute("listanswer", answersService.getAllAnswers());
        model.addAttribute("listquiz", quizService.getQuizListening());
        return "admin/question/editquestionlistening";
    }
}
