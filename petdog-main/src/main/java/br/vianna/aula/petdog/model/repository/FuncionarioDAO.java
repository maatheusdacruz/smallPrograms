package br.vianna.aula.petdog.model.repository;

import br.vianna.aula.petdog.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioDAO extends JpaRepository<Funcionario, Integer> {

    public Funcionario findByNome(String nome);

    public Funcionario findByLoginAndSenha(String login, String senha);


    Funcionario findByLogin(String username);
}
