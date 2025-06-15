package com.vianna.sigei.config.security.service;


import com.vianna.sigei.config.security.model.UserLogado;
import com.vianna.sigei.model.Usuario;
import com.vianna.sigei.model.repository.ClienteDAO;
import com.vianna.sigei.model.repository.FuncionarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetalhesService implements UserDetailsService {

    @Autowired
    FuncionarioDAO fDao;
    @Autowired
    ClienteDAO cDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = fDao.findByLogin(username);
        if (user == null){
            user = cDao.findByLogin(username);
            if (user == null){
                throw new UsernameNotFoundException("Usuário incorreto");
            }
        }

        return new UserLogado(user);
    }
}
