package com.eventFlow.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "eventos")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEvento;

    private String nombre;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaInicio;

    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime horaFin;

    private Double precioInscripcion;

    private Integer numParticipantes = 0;

    @ManyToOne
    @JoinColumn(name = "idEntidadOrganizadora")
    private EntidadOrganizadora entidadOrganizadora;

    @ManyToOne
    @JoinColumn(name = "idLocalizacion")
    private Localizacion localizacion;

    @ManyToOne
    @JoinColumn(name = "tipo_clasificacion_id")
    private TipoClasificacion tipoClasificacion;

    // Getters y Setters

    public void incrementarParticipantes() {
        this.numParticipantes++;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Double getPrecioInscripcion() {
        return precioInscripcion;
    }

    public void setPrecioInscripcion(Double precioInscripcion) {
        this.precioInscripcion = precioInscripcion;
    }

    public Integer getNumParticipantes() {
        return numParticipantes;
    }

    public void setNumParticipantes(Integer numParticipantes) {
        this.numParticipantes = numParticipantes;
    }

    public EntidadOrganizadora getEntidadOrganizadora() {
        return entidadOrganizadora;
    }

    public void setEntidadOrganizadora(EntidadOrganizadora entidadOrganizadora) {
        this.entidadOrganizadora = entidadOrganizadora;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public TipoClasificacion getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(TipoClasificacion tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }
}
