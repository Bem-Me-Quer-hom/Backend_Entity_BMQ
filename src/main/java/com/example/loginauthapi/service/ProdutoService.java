package com.example.loginauthapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginauthapi.model.Produto;
import com.example.loginauthapi.repository.ProdutoRepository;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepositorio;

    public List<Produto> obterTodosProdutos() {
        return produtoRepositorio.findAll();
    }

    public Optional<Produto> obterProdutoPorId(UUID id) {
        return produtoRepositorio.findById(id);
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepositorio.save(produto);
    }

    public Optional<Produto> atualizarProduto(UUID id, Produto detalhesProduto) {
        return produtoRepositorio.findById(id).map(produto -> {
            produto.setNome(detalhesProduto.getNome());
            produto.setPreco(detalhesProduto.getPreco());
            produto.setDescricao(detalhesProduto.getDescricao());
            produto.setCategoria(detalhesProduto.getCategoria());
            return produtoRepositorio.save(produto);
        });
    }

    public boolean deletarProduto(UUID id) {
        return produtoRepositorio.findById(id).map(produto -> {
            produtoRepositorio.delete(produto);
            return true;
        }).orElse(false);
    }
}
