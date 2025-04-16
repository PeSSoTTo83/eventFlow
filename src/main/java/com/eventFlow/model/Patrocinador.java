package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patrocinadores")
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatrocinador;

    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private String codigoPostal;
    private String pais;
    private String cif;
    private Double importePatrocinio;

    @ManyToOne
    @JoinColumn(name = "idEvento")
    private Evento evento;

	public Long getIdPatrocinador() {
		return idPatrocinador;
	}

	public void setIdPatrocinador(Long idPatrocinador) {
		this.idPatrocinador = idPatrocinador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Double getImportePatrocinio() {
		return importePatrocinio;
	}

	public void setImportePatrocinio(Double importePatrocinio) {
		this.importePatrocinio = importePatrocinio;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

    
}
