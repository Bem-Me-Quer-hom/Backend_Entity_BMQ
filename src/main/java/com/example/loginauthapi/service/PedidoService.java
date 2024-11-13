package com.example.loginauthapi.service;

import com.example.loginauthapi.repository.PedidoRepository;
import com.example.loginauthapi.model.Pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepositorio;

    public List<Pedido> obterTodosPedidos() {
        return pedidoRepositorio.findAll();
    }

    public Optional<Pedido> obterPedidoPorId(UUID id) {
        return pedidoRepositorio.findById(id);
    }

    public Pedido salvarPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    public Optional<Pedido> atualizarPedido(UUID id, Pedido detalhesPedido) {
        return pedidoRepositorio.findById(id).map(pedido -> {
            pedido.setEndereco(detalhesPedido.getEndereco());
            pedido.setValorTotal(detalhesPedido.getValorTotal());
            /* pedido.setUsuario(detalhesPedido.getUsuario()); */
            pedido.setProdutos(detalhesPedido.getProdutos());
            return pedidoRepositorio.save(pedido);
        });
    }

    public boolean deletarPedido(UUID id) {
        return pedidoRepositorio.findById(id).map(pedido -> {
            pedidoRepositorio.delete(pedido);
            return true;
        }).orElse(false);
    }
}
