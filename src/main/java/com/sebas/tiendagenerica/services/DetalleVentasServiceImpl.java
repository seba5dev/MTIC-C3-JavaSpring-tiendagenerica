package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.dao.DetalleVentasDAO;
import com.sebas.tiendagenerica.model.DetalleVentasModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentasServiceImpl implements DetalleVentasService {
    @Autowired
    private DetalleVentasDAO detalleVentasDAO;

    @Override
    public Iterable<DetalleVentasModel> findAll() {
        return detalleVentasDAO.findAll();
    }

    @Override
    public Optional<DetalleVentasModel> findById(Long id) {
        return detalleVentasDAO.findById(id);
    }

    @Override
    public DetalleVentasModel save(DetalleVentasModel detalleVentas) {
        return detalleVentasDAO.save(detalleVentas);
    }

    @Override
    public void delete(Long id) {
        detalleVentasDAO.deleteById(id);
    }
    
}
