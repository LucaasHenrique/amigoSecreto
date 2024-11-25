package com.br.natal.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="tb_participante")
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;

    @ManyToOne
    @JoinColumn(name="grupo_id")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "amigo_secreto_id")
    private Participante amigoSecreto;

    public Participante getAmigoSecreto() {
        return amigoSecreto;
    }

    public void setAmigoSecreto(Participante amigoSecreto) {
        this.amigoSecreto = amigoSecreto;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }
}
