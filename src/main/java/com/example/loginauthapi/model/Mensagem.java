package com.example.loginauthapi.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String texto;

    /* @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user; */

    public Mensagem(UUID id, String texto/* , User usuario */) {
        this.id = id;
        this.texto = texto;
        /* this.user = usuario; */
    }

    public Mensagem() {
        // Construtor padrão
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

   /*  public User getUsuario() {
        return user;
    } */

 /*    public void setUsuario(User usuario) {
        this.user = usuario;
    }
 */
}
