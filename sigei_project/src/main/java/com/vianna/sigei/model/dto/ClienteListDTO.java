package com.vianna.sigei.model.dto;

public class ClienteListDTO {

    private int id, numeroAnimais;
    private String nome, email;

    public ClienteListDTO(int id, int numeroAnimais, String nome, String email) {
        this.id = id;
        this.numeroAnimais = numeroAnimais;
        this.nome = nome;
        this.email = email;
    }

    public ClienteListDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroAnimais() {
        return numeroAnimais;
    }

    public void setNumeroAnimais(int numeroAnimais) {
        this.numeroAnimais = numeroAnimais;
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
}
