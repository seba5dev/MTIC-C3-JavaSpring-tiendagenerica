package com.sebas.tiendagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.sebas.tiendagenerica.model.VentasModel;
import com.sebas.tiendagenerica.services.VentasService;

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
@RequestMapping("/api/ventas")
public class VentasController {
    @Autowired
    private VentasService ventasService;

    //Crear ventas
    @PostMapping
    public ResponseEntity<?> create(@RequestBody VentasModel ventas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventasService.save(ventas));
    }

    //Buscar ventas por id
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value = "id") Long ventasid){
        Optional<VentasModel> oVentas = ventasService.findById(ventasid);
        if (!oVentas.isPresent()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(oVentas);
        }
    }

    //Actualizar ventas
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody VentasModel ventasDetails, @PathVariable(value = "id") Long ventasid) {
        Optional<VentasModel> uVentas = ventasService.findById(ventasid);

        if (!uVentas.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        uVentas.get().setCodigo_venta(ventasDetails.getCodigo_venta());
        uVentas.get().setCedula_cliente(ventasDetails.getCedula_cliente());
        uVentas.get().setCedula_usuario(ventasDetails.getCedula_usuario());
        uVentas.get().setIvaventa(ventasDetails.getIvaventa());
        uVentas.get().setTotal_venta(ventasDetails.getTotal_venta());
        uVentas.get().setValor_venta(ventasDetails.getValor_venta());

        return ResponseEntity.status(HttpStatus.CREATED).body(ventasService.save(uVentas.get()));
    }

    //Eliminar ventas
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long ventasid) {
        if (!ventasService.findById(ventasid).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        ventasService.delete(ventasid);
        return ResponseEntity.ok().build();
    }

    //Obtener todos los ventass
    @GetMapping
    public List<VentasModel> readAll() {
        List<VentasModel> ventas = StreamSupport.stream(ventasService.findAll().spliterator(), false).collect(Collectors.toList());
        return ventas;
    }
}
