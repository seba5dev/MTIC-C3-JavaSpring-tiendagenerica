package com.sebas.tiendagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.sebas.tiendagenerica.model.DetalleVentasModel;
import com.sebas.tiendagenerica.services.DetalleVentasService;

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
@RequestMapping("/api/detalleVentass")
public class DetalleVentasController {
    @Autowired
    private DetalleVentasService detalleVentasService;

    //Crear detalleVentas
    @PostMapping
    public ResponseEntity<?> create(@RequestBody DetalleVentasModel detalleVentas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentasService.save(detalleVentas));
    }

    //Buscar detalleVentas por id
    @GetMapping("/{id]")
    public ResponseEntity<?> read(@PathVariable(value="id") Long detalleVentasid) {
        Optional<DetalleVentasModel> oDetalleVentas = detalleVentasService.findById(detalleVentasid);
        if (!oDetalleVentas.isPresent()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(oDetalleVentas);
        }
    }

    //Actualizar detalleVentas
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody DetalleVentasModel detalleVentasDetails, @PathVariable(value = "id") Long detalleVentasid) {
        Optional<DetalleVentasModel> uDetalleVentas = detalleVentasService.findById(detalleVentasid);

        if (!uDetalleVentas.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        uDetalleVentas.get().setCodigo_detalle_venta(detalleVentasDetails.getCodigo_detalle_venta());
        uDetalleVentas.get().setCantidad_producto(detalleVentasDetails.getCantidad_producto());
        uDetalleVentas.get().setCodigo_producto(detalleVentasDetails.getCodigo_producto());
        uDetalleVentas.get().setCodigo_venta(detalleVentasDetails.getCodigo_venta());
        uDetalleVentas.get().setValor_total(detalleVentasDetails.getValor_total());
        uDetalleVentas.get().setValor_venta(detalleVentasDetails.getValor_venta());
        uDetalleVentas.get().setValoriva(detalleVentasDetails.getValoriva());

        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentasService.save(uDetalleVentas.get()));
    }

    //Eliminar detalleVentas
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long detalleVentasid) {
        if (!detalleVentasService.findById(detalleVentasid).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        detalleVentasService.delete(detalleVentasid);
        return ResponseEntity.ok().build();
    }

    //Obtener todos los detalleVentass
    @GetMapping
    public List<DetalleVentasModel> readAll() {
        List<DetalleVentasModel> detalleVentass = StreamSupport.stream(detalleVentasService.findAll().spliterator(), false).collect(Collectors.toList());
        return detalleVentass;
    }
}
