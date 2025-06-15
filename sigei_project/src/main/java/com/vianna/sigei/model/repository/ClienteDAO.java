package com.vianna.sigei.model.repository;

import com.vianna.sigei.model.Cliente;
import com.vianna.sigei.model.dto.ClienteListDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

    static String pkg = "com.vianna.sigei.model.dto.";

    @Query("select new "+pkg+"ClienteListDTO(c.id, 0 , c.nome, c.email) " +
            "from Cliente c ")
    List<ClienteListDTO> getClientes();

    @Query("select new "+pkg+"ClienteListDTO(c.id, 0 , c.nome, c.email) " +
            "from Cliente c " +
            "where c.nome like :nome ")
    List<ClienteListDTO> getClientes(String nome);

//    public List<Cliente> findByContaingNome(String nome);

    public Cliente findByLoginAndSenha(String login, String senha);

    public List<Cliente> findByLoginIgnoreCase(String login);


    Cliente findByLogin(String username);
}
