package com.example.WebAPI.service;

import com.example.WebAPI.model.User;
import io.jsonwebtoken.Claims;

public interface JwtService {

    String generateToken(User user);

    Claims validateToken(String token);

}
