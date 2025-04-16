package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clasificacion_evento")
public class ClasificacionEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_clasificacion")
    private TipoClasificacion tipoClasificacion;

    public ClasificacionEvento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public TipoClasificacion getTipoClasificacion() { return tipoClasificacion; }
    public void setTipoClasificacion(TipoClasificacion tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }
}
