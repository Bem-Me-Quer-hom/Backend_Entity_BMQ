package com.example.loginauthapi.dto.carrinho;

import java.util.List;

import com.example.loginauthapi.dto.produto.ProdutoResponseDTO;

public record CarrinhoResponseDTO(Long id, String userName, List<ProdutoResponseDTO> produtos) {
}
