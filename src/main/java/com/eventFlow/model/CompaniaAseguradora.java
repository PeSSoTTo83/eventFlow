package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "companias_aseguradoras")
public class CompaniaAseguradora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aseguradora")
    private Long idAseguradora;

    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    private String pais;

    // Getters y Setters

    public Long getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(Long idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    public String getNombre() {
        return nombre != null ? nombre : "";
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono != null ? telefono : "";
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo != null ? correo : "";
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion != null ? direccion : "";
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal != null ? codigoPostal : "";
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais != null ? pais : "";
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
