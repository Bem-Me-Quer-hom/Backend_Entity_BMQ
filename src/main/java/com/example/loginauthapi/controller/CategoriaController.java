package com.example.loginauthapi.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginauthapi.model.Categoria;
import com.example.loginauthapi.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaServico;

    @GetMapping
    public List<Categoria> obterTodasCategorias() {
        return categoriaServico.obterTodasCategorias();
    }

    //categoria_id
    @GetMapping("/{categoriaId}")
    public ResponseEntity<Categoria> obterCategoriaPorId(@PathVariable UUID categoriaId) {
        return categoriaServico.obterCategoriaPorId(categoriaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaServico.salvarCategoria(categoria);
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable UUID categoriaId, @RequestBody Categoria detalhesCategoria) {
        return categoriaServico.atualizarCategoria(categoriaId, detalhesCategoria)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable UUID categoriaId) {
        if (categoriaServico.deletarCategoria(categoriaId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

