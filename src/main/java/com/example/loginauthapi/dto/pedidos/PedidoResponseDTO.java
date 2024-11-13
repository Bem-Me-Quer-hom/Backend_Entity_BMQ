package com.example.loginauthapi.dto.pedidos;

import java.util.List;

import com.example.loginauthapi.dto.produto.ProdutoResponseDTO;

public record PedidoResponseDTO(Long id, String endereco, float valorTotal, List<ProdutoResponseDTO> produtos) {
}