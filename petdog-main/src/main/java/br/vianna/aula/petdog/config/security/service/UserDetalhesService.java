package br.vianna.aula.petdog.config.security.service;


import br.vianna.aula.petdog.config.security.model.UserLogado;
import br.vianna.aula.petdog.model.Cliente;
import br.vianna.aula.petdog.model.Funcionario;
import br.vianna.aula.petdog.model.Usuario;
import br.vianna.aula.petdog.model.repository.ClienteDAO;
import br.vianna.aula.petdog.model.repository.FuncionarioDAO;
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
