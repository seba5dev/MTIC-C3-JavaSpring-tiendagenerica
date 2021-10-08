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
@Table(name = "ventas")
public class VentasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Long codigo_venta;
    @ManyToOne
    @JoinColumn(nullable = false)
    private ClienteModel cedula_cliente;
    @ManyToOne
    @JoinColumn(nullable = false)
    private UsuarioModel cedula_usuario;
    private double ivaventa;
    private double total_venta;
    private double valor_venta;


    public VentasModel() {
    }

    public VentasModel(Long codigo_venta, ClienteModel cedula_cliente, UsuarioModel cedula_usuario, double ivaventa, double total_venta, double valor_venta) {
        this.codigo_venta = codigo_venta;
        this.cedula_cliente = cedula_cliente;
        this.cedula_usuario = cedula_usuario;
        this.ivaventa = ivaventa;
        this.total_venta = total_venta;
        this.valor_venta = valor_venta;
    }

    public Long getCodigo_venta() {
        return this.codigo_venta;
    }

    public void setCodigo_venta(Long codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public ClienteModel getCedula_cliente() {
        return this.cedula_cliente;
    }

    public void setCedula_cliente(ClienteModel cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public UsuarioModel getCedula_usuario() {
        return this.cedula_usuario;
    }

    public void setCedula_usuario(UsuarioModel cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public double getIvaventa() {
        return this.ivaventa;
    }

    public void setIvaventa(double ivaventa) {
        this.ivaventa = ivaventa;
    }

    public double getTotal_venta() {
        return this.total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public double getValor_venta() {
        return this.valor_venta;
    }

    public void setValor_venta(double valor_venta) {
        this.valor_venta = valor_venta;
    }

    public VentasModel codigo_venta(Long codigo_venta) {
        setCodigo_venta(codigo_venta);
        return this;
    }

    public VentasModel cedula_cliente(ClienteModel cedula_cliente) {
        setCedula_cliente(cedula_cliente);
        return this;
    }

    public VentasModel cedula_usuario(UsuarioModel cedula_usuario) {
        setCedula_usuario(cedula_usuario);
        return this;
    }

    public VentasModel ivaventa(double ivaventa) {
        setIvaventa(ivaventa);
        return this;
    }

    public VentasModel total_venta(double total_venta) {
        setTotal_venta(total_venta);
        return this;
    }

    public VentasModel valor_venta(double valor_venta) {
        setValor_venta(valor_venta);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof VentasModel)) {
            return false;
        }
        VentasModel ventasModel = (VentasModel) o;
        return Objects.equals(codigo_venta, ventasModel.codigo_venta) && Objects.equals(cedula_cliente, ventasModel.cedula_cliente) && Objects.equals(cedula_usuario, ventasModel.cedula_usuario) && ivaventa == ventasModel.ivaventa && total_venta == ventasModel.total_venta && valor_venta == ventasModel.valor_venta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo_venta, cedula_cliente, cedula_usuario, ivaventa, total_venta, valor_venta);
    }

    @Override
    public String toString() {
        return "{" +
            " codigo_venta='" + getCodigo_venta() + "'" +
            ", cedula_cliente='" + getCedula_cliente() + "'" +
            ", cedula_usuario='" + getCedula_usuario() + "'" +
            ", ivaventa='" + getIvaventa() + "'" +
            ", total_venta='" + getTotal_venta() + "'" +
            ", valor_venta='" + getValor_venta() + "'" +
            "}";
    }

}
