package com.example.loginauthapi.service;

import com.example.loginauthapi.model.Carrinho;
import com.example.loginauthapi.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepositorio;

    public List<Carrinho> obterTodosCarrinhos() {
        return carrinhoRepositorio.findAll();
    }

    public Optional<Carrinho> obterCarrinhoPorId(UUID id) {
        return carrinhoRepositorio.findById(id);
    }

    public Carrinho salvarCarrinho(Carrinho carrinho) {
        return carrinhoRepositorio.save(carrinho);
    }

    public Optional<Carrinho> atualizarCarrinho(UUID id, Carrinho detalhesCarrinho) {
        return carrinhoRepositorio.findById(id).map(carrinho -> {
            /* carrinho.setUser(detalhesCarrinho.getUser()); */
            carrinho.setProdutos(detalhesCarrinho.getProdutos());
            return carrinhoRepositorio.save(carrinho);
        });
    }

    public boolean deletarCarrinho(UUID id) {
        return carrinhoRepositorio.findById(id).map(carrinho -> {
            carrinhoRepositorio.delete(carrinho);
            return true;
        }).orElse(false);
    }
}

