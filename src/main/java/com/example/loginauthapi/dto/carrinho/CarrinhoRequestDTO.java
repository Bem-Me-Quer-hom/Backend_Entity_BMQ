package com.example.loginauthapi.dto.carrinho;

import java.util.List;

public record CarrinhoRequestDTO(Long userId, List<Long> produtoIds) {
}