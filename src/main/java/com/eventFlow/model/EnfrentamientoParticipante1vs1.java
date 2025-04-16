package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
public class EnfrentamientoParticipante1vs1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Participante participante1;

    @ManyToOne
    private Participante participante2;

    private String resultado;

    // Getters y Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Evento getEvento() { return evento; }

    public void setEvento(Evento evento) { this.evento = evento; }

    public Participante getParticipante1() { return participante1; }

    public void setParticipante1(Participante participante1) { this.participante1 = participante1; }

    public Participante getParticipante2() { return participante2; }

    public void setParticipante2(Participante participante2) { this.participante2 = participante2; }

    public String getResultado() { return resultado; }

    public void setResultado(String resultado) { this.resultado = resultado; }
}
