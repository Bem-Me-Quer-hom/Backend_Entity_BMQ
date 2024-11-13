package com.example.loginauthapi.dto.pedidos;

import java.util.List;

public record PedidoRequestDTO(String endereco, float valorTotal, List<Long> produtoIds) {
}