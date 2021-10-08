package com.sebas.tiendagenerica.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteModel {
    @Id
    @Column(length = 20)
    private Long cedula_cliente;
    private String nombre_cliente;
    private String direccion_cliente;
    private String telefono_cliente;
    private String email_cliente;


    public ClienteModel() {
    }

    public ClienteModel(Long cedula_cliente, String nombre_cliente, String direccion_cliente, String telefono_cliente, String email_cliente) {
        this.cedula_cliente = cedula_cliente;
        this.nombre_cliente = nombre_cliente;
        this.direccion_cliente = direccion_cliente;
        this.telefono_cliente = telefono_cliente;
        this.email_cliente = email_cliente;
    }

    public Long getCedula_cliente() {
        return this.cedula_cliente;
    }

    public void setCedula_cliente(Long cedula_cliente) {
        this.cedula_cliente = cedula_cliente;
    }

    public String getNombre_cliente() {
        return this.nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getDireccion_cliente() {
        return this.direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getTelefono_cliente() {
        return this.telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getEmail_cliente() {
        return this.email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public ClienteModel cedula_cliente(Long cedula_cliente) {
        setCedula_cliente(cedula_cliente);
        return this;
    }

    public ClienteModel nombre_cliente(String nombre_cliente) {
        setNombre_cliente(nombre_cliente);
        return this;
    }

    public ClienteModel direccion_cliente(String direccion_cliente) {
        setDireccion_cliente(direccion_cliente);
        return this;
    }

    public ClienteModel telefono_cliente(String telefono_cliente) {
        setTelefono_cliente(telefono_cliente);
        return this;
    }

    public ClienteModel email_cliente(String email_cliente) {
        setEmail_cliente(email_cliente);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ClienteModel)) {
            return false;
        }
        ClienteModel clienteModel = (ClienteModel) o;
        return Objects.equals(cedula_cliente, clienteModel.cedula_cliente) && Objects.equals(nombre_cliente, clienteModel.nombre_cliente) && Objects.equals(direccion_cliente, clienteModel.direccion_cliente) && Objects.equals(telefono_cliente, clienteModel.telefono_cliente) && Objects.equals(email_cliente, clienteModel.email_cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula_cliente, nombre_cliente, direccion_cliente, telefono_cliente, email_cliente);
    }

    @Override
    public String toString() {
        return "{" +
            " cedula_cliente='" + getCedula_cliente() + "'" +
            ", nombre_cliente='" + getNombre_cliente() + "'" +
            ", direccion_cliente='" + getDireccion_cliente() + "'" +
            ", telefono_cliente='" + getTelefono_cliente() + "'" +
            ", email_cliente='" + getEmail_cliente() + "'" +
            "}";
    }

}
