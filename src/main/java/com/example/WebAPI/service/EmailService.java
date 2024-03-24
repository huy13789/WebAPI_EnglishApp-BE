package com.example.WebAPI.service;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
