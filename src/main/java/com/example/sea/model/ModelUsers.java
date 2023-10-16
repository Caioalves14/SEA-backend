package com.example.sea.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "Users")
public class ModelUsers implements Serializable {
    private static final long serialVersion = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idUsers;
    private String nome;
    private String email;
    private String senha;

	public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
