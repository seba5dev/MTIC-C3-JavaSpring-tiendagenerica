package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.model.ProveedorModel;

public interface ProveedorService {
    public Iterable<ProveedorModel> findAll();
    public Optional<ProveedorModel> findById(Long id);
    public ProveedorModel save(ProveedorModel proveedores);
    public void delete(Long id);
}
