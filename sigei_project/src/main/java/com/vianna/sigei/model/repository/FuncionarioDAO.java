package com.vianna.sigei.model.repository;

import com.vianna.sigei.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioDAO extends JpaRepository<Funcionario, Integer> {

    public Funcionario findByNome(String nome);

    public Funcionario findByLoginAndSenha(String login, String senha);


    Funcionario findByLogin(String username);
}
