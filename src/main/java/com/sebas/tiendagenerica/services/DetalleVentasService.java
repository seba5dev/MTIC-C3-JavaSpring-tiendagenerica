package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.model.DetalleVentasModel;

public interface DetalleVentasService {
    public Iterable<DetalleVentasModel> findAll();
    public Optional<DetalleVentasModel> findById(Long id);
    public DetalleVentasModel save(DetalleVentasModel detalleVentas);
    public void delete(Long id);
}
