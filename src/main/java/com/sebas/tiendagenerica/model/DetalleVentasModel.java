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
@Table(name = "detalle_ventas")
public class DetalleVentasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long codigo_detalle_venta;
    private int cantidad_producto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ProductoModel codigo_producto;
    @ManyToOne
    @JoinColumn(nullable = false)
    private VentasModel codigo_venta;
    private double valor_total;
    private double valor_venta;
    private double valoriva;


    public DetalleVentasModel() {
    }

    public DetalleVentasModel(Long codigo_detalle_venta, int cantidad_producto, ProductoModel codigo_producto, VentasModel codigo_venta, double valor_total, double valor_venta, double valoriva) {
        this.codigo_detalle_venta = codigo_detalle_venta;
        this.cantidad_producto = cantidad_producto;
        this.codigo_producto = codigo_producto;
        this.codigo_venta = codigo_venta;
        this.valor_total = valor_total;
        this.valor_venta = valor_venta;
        this.valoriva = valoriva;
    }

    public Long getCodigo_detalle_venta() {
        return this.codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public int getCantidad_producto() {
        return this.cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public ProductoModel getCodigo_producto() {
        return this.codigo_producto;
    }

    public void setCodigo_producto(ProductoModel codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public VentasModel getCodigo_venta() {
        return this.codigo_venta;
    }

    public void setCodigo_venta(VentasModel codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public double getValor_total() {
        return this.valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getValor_venta() {
        return this.valor_venta;
    }

    public void setValor_venta(double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public double getValoriva() {
        return this.valoriva;
    }

    public void setValoriva(double valoriva) {
        this.valoriva = valoriva;
    }

    public DetalleVentasModel codigo_detalle_venta(Long codigo_detalle_venta) {
        setCodigo_detalle_venta(codigo_detalle_venta);
        return this;
    }

    public DetalleVentasModel cantidad_producto(int cantidad_producto) {
        setCantidad_producto(cantidad_producto);
        return this;
    }

    public DetalleVentasModel codigo_producto(ProductoModel codigo_producto) {
        setCodigo_producto(codigo_producto);
        return this;
    }

    public DetalleVentasModel codigo_venta(VentasModel codigo_venta) {
        setCodigo_venta(codigo_venta);
        return this;
    }

    public DetalleVentasModel valor_total(double valor_total) {
        setValor_total(valor_total);
        return this;
    }

    public DetalleVentasModel valor_venta(double valor_venta) {
        setValor_venta(valor_venta);
        return this;
    }

    public DetalleVentasModel valoriva(double valoriva) {
        setValoriva(valoriva);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DetalleVentasModel)) {
            return false;
        }
        DetalleVentasModel detalleVentasModel = (DetalleVentasModel) o;
        return Objects.equals(codigo_detalle_venta, detalleVentasModel.codigo_detalle_venta) && cantidad_producto == detalleVentasModel.cantidad_producto && Objects.equals(codigo_producto, detalleVentasModel.codigo_producto) && Objects.equals(codigo_venta, detalleVentasModel.codigo_venta) && valor_total == detalleVentasModel.valor_total && valor_venta == detalleVentasModel.valor_venta && valoriva == detalleVentasModel.valoriva;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_detalle_venta, cantidad_producto, codigo_producto, codigo_venta, valor_total, valor_venta, valoriva);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo_detalle_venta='" + getCodigo_detalle_venta() + "'" +
            ", cantidad_producto='" + getCantidad_producto() + "'" +
            ", codigo_producto='" + getCodigo_producto() + "'" +
            ", codigo_venta='" + getCodigo_venta() + "'" +
            ", valor_total='" + getValor_total() + "'" +
            ", valor_venta='" + getValor_venta() + "'" +
            ", valoriva='" + getValoriva() + "'" +
            "}";
    }

}
