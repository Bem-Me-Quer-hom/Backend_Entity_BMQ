package com.example.loginauthapi.controller;

import com.example.loginauthapi.model.Carrinho;
import com.example.loginauthapi.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
    @Autowired
    private CarrinhoService carrinhoServico;

    @GetMapping
    public List<Carrinho> obterTodosCarrinhos() {
        return carrinhoServico.obterTodosCarrinhos();
    }

    //carrinho_id
    @GetMapping("/{carrinhoId}")
    public ResponseEntity<Carrinho> obterCarrinhoPorId(@PathVariable UUID carrinhoId) {
        return carrinhoServico.obterCarrinhoPorId(carrinhoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carrinho criarCarrinho(@RequestBody Carrinho carrinho) {
        return carrinhoServico.salvarCarrinho(carrinho);
    }

    @PutMapping("/{carrinhoId}")
    public ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable UUID carrinhoId, @RequestBody Carrinho detalhesCarrinho) {
        return carrinhoServico.atualizarCarrinho(carrinhoId, detalhesCarrinho)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{carrinhoId}")
    public ResponseEntity<Void> deletarCarrinho(@PathVariable UUID carrinhoId) {
        if (carrinhoServico.deletarCarrinho(carrinhoId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
