package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
public class EnfrentamientoParticipante2vs2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Participante jugador1a;

    @ManyToOne
    private Participante jugador1b;

    @ManyToOne
    private Participante jugador2a;

    @ManyToOne
    private Participante jugador2b;

    private String resultado;

    // Getters & Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Evento getEvento() { return evento; }

    public void setEvento(Evento evento) { this.evento = evento; }

    public Participante getJugador1a() { return jugador1a; }

    public void setJugador1a(Participante jugador1a) { this.jugador1a = jugador1a; }

    public Participante getJugador1b() { return jugador1b; }

    public void setJugador1b(Participante jugador1b) { this.jugador1b = jugador1b; }

    public Participante getJugador2a() { return jugador2a; }

    public void setJugador2a(Participante jugador2a) { this.jugador2a = jugador2a; }

    public Participante getJugador2b() { return jugador2b; }

    public void setJugador2b(Participante jugador2b) { this.jugador2b = jugador2b; }

    public String getResultado() { return resultado; }

    public void setResultado(String resultado) { this.resultado = resultado; }
}
