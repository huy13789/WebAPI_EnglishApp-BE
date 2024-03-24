package com.example.WebAPI.service;

import com.example.WebAPI.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void saveacount(User user);
    User saveUser(User user);
    void deleteUserById(long id);
    List<User> getAllUsers();
    User getUserById(Long id);
    String login(String username, String password);
}
