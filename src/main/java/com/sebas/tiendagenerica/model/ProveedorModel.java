package com.sebas.tiendagenerica.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class ProveedorModel {
    @Id
    @Column(length = 20)
    private Long nitproveedor;
    private String ciudad_proveedor;
    private String direccion_proveedor;
    private String nombre_proveedor;
    private String telefono_proveedor;


    public ProveedorModel() {
    }

    public ProveedorModel(Long nitproveedor, String ciudad_proveedor, String direccion_proveedor, String nombre_proveedor, String telefono_proveedor) {
        this.nitproveedor = nitproveedor;
        this.ciudad_proveedor = ciudad_proveedor;
        this.direccion_proveedor = direccion_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
    }

    public Long getNitproveedor() {
        return this.nitproveedor;
    }

    public void setNitproveedor(Long nitproveedor) {
        this.nitproveedor = nitproveedor;
    }

    public String getCiudad_proveedor() {
        return this.ciudad_proveedor;
    }

    public void setCiudad_proveedor(String ciudad_proveedor) {
        this.ciudad_proveedor = ciudad_proveedor;
    }

    public String getDireccion_proveedor() {
        return this.direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getNombre_proveedor() {
        return this.nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono_proveedor() {
        return this.telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public ProveedorModel nitproveedor(Long nitproveedor) {
        setNitproveedor(nitproveedor);
        return this;
    }

    public ProveedorModel ciudad_proveedor(String ciudad_proveedor) {
        setCiudad_proveedor(ciudad_proveedor);
        return this;
    }

    public ProveedorModel direccion_proveedor(String direccion_proveedor) {
        setDireccion_proveedor(direccion_proveedor);
        return this;
    }

    public ProveedorModel nombre_proveedor(String nombre_proveedor) {
        setNombre_proveedor(nombre_proveedor);
        return this;
    }

    public ProveedorModel telefono_proveedor(String telefono_proveedor) {
        setTelefono_proveedor(telefono_proveedor);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ProveedorModel)) {
            return false;
        }
        ProveedorModel proveedoresModel = (ProveedorModel) o;
        return Objects.equals(nitproveedor, proveedoresModel.nitproveedor) && Objects.equals(ciudad_proveedor, proveedoresModel.ciudad_proveedor) && Objects.equals(direccion_proveedor, proveedoresModel.direccion_proveedor) && Objects.equals(nombre_proveedor, proveedoresModel.nombre_proveedor) && Objects.equals(telefono_proveedor, proveedoresModel.telefono_proveedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nitproveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor);
    }

    @Override
    public String toString() {
        return "{" +
            " nitproveedor='" + getNitproveedor() + "'" +
            ", ciudad_proveedor='" + getCiudad_proveedor() + "'" +
            ", direccion_proveedor='" + getDireccion_proveedor() + "'" +
            ", nombre_proveedor='" + getNombre_proveedor() + "'" +
            ", telefono_proveedor='" + getTelefono_proveedor() + "'" +
            "}";
    }

}
