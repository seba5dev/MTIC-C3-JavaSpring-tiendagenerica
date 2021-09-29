package com.sebas.tiendagenerica.services;
import java.util.Optional;

import com.sebas.tiendagenerica.model.ClienteModel;

public interface ClienteService {
    public Iterable<ClienteModel> findAll();
    public Optional<ClienteModel> findById(Long id);
    public ClienteModel save(ClienteModel cliente);
    public void delete(Long id);
}
