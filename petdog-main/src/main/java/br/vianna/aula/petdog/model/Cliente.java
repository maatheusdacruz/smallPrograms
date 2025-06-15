package br.vianna.aula.petdog.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Usuario {

    private String telefone;

    @OneToMany(mappedBy = "dono", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cachorro> cachorros = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(int id, String nome, String email, String login, String senha, String telefone, List<Cachorro> cachorros) {
        super(id, nome, email, login, senha);
        this.telefone = telefone;
        this.cachorros = cachorros;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Cachorro> getCachorros() {
        return cachorros;
    }

    public void setCachorros(List<Cachorro> cachorros) {
        this.cachorros = cachorros;
    }
}
