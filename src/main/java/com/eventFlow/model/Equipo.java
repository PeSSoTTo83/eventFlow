package com.eventFlow.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    private List<EquipoMiembro> miembros;

    public Equipo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public List<EquipoMiembro> getMiembros() { return miembros; }
    public void setMiembros(List<EquipoMiembro> miembros) { this.miembros = miembros; }
}
