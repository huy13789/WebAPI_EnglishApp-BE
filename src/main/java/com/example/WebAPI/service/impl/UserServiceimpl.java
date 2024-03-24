package com.example.WebAPI.service.impl;

import com.example.WebAPI.model.User;
import com.example.WebAPI.repository.IRoleRepository;
import com.example.WebAPI.repository.IUserRepository;
import com.example.WebAPI.service.JwtService;
import com.example.WebAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private JwtService jwtService;

    @Override
    public void save(User user) {
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("User");
        if(roleId != 0 && userId != 0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }
    @Override
    public void saveacount(User user) {
        userRepository.save(user);
    }
    @Override
    public User saveUser(User user) {
        user.setPassword(new
                BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("User");
        if(roleId != 0 && userId != 0) {
            userRepository.addRoleToUser(userId, roleId);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent())
        {
            return optional.get();
        } else {
            throw new RuntimeException("User not found for id " + id);
        }
    }

    @Override
    public String login(String username, String password) {
        // Kiểm tra username và password
        User user = userRepository.findByUsername(username);
        //String hashpw =  new BCryptPasswordEncoder().encode(password);
        if(user == null || !new BCryptPasswordEncoder().matches(password, user.getPassword())) {
            return null;
        }
        // Tạo JWT
        String token = jwtService.generateToken(user);

        return token;
    }
}
