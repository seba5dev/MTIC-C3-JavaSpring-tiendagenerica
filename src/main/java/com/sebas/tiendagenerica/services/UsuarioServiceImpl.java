package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.dao.UsuarioDAO;
import com.sebas.tiendagenerica.model.UsuarioModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDAO usuariodao;

    @Override
    public Iterable<UsuarioModel> findAll() {
        return usuariodao.findAll();
    }

    @Override
    public Optional<UsuarioModel> findById(Long id) {
        return usuariodao.findById(id);
    }

    @Override
    public UsuarioModel save(UsuarioModel usuario) {
        return usuariodao.save(usuario);
    }

    @Override
    public void delete(Long id){
        usuariodao.deleteById(id);
    }
}
