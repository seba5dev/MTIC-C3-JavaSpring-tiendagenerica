package com.sebas.tiendagenerica.dao;

import com.sebas.tiendagenerica.model.ProductoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDAO extends JpaRepository<ProductoModel, Long> {
    
}
