package com.nicholassilva.PruebaTecnica.models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name="clientes")
public class Clientes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCliente;
    @NotEmpty(message = "No puede ir vacio")
    @Column(nullable = false)
    private String nombre;
    @NotEmpty(message = "No puede ir vacio")
    private String apellidos;

    @Column(nullable = false, columnDefinition = "BIGINT")
    private long numeroContacto;
    @NotEmpty(message = "No puede ir vacio")
    @Email(message = "No es una direccion de correo valida")
    private String correoContacto;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(long numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

}
