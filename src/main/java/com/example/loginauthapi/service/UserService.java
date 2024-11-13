package com.example.loginauthapi.service;

import com.example.loginauthapi.model.User; // Altere para o seu modelo de usuário
import com.example.loginauthapi.repository.UserRepository; // Altere para o seu repositório de usuário
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}