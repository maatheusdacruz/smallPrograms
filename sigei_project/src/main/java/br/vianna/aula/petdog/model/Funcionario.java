package br.vianna.aula.petdog.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Funcionario extends Usuario {

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Atendimento> atendimentos = new ArrayList<>();



    public Funcionario() {
    }

    public Funcionario(int id, String nome, String email, String login, String senha, ArrayList<Atendimento> atendimentos) {
        super(id, nome, email, login, senha);
        this.atendimentos = atendimentos;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
