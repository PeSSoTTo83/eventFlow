package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
public class EnfrentamientoParticipante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "participante1_id")
    private Participante participante1;

    @ManyToOne
    @JoinColumn(name = "participante2_id")
    private Participante participante2;

    private Integer marcador1;
    private Integer marcador2;

    private boolean esDosVsDos;

    @ManyToOne
    @JoinColumn(name = "participante3_id")
    private Participante participante3;

    @ManyToOne
    @JoinColumn(name = "participante4_id")
    private Participante participante4;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Participante getParticipante1() {
		return participante1;
	}

	public void setParticipante1(Participante participante1) {
		this.participante1 = participante1;
	}

	public Participante getParticipante2() {
		return participante2;
	}

	public void setParticipante2(Participante participante2) {
		this.participante2 = participante2;
	}

	public Integer getMarcador1() {
		return marcador1;
	}

	public void setMarcador1(Integer marcador1) {
		this.marcador1 = marcador1;
	}

	public Integer getMarcador2() {
		return marcador2;
	}

	public void setMarcador2(Integer marcador2) {
		this.marcador2 = marcador2;
	}

	public boolean isEsDosVsDos() {
		return esDosVsDos;
	}

	public void setEsDosVsDos(boolean esDosVsDos) {
		this.esDosVsDos = esDosVsDos;
	}

	public Participante getParticipante3() {
		return participante3;
	}

	public void setParticipante3(Participante participante3) {
		this.participante3 = participante3;
	}

	public Participante getParticipante4() {
		return participante4;
	}

	public void setParticipante4(Participante participante4) {
		this.participante4 = participante4;
	}

    
}
