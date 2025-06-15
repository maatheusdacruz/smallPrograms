package br.vianna.aula.petdog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Atendimento {

    @Id
    private int id;
    private LocalDateTime dataAtendimento;

    @ManyToOne
    @JoinColumn(name = "cachorro_id")
    private Cachorro cao;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private String descricao;
    private String tratamento;

    public Atendimento() {
    }

    public Atendimento(int id, LocalDateTime dataAtendimento, Cachorro cao, Funcionario funcionario, String descricao, String tratamento) {
        this.id = id;
        this.dataAtendimento = dataAtendimento;
        this.cao = cao;
        this.funcionario = funcionario;
        this.descricao = descricao;
        this.tratamento = tratamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Cachorro getCao() {
        return cao;
    }

    public void setCao(Cachorro cao) {
        this.cao = cao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }
}
