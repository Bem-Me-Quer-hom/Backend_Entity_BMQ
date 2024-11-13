package com.example.loginauthapi.dto.produto;

import com.example.loginauthapi.model.Produto;

import java.util.UUID;

public record ProdutoResponseDTO(UUID id, String nome, float preco, String image, String descricao, String categoriaNome) {

    public ProdutoResponseDTO(Produto produto) {
        this(
            produto.getId(), 
            produto.getNome(), 
            produto.getPreco(), 
            produto.getImage(),
            produto.getDescricao(),
            produto.getCategoria() != null ? produto.getCategoria().getNome() : null
        );
    }
}

