package com.vianna.sigei.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cachorro {

    @Id
    private int id;
    private String nome;
    private int idadeEmMeses;
    private String raca;
    private double peso;
   
   @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente dono;

    @OneToMany(mappedBy = "cao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atendimento> atendimentos = new ArrayList<>();

    public Cachorro() {
    }

    public Cachorro(int id, String nome, int idadeEmMeses, String raca, double peso, Cliente dono) {
        this.id = id;
        this.nome = nome;
        this.idadeEmMeses = idadeEmMeses;
        this.raca = raca;
        this.peso = peso;
        this.dono = dono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdadeEmMeses() {
        return idadeEmMeses;
    }

    public void setIdadeEmMeses(int idadeEmMeses) {
        this.idadeEmMeses = idadeEmMeses;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
