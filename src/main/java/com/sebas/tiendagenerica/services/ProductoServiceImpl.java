package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.dao.ProductoDAO;
import com.sebas.tiendagenerica.model.ProductoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoDAO productoDAO;

    @Override
    public Iterable<ProductoModel> findAll() {
        return productoDAO.findAll();
    }

    @Override
    public Optional<ProductoModel> findById(Long id) {
        return productoDAO.findById(id);
    }

    @Override
    public ProductoModel save(ProductoModel producto) {
        return productoDAO.save(producto);
    }

    @Override
    public void delete(Long id) {
        productoDAO.deleteById(id);
    }
}
