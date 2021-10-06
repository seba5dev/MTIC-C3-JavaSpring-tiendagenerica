package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.dao.VentasDAO;
import com.sebas.tiendagenerica.model.VentasModel;

import org.springframework.beans.factory.annotation.Autowired;

public class VentasServiceImpl implements VentasService {
    @Autowired
    private VentasDAO ventasDAO;

    @Override
    public Iterable<VentasModel> findAll() {
        return ventasDAO.findAll();
    }

    @Override
    public Optional<VentasModel> findById(Long id) {
        return ventasDAO.findById(id);
    }

    @Override
    public VentasModel save(VentasModel venta) {
        return ventasDAO.save(venta);
    }

    @Override
    public void delete(Long id) {
        ventasDAO.deleteById(id);
    }
    
}
