package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clasificacion_versus")
public class ClasificacionVersus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // "Ronda 1", "Semifinal", etc.

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_equipo1")
    private Equipo equipo1;

    @ManyToOne
    @JoinColumn(name = "id_equipo2")
    private Equipo equipo2;

    private Integer marcador1;
    private Integer marcador2;

    public ClasificacionVersus() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public Equipo getEquipo1() { return equipo1; }
    public void setEquipo1(Equipo equipo1) { this.equipo1 = equipo1; }

    public Equipo getEquipo2() { return equipo2; }
    public void setEquipo2(Equipo equipo2) { this.equipo2 = equipo2; }

    public Integer getMarcador1() { return marcador1; }
    public void setMarcador1(Integer marcador1) { this.marcador1 = marcador1; }

    public Integer getMarcador2() { return marcador2; }
    public void setMarcador2(Integer marcador2) { this.marcador2 = marcador2; }
}
