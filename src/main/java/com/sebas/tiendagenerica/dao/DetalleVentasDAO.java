package com.sebas.tiendagenerica.dao;

import com.sebas.tiendagenerica.model.DetalleVentasModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentasDAO extends JpaRepository<DetalleVentasModel, Long> {
    
}
