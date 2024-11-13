package com.example.loginauthapi.controller;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.loginauthapi.model.User;
import com.example.loginauthapi.model.Carrinho;
import com.example.loginauthapi.model.Pedido;
import com.example.loginauthapi.repository.UserRepository;
import com.example.loginauthapi.repository.CarrinhoRepository;
import com.example.loginauthapi.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuarios")
public class UserController {

   /*  private final UserRepository userRepository;
    private final CarrinhoRepository carrinhoRepository;
    private final PedidoRepository pedidoRepository; */

    @GetMapping
    public ResponseEntity<String> getUsuario() {
        return ResponseEntity.ok("sucesso!");
    }

    /* @GetMapping("/{userId}")
    public ResponseEntity<User> getUserWithCarrinhoAndPedido(@PathVariable UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Recuperar carrinhos e pedidos associados ao usuário
        var carrinhos = carrinhoRepository.findByUser(user);
        var pedidos = pedidoRepository.findByUser(user);

        // Criar um DTO para retornar as informações, incluindo o usuário, carrinho e
        // pedidos
        var response = new UserWithCarrinhoAndPedidoDTO(user, carrinhos, pedidos);

        return ResponseEntity.ok(response); // Retornar a resposta com as informações completas
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Deletar carrinho e pedido associados
        carrinhoRepository.deleteByUser(user);
        pedidoRepository.deleteByUser(user);

        // Deletar o usuário
        userRepository.delete(user);

        return ResponseEntity.noContent().build();} */
    
}
