package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clasificacion_general")
public class ClasificacionGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer posicion;

    private boolean clasificado;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_participante")
    private Participante participante;

    // ==== GETTERS & SETTERS ====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public boolean isClasificado() {
        return clasificado;
    }

    public void setClasificado(boolean clasificado) {
        this.clasificado = clasificado;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
