package com.example.loginauthapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginauthapi.model.Mensagem;
import com.example.loginauthapi.repository.MensagemRepository;
import java.util.UUID;

@Service
public class MensagemService  {
    @Autowired
    private MensagemRepository mensagemRepositorio;

    public List<Mensagem> obterTodasMensagens() {
        return mensagemRepositorio.findAll();
    }

    public Optional<Mensagem> obterMensagemPorId(UUID id) {
        return mensagemRepositorio.findById(id);
    }

    public Mensagem salvarMensagem(Mensagem mensagem) {
        return mensagemRepositorio.save(mensagem);
    }

    public Optional<Mensagem> atualizarMensagem(UUID id, Mensagem detalhesMensagem) {
        return mensagemRepositorio.findById(id).map(mensagem -> {
            mensagem.setTexto(detalhesMensagem.getTexto());
            /* mensagem.setUsuario(detalhesMensagem.getUsuario()); */
            return mensagemRepositorio.save(mensagem);
        });
    }

    public boolean deletarMensagem(UUID id) {
        return mensagemRepositorio.findById(id).map(mensagem -> {
            mensagemRepositorio.delete(mensagem);
            return true;
        }).orElse(false);
    }
}
