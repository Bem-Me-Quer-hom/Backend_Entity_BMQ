package com.example.loginauthapi.service;

import com.example.loginauthapi.model.Categoria;
import com.example.loginauthapi.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepositorio;

    public List<Categoria> obterTodasCategorias() {
        return categoriaRepositorio.findAll();
    }

    public Optional<Categoria> obterCategoriaPorId(UUID id) {
        return categoriaRepositorio.findById(id);
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    public Optional<Categoria> atualizarCategoria(UUID id, Categoria detalhesCategoria) {
        return categoriaRepositorio.findById(id).map(categoria -> {
            categoria.setNome(detalhesCategoria.getNome());
            return categoriaRepositorio.save(categoria);
        });
    }

    public boolean deletarCategoria(UUID id) {
        return categoriaRepositorio.findById(id).map(categoria -> {
            categoriaRepositorio.delete(categoria);
            return true;
        }).orElse(false);
    }
}
