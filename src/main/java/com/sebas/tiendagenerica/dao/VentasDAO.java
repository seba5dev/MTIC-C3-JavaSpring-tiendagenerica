package com.sebas.tiendagenerica.dao;

import com.sebas.tiendagenerica.model.VentasModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasDAO extends JpaRepository<VentasModel, Long> {
    
}
