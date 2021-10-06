package com.sebas.tiendagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.sebas.tiendagenerica.model.ProveedorModel;
import com.sebas.tiendagenerica.services.ProveedorService;

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
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedoresService;

    //Crear proveedores
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProveedorModel proveedores) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(proveedores));
    }

    //Buscar proveedores por id
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") Long proveedoresid) {
        Optional<ProveedorModel> oProveedores = proveedoresService.findById(proveedoresid);
        if (!oProveedores.isPresent()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(oProveedores);
        }
    }

    //Actualizar proveedores
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProveedorModel proveedoresDetails, @PathVariable(value = "id") Long proveedoresid) {
        Optional<ProveedorModel> uProveedores = proveedoresService.findById(proveedoresid);

        if (!uProveedores.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        uProveedores.get().setNitproveedor(proveedoresDetails.getNitproveedor());
        uProveedores.get().setCiudad_proveedor(proveedoresDetails.getCiudad_proveedor());
        uProveedores.get().setDireccion_proveedor(proveedoresDetails.getDireccion_proveedor());
        uProveedores.get().setNombre_proveedor(proveedoresDetails.getNombre_proveedor());
        uProveedores.get().setTelefono_proveedor(proveedoresDetails.getTelefono_proveedor());

        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(uProveedores.get()));
    }

    //Eliminar proveedores
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long proveedoresid) {
        if (!proveedoresService.findById(proveedoresid).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        proveedoresService.delete(proveedoresid);
        return ResponseEntity.ok().build();
    }

    //Obtener todos los proveedoress
    @GetMapping
    public List<ProveedorModel> readAll() {
        List<ProveedorModel> proveedoress = StreamSupport.stream(proveedoresService.findAll().spliterator(), false).collect(Collectors.toList());
        return proveedoress;
    }
}
