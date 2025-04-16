package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_clasificacion")
public class TipoClasificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // "GENERAL" o "VERSUS"

    public TipoClasificacion() {}

    public TipoClasificacion(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
