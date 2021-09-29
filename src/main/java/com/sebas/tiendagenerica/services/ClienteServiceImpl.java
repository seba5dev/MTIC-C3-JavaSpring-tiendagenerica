package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.dao.ClienteDAO;
import com.sebas.tiendagenerica.model.ClienteModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Iterable<ClienteModel> findAll() {
        return clienteDAO.findAll();
    }

    @Override
    public Optional<ClienteModel> findById(Long id) {
        return clienteDAO.findById(id);
    }

    @Override
    public ClienteModel save(ClienteModel cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteDAO.deleteById(id);
    }
    
}
