package com.eventFlow.model;

import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private Long idusuario;

    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 100, nullable = false)
    private String apellido;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechanacimiento;


    @Column(length = 20)
    private String dni;

    @Column(length = 200)
    private String email;

    @Column(length = 200)
    private String contrasenya;

    @Column(length = 20)
    private String telefono;

    /**
     * Campo para guardar el ID de la tabla tipousuario
     * (columna "TIPO_USUARIOidtipousuario" en la BD).
     */
    @Column(name = "TIPOUSUARIOidtipousuario", nullable = false)
    private Long tipousuario;

    /**
     * Campo "activo" (TINYINT(1) o CHAR(1) en la BD).
     * Guardamos "1" o "0".
     */
    @Column(name = "activo", nullable = false, length = 1)
    private String activo;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, Date fechanacimiento, String dni,
                   String email, String contrasenya, String telefono,
                   Long tipousuario, String activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.dni = dni;
        this.email = email;
        this.contrasenya = contrasenya;
        this.telefono = telefono;
        this.tipousuario = tipousuario;
        this.activo = activo;
    }

    // Getters y setters
    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Long tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
