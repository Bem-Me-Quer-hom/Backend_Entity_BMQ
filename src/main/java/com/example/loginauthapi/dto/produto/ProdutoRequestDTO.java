package com.example.loginauthapi.dto.produto;

public record ProdutoRequestDTO(String nome, float preco,String image, String descricao, Long categoriaId) {
}
