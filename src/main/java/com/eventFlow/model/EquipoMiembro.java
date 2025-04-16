package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "equipo_miembros")
public class EquipoMiembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @ManyToOne
    @JoinColumn(name = "id_participante")
    private Participante participante;

    public EquipoMiembro() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Equipo getEquipo() { return equipo; }
    public void setEquipo(Equipo equipo) { this.equipo = equipo; }

    public Participante getParticipante() { return participante; }
    public void setParticipante(Participante participante) { this.participante = participante; }
}
