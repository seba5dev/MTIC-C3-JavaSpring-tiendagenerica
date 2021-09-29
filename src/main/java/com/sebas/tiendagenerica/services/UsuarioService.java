package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.model.UsuarioModel;

public interface UsuarioService {
    public Iterable<UsuarioModel> findAll();

    public Optional<UsuarioModel> findById(Long id);

    public UsuarioModel save(UsuarioModel usuario);

    public void delete(Long id);
}
