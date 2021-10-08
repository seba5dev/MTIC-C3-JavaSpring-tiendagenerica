package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.model.ProductoModel;

public interface ProductoService {
    public Iterable<ProductoModel> findAll();
    public Optional<ProductoModel> findById(Long id);
    public ProductoModel save(ProductoModel producto);
    public void delete(Long id);
}
