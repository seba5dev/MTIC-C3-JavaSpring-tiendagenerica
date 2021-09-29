package com.sebas.tiendagenerica.dao;

import com.sebas.tiendagenerica.model.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<UsuarioModel, Long> {
    
}
