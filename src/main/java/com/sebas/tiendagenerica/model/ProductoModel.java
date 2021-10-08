package com.sebas.tiendagenerica.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long codigo_producto;
    private double ivacompra;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProveedorModel nitproveedor;
    private String nombre_producto;
    private double precio_compra;
    private double precio_venta;


    public ProductoModel() {
    }

    public ProductoModel(Long codigo_producto, double ivacompra, ProveedorModel nitproveedor, String nombre_producto, double precio_compra, double precio_venta) {
        this.codigo_producto = codigo_producto;
        this.ivacompra = ivacompra;
        this.nitproveedor = nitproveedor;
        this.nombre_producto = nombre_producto;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public Long getCodigo_producto() {
        return this.codigo_producto;
    }

    public void setCodigo_producto(Long codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public double getIvacompra() {
        return this.ivacompra;
    }

    public void setIvacompra(double ivacompra) {
        this.ivacompra = ivacompra;
    }

    public ProveedorModel getNitproveedor() {
        return this.nitproveedor;
    }

    public void setNitproveedor(ProveedorModel nitproveedor) {
        this.nitproveedor = nitproveedor;
    }

    public String getNombre_producto() {
        return this.nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_compra() {
        return this.precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return this.precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public ProductoModel codigo_producto(Long codigo_producto) {
        setCodigo_producto(codigo_producto);
        return this;
    }

    public ProductoModel ivacompra(double ivacompra) {
        setIvacompra(ivacompra);
        return this;
    }

    public ProductoModel nitproveedor(ProveedorModel nitproveedor) {
        setNitproveedor(nitproveedor);
        return this;
    }

    public ProductoModel nombre_producto(String nombre_producto) {
        setNombre_producto(nombre_producto);
        return this;
    }

    public ProductoModel precio_compra(double precio_compra) {
        setPrecio_compra(precio_compra);
        return this;
    }

    public ProductoModel precio_venta(double precio_venta) {
        setPrecio_venta(precio_venta);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProductoModel)) {
            return false;
        }
        ProductoModel productoModel = (ProductoModel) o;
        return Objects.equals(codigo_producto, productoModel.codigo_producto) && ivacompra == productoModel.ivacompra && Objects.equals(nitproveedor, productoModel.nitproveedor) && Objects.equals(nombre_producto, productoModel.nombre_producto) && precio_compra == productoModel.precio_compra && precio_venta == productoModel.precio_venta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_producto, ivacompra, nitproveedor, nombre_producto, precio_compra, precio_venta);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo_producto='" + getCodigo_producto() + "'" +
            ", ivacompra='" + getIvacompra() + "'" +
            ", nitproveedor='" + getNitproveedor() + "'" +
            ", nombre_producto='" + getNombre_producto() + "'" +
            ", precio_compra='" + getPrecio_compra() + "'" +
            ", precio_venta='" + getPrecio_venta() + "'" +
            "}";
    }
    
}
