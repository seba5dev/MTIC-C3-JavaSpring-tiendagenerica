package com.sebas.tiendagenerica.services;

import java.util.Optional;

import com.sebas.tiendagenerica.dao.ProveedorDAO;
import com.sebas.tiendagenerica.model.ProveedorModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl implements ProveedorService{
    @Autowired
    private ProveedorDAO proveedoresDAO;

    @Override
    public Iterable<ProveedorModel> findAll() {
        return proveedoresDAO.findAll();
    }

    @Override
    public Optional<ProveedorModel> findById(Long id) {
        return proveedoresDAO.findById(id);
    }

    @Override
    public ProveedorModel save(ProveedorModel proveedores) {
        return proveedoresDAO.save(proveedores);
    }

    @Override
    public void delete(Long id) {
        proveedoresDAO.deleteById(id);
    }
}
