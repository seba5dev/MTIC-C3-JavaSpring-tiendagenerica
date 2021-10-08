package com.sebas.tiendagenerica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.sebas.tiendagenerica.model.ProductoModel;
import com.sebas.tiendagenerica.services.ProductoService;

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
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    //Crear producto
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductoModel producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(producto));
    }

    //Buscar producto por id
    @GetMapping("/{id]")
    public ResponseEntity<?> read(@PathVariable(value="id") Long productoid) {
        Optional<ProductoModel> oProducto = productoService.findById(productoid);
        if (!oProducto.isPresent()) {
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(oProducto);
        }
    }

    //Actualizar producto
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ProductoModel productoDetails, @PathVariable(value = "id") Long productoid) {
        Optional<ProductoModel> uProducto = productoService.findById(productoid);

        if (!uProducto.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        uProducto.get().setCodigo_producto(productoDetails.getCodigo_producto());
        uProducto.get().setIvacompra(productoDetails.getIvacompra());
        uProducto.get().setNitproveedor(productoDetails.getNitproveedor());
        uProducto.get().setNombre_producto(productoDetails.getNombre_producto());
        uProducto.get().setPrecio_compra(productoDetails.getPrecio_compra());
        uProducto.get().setPrecio_venta(productoDetails.getPrecio_venta());

        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(uProducto.get()));
    }

    //Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long productoid) {
        if (!productoService.findById(productoid).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        productoService.delete(productoid);
        return ResponseEntity.ok().build();
    }

    //Obtener todos los productos
    @GetMapping
    public List<ProductoModel> readAll() {
        List<ProductoModel> productos = StreamSupport.stream(productoService.findAll().spliterator(), false).collect(Collectors.toList());
        return productos;
    }
}
