package com.sebas.tiendagenerica.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cedula;
    private String nombre_completo;
    private String direccion;
    private String telefono;
    private String correo;


    public ClienteModel() {
    }

    public ClienteModel(Long id, String cedula, String nombre_completo, String direccion, String telefono, String correo) {
        this.id = id;
        this.cedula = cedula;
        this.nombre_completo = nombre_completo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_completo() {
        return this.nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ClienteModel id(Long id) {
        setId(id);
        return this;
    }

    public ClienteModel cedula(String cedula) {
        setCedula(cedula);
        return this;
    }

    public ClienteModel nombre_completo(String nombre_completo) {
        setNombre_completo(nombre_completo);
        return this;
    }

    public ClienteModel direccion(String direccion) {
        setDireccion(direccion);
        return this;
    }

    public ClienteModel telefono(String telefono) {
        setTelefono(telefono);
        return this;
    }

    public ClienteModel correo(String correo) {
        setCorreo(correo);
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
        return Objects.equals(id, clienteModel.id) && Objects.equals(cedula, clienteModel.cedula) && Objects.equals(nombre_completo, clienteModel.nombre_completo) && Objects.equals(direccion, clienteModel.direccion) && Objects.equals(telefono, clienteModel.telefono) && Objects.equals(correo, clienteModel.correo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cedula, nombre_completo, direccion, telefono, correo);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cedula='" + getCedula() + "'" +
            ", nombre_completo='" + getNombre_completo() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", telefono='" + getTelefono() + "'" +
            ", correo='" + getCorreo() + "'" +
            "}";
    }


}
