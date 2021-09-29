package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.dao.UsuarioDAO;
import com.sebas.tiendagenerica.model.UsuarioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO UsuarioDAO;

    @Override
    public Iterable<UsuarioModel> findAll() {
        return UsuarioDAO.findAll();
    }

    @Override
    public Optional<UsuarioModel> findById(Long id) {
        return UsuarioDAO.findById(id);
    }

    @Override
    public UsuarioModel save(UsuarioModel usuario) {
        return UsuarioDAO.save(usuario);
    }

    @Override
    public void delete(Long id){
        UsuarioDAO.deleteById(id);
    }
}
