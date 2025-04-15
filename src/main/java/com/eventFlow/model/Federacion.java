package com.eventFlow.model;

import jakarta.persistence.*;

@Entity
@Table(name = "federaciones")
public class Federacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_federacion")
    private Long idFederacion;

    private String nombre;
    private String cif;
    private String direccion;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    private String provincia;
    private String pais;
    private String telefono;
    private String correo;

    @ManyToOne
    @JoinColumn(name = "id_aseguradora") // FK en la tabla federaciones
    private CompaniaAseguradora companiaAseguradora;

    // Getters y Setters
    public Long getIdFederacion() { return idFederacion; }
    public void setIdFederacion(Long idFederacion) { this.idFederacion = idFederacion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCif() { return cif; }
    public void setCif(String cif) { this.cif = cif; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public CompaniaAseguradora getCompaniaAseguradora() { return companiaAseguradora; }
    public void setCompaniaAseguradora(CompaniaAseguradora companiaAseguradora) { this.companiaAseguradora = companiaAseguradora; }
}
