package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGasto;

    private String descripcion;
    private Double importe;

    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;

	public Long getIdGasto() {
		return idGasto;
	}

	public void setIdGasto(Long idGasto) {
		this.idGasto = idGasto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

    
}
