package com.example.WebAPI.controller;

import com.example.WebAPI.model.User;
import com.example.WebAPI.repository.IUserRepository;
import com.example.WebAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserService userService;

    @Autowired
    private IUserRepository userRepository;
    @GetMapping("")
    public String Category(Model model) {
        model.addAttribute("listuser", userService.getAllUsers());
        return "admin/account/index";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/account";
    }

    @GetMapping("/delete/{id}")
    public String Deleteuser(@PathVariable(value = "id") long id) {
        this.userService.deleteUserById(id);
        return "redirect:/account";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/account/edit";
    }
    @PostMapping("/saveuser")
    public String editUser(@ModelAttribute("user") User user) {
        userService.saveacount(user);
        return "redirect:/account";
    }
    @GetMapping("/add")
    public String AddUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/account/add";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                model.addAttribute(error.getField() + "_error", error.getDefaultMessage());
            }
            return "admin/account/add";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.save(user);
        return "redirect:/account";
    }

}
