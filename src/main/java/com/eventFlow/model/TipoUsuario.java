package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipousuario")
    private Long idtipousuario;

    @Column(name = "tipo", length = 100, nullable = false)
    private String tipo;

    @Column(name = "description", length = 200)
    private String description;

    /**
     * Si tu columna "activo" es TINYINT(1), puedes mapearlo como:
     * - String (guardando "1"/"0")
     * - Integer
     * - Boolean (con @Type=... si fuera necesario).
     * Aquí lo usamos como String "1" o "0" para mantener la consistencia
     * con ejemplos anteriores.
     */
    @Column(name = "activo", nullable = false, length = 1)
    private String activo;

    public TipoUsuario() {
    }

    public TipoUsuario(String tipo, String description, String activo) {
        this.tipo = tipo;
        this.description = description;
        this.activo = activo;
    }

    public Long getIdtipousuario() {
        return idtipousuario;
    }

    public void setIdtipousuario(Long idtipousuario) {
        this.idtipousuario = idtipousuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
