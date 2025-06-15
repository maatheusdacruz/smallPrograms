package com.vianna.sigei.service;

import com.vianna.sigei.model.Cliente;
import com.vianna.sigei.model.dto.ClienteListDTO;
import com.vianna.sigei.model.repository.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteDAO cDao;


    public List<ClienteListDTO> getClientes(String pesquisa) {

        if (pesquisa == null) {
            return cDao.getClientes();
        }else{
            return cDao.getClientes("%"+pesquisa+"%");
        }
    }

    public void save(Cliente cliente) {
        //validação

        cDao.save(cliente);
    }

    public Cliente getCliente(int id) {

        return cDao.findById(id).get();
    }
}
