package com.example.loginauthapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.loginauthapi.repository.UserRepository;

import jakarta.annotation.PostConstruct;

import com.example.loginauthapi.model.User;
import com.example.loginauthapi.infra.security.SecurityConfig;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.loginauthapi.model.User;
import com.example.loginauthapi.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class InitialAdminSetup {

    @Autowired
    private UserRepository userRepository;

   /*  @Autowired
    private BCryptPasswordEncoder passwordEncoder; */

    @PostConstruct
    public void init() {
        // A lógica de inicialização vai aqui
    }

    @Bean
    public ApplicationRunner initializeAdmin() {
        return args -> {
            if (userRepository.findByRole(User.Role.ADMIN).isEmpty()) {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(/* passwordEncoder.encode( */"senhaSegura123!");
                admin.setRole(User.Role.ADMIN);
                userRepository.save(admin);
                System.out.println("Administrador padrão criado: admin@example.com / senhaSegura123!");
            }
        };
    }
}
