package com.example.WebAPI.ControllerAdmin;

import com.example.WebAPI.model.Questions;
import com.example.WebAPI.service.AnswersService;
import com.example.WebAPI.service.QuestionsService;
import com.example.WebAPI.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/question")
public class Question1Controller {
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private AnswersService answersService;
    @Autowired
    private QuizService quizService;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("listquestion", questionsService.getQuestionReading());
        return "/admin/question/index";
    }
    @GetMapping("/addquestion")
    public String AddQuestion(Model model) {
        Questions questions= new Questions();
        model.addAttribute("question", questions);
        model.addAttribute("listanswer", answersService.getAllAnswers());
        model.addAttribute("listquiz", quizService.getQuizReading());
        return "admin/question/addquestion";
    }
    @PostMapping("/savequestion")
    public String saveQuestion(@ModelAttribute("question") Questions questions) {
        questionsService.save(questions);
        return "redirect:/question";
    }
    @GetMapping("/deletequestion/{id}")
    public String DeleteQuestion(@PathVariable(value = "id") long id) {
        this.questionsService.deleteQuestionById(id);
        return "redirect:/question";
    }
    @GetMapping("/editquestion/{id}")
    public String editQuestion(@PathVariable(value = "id") long id, Model model) {
        Questions questions= questionsService.getQuestionById(id);
        model.addAttribute("question", questions);
        model.addAttribute("listanswer", answersService.getAllAnswers());
        model.addAttribute("listquiz", quizService.getQuizReading());
        return "admin/question/editquestion";
    }
}
