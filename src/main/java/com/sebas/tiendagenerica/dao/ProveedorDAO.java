package com.sebas.tiendagenerica.dao;

import com.sebas.tiendagenerica.model.ProveedorModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorDAO extends JpaRepository<ProveedorModel, Long> {
    
}
