package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.model.VentasModel;

public interface VentasService {
    public Iterable<VentasModel> findAll();
    public Optional<VentasModel> findById(Long id);
    public VentasModel save(VentasModel cliente);
    public void delete(Long id);
}
