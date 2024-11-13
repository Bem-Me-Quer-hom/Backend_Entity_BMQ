package com.example.loginauthapi.controller;

import com.example.loginauthapi.service.ProdutoService;
import com.example.loginauthapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoServico;

    @GetMapping
    public List<Produto> obterTodosProdutos() {
        return produtoServico.obterTodosProdutos();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> obterProdutoPorId(@PathVariable UUID produtoId) {
        return produtoServico.obterProdutoPorId(produtoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoServico.salvarProduto(produto);
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable UUID produtoId, @RequestBody Produto detalhesProduto) {
        return produtoServico.atualizarProduto(produtoId, detalhesProduto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deletarProduto(@PathVariable UUID produtoId) {
        if (produtoServico.deletarProduto(produtoId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
