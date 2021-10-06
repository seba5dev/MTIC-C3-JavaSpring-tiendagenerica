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
    @Column(length = 20)
    private Long cedula_usuario;
    @Column(length = 255)
    private String nombre_usuario;
    private String usuario;
    private String password;
    @Column(name = "email_usuario", nullable = false, unique = true, length = 255)
    private String email_usuario;


    public UsuarioModel() {
    }

    public UsuarioModel(Long cedula_usuario, String nombre_usuario, String usuario, String password, String email_usuario) {
        this.cedula_usuario = cedula_usuario;
        this.nombre_usuario = nombre_usuario;
        this.usuario = usuario;
        this.password = password;
        this.email_usuario = email_usuario;
    }

    public Long getCedula_usuario() {
        return this.cedula_usuario;
    }

    public void setCedula_usuario(Long cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }

    public String getNombre_usuario() {
        return this.nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_usuario() {
        return this.email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public UsuarioModel cedula_usuario(Long cedula_usuario) {
        setCedula_usuario(cedula_usuario);
        return this;
    }

    public UsuarioModel nombre_usuario(String nombre_usuario) {
        setNombre_usuario(nombre_usuario);
        return this;
    }

    public UsuarioModel usuario(String usuario) {
        setUsuario(usuario);
        return this;
    }

    public UsuarioModel password(String password) {
        setPassword(password);
        return this;
    }

    public UsuarioModel email_usuario(String email_usuario) {
        setEmail_usuario(email_usuario);
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
        return Objects.equals(cedula_usuario, usuarioModel.cedula_usuario) && Objects.equals(nombre_usuario, usuarioModel.nombre_usuario) && Objects.equals(usuario, usuarioModel.usuario) && Objects.equals(password, usuarioModel.password) && Objects.equals(email_usuario, usuarioModel.email_usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula_usuario, nombre_usuario, usuario, password, email_usuario);
    }

    @Override
    public String toString() {
        return "{" +
            " cedula_usuario='" + getCedula_usuario() + "'" +
            ", nombre_usuario='" + getNombre_usuario() + "'" +
            ", usuario='" + getUsuario() + "'" +
            ", password='" + getPassword() + "'" +
            ", email_usuario='" + getEmail_usuario() + "'" +
            "}";
    }


}
