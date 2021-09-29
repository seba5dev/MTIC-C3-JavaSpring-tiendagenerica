package com.sebas.tiendagenerica.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 11)
    private String cedula;
    private String nombre;
    private String password;
    private String nombre_completo;
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String correo;
    private boolean enabled;

    public UsuarioModel() {
    }

    public UsuarioModel(Long id, String cedula, String nombre, String password, String nombre_completo, String correo,
            boolean enabled) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.password = password;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.enabled = enabled;
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

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre_completo() {
        return this.nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UsuarioModel id(Long id) {
        setId(id);
        return this;
    }

    public UsuarioModel cedula(String cedula) {
        setCedula(cedula);
        return this;
    }

    public UsuarioModel nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public UsuarioModel password(String password) {
        setPassword(password);
        return this;
    }

    public UsuarioModel nombre_completo(String nombre_completo) {
        setNombre_completo(nombre_completo);
        return this;
    }

    public UsuarioModel correo(String correo) {
        setCorreo(correo);
        return this;
    }

    public UsuarioModel enabled(boolean enabled) {
        setEnabled(enabled);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioModel)) {
            return false;
        }
        UsuarioModel usuarioModel = (UsuarioModel) o;
        return Objects.equals(id, usuarioModel.id) && Objects.equals(cedula, usuarioModel.cedula)
                && Objects.equals(nombre, usuarioModel.nombre) && Objects.equals(password, usuarioModel.password)
                && Objects.equals(nombre_completo, usuarioModel.nombre_completo)
                && Objects.equals(correo, usuarioModel.correo) && enabled == usuarioModel.enabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cedula, nombre, password, nombre_completo, correo, enabled);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", cedula='" + getCedula() + "'" + ", nombre='" + getNombre() + "'"
                + ", password='" + getPassword() + "'" + ", nombre_completo='" + getNombre_completo() + "'"
                + ", correo='" + getCorreo() + "'" + ", enabled='" + isEnabled() + "'" + "}";
    }

}
