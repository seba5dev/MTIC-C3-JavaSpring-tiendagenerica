package com.sebas.tiendagenerica.dao;

import com.sebas.tiendagenerica.model.ClienteModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends JpaRepository<ClienteModel, Long> {
    
}
