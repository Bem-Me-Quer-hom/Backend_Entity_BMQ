package com.example.loginauthapi.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; // Remova o ponto e vírgula duplicado

import com.example.loginauthapi.dto.auth.LoginRequestDTO;
import com.example.loginauthapi.dto.auth.RegisterRequestDTO;
import com.example.loginauthapi.dto.auth.ResponseDTO;
import com.example.loginauthapi.infra.security.TokenService;
import com.example.loginauthapi.model.Carrinho;
import com.example.loginauthapi.model.Pedido;
import com.example.loginauthapi.model.User;
import com.example.loginauthapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import com.example.loginauthapi.repository.CarrinhoRepository;
import com.example.loginauthapi.repository.PedidoRepository;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final CarrinhoRepository carrinhoRepository;
    private final PedidoRepository pedidoRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body) {
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body) {
        Optional<User> user = this.repository.findByEmail(body.email());

        if (user.isEmpty()) {
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());   
            this.repository.save(newUser);

            /* // Criar e associar o carrinho ao usuário
            Carrinho carrinho = new Carrinho();
            carrinho.setUser(newUser); // Associando o carrinho ao usuário
            this.carrinhoRepository.save(carrinho);

            // Criar e associar o pedido ao usuário
            Pedido pedido = new Pedido();
            pedido.setUser(newUser); // Associando o pedido ao usuário
            this.pedidoRepository.save(pedido); */

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
