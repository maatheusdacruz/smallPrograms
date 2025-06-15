package br.vianna.aula.petdog.config.security.model;

import br.vianna.aula.petdog.model.Funcionario;
import br.vianna.aula.petdog.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserLogado implements UserDetails {

    private String login, senha, nome;
    private int id;
    private ArrayList<GrantedAuthority> autorizacoes;

    public UserLogado(Usuario u){
        login = u.getLogin();
        senha = u.getSenha();
        nome = u.getNome();
        id = u.getId();
        autorizacoes = new ArrayList<>();
        if (u instanceof Funcionario){
            autorizacoes.add( new SimpleGrantedAuthority("ROLE_FUNCIONARIO"));
            if (u.getLogin().equals("admin")){
                autorizacoes.add( new SimpleGrantedAuthority("ROLE_ADMIN"));
                autorizacoes.add( new SimpleGrantedAuthority("CAN_FILTER"));
            }
        }else{
            autorizacoes.add( new SimpleGrantedAuthority("ROLE_CLIENTE"));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizacoes;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
