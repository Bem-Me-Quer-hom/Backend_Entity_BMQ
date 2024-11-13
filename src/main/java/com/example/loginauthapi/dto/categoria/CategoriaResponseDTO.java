package com.example.loginauthapi.dto.categoria;

import java.util.List;

public record CategoriaResponseDTO(Long id, String nome, List<String> produtos) {
    public CategoriaResponseDTO(Long id, String nome) {
        this(id, nome, null);
    }
}

