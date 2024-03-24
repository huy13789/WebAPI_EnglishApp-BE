package com.example.WebAPI.controller;

import com.example.WebAPI.model.User;
import com.example.WebAPI.repository.IUserRepository;
import com.example.WebAPI.service.EmailService;
import com.example.WebAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.time.LocalDateTime;

//Author: Ngô Nguyễn Huy
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        User user = iUserRepository.findByUsername(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        //Lấy token
        String users = userService.login(user.getUsername(), user.getPassword());
        if (users != null) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.badRequest().body("Tên người dùng hoặc mật khẩu không đúng");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?>  register(@Valid @RequestBody User user){
        if(iUserRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().body("Đã có user tên đó");
        }
        User newuser = userService.saveUser(user);
        if (newuser != null) {
            return ResponseEntity.ok("Tạo user thành công");
        } else {
            return ResponseEntity.badRequest().body("Lỗi");
        }
    }
    @GetMapping("/send_email_test")
    public String sendEmail() {
        String to = "levi34202@gmail.com";
        String subject = "Test cho vui";
        String body = "Happy new years";

        emailService.sendEmail(to, subject, body);
        return "Email sent successfully!";
    }

    @GetMapping("/send_email")
    public ResponseEntity<String> sendResetPasswordEmail(@RequestParam String username,@RequestParam String email) {
        User user = iUserRepository.findByEmail(email);
        User user2 = iUserRepository.findByUsername(username);
        if (user == null || user2== null) {
            return ResponseEntity.badRequest().body("Không có người dùng đó");
        }

        String resetCode = generateRandomCode(5);
        user.setResetCode(resetCode);

        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(1);
        user.setResetCodeExpiryTime(expiryTime);

        iUserRepository.save(user);

        emailService.sendEmail(user.getEmail(), "Khôi phục mật khẩu",resetCode);

        return ResponseEntity.ok("Đã gửi mail");
    }

    private String generateRandomCode(int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder numericCode = new StringBuilder();

        for (int i = 0; i < length; i++) {
            numericCode.append(secureRandom.nextInt(9));
        }

        return numericCode.toString();
    }

    @PutMapping("/reset_password")
    public String resetPassword(@RequestParam String email, @RequestParam String resetCode, @RequestParam String newPassword) {
        User user = iUserRepository.findByEmail(email);
        if (user == null ||
                !user.getResetCode().equals(resetCode) ||
                LocalDateTime.now().isAfter(user.getResetCodeExpiryTime()))
        {
            return "Invalid or expired reset code";
        }

        user.setPassword(new
                BCryptPasswordEncoder().encode(newPassword));
        user.setResetCode(null);
        user.setResetCodeExpiryTime(null);
        iUserRepository.save(user);

        return "Password reset successfully!";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @Valid @RequestBody User updatedUser) {
        User user = iUserRepository.findByUsername(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setFullName(updatedUser.getFullName());
        user.setPhoneNumber(updatedUser.getPhoneNumber());
        user.setAddress(updatedUser.getAddress());

        User savedUser = iUserRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

}
