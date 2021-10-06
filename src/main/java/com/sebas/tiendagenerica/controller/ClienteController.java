package com.sebas.tiendagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.sebas.tiendagenerica.model.ClienteModel;
import com.sebas.tiendagenerica.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    //Crear cliente
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ClienteModel cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    //Buscar cliente por id
    @GetMapping("/{id]")
    public ResponseEntity<?> read(@PathVariable(value="id") Long clienteid) {
        Optional<ClienteModel> oCliente = clienteService.findById(clienteid);
        if (!oCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(oCliente);
        }
    }

    //Actualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ClienteModel clienteDetails, @PathVariable(value = "id") Long clienteid) {
        Optional<ClienteModel> uCliente = clienteService.findById(clienteid);

        if (!uCliente.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        uCliente.get().setCedula_cliente(clienteDetails.getCedula_cliente());
        uCliente.get().setNombre_cliente(clienteDetails.getNombre_cliente());
        uCliente.get().setDireccion_cliente(clienteDetails.getDireccion_cliente());
        uCliente.get().setTelefono_cliente(clienteDetails.getTelefono_cliente());
        uCliente.get().setEmail_cliente(clienteDetails.getEmail_cliente());

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(uCliente.get()));
    }

    //Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long clienteid) {
        if (!clienteService.findById(clienteid).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clienteService.delete(clienteid);
        return ResponseEntity.ok().build();
    }

    //Obtener todos los clientes
    @GetMapping
    public List<ClienteModel> readAll() {
        List<ClienteModel> clientes = StreamSupport.stream(clienteService.findAll().spliterator(), false).collect(Collectors.toList());
        return clientes;
    }
}
