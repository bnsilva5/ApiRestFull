package com.nicholassilva.PruebaTecnica.models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="almacenamiento")
public class Almacenamiento {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "No puede ir vacio el nombre de la bodega o puerto")
    @Column(nullable = false)
    private String nombre;
    @NotEmpty(message = "No puede ir vacio el tipo de almacenamiento, Terrestre o Maritimo")
    @Column(nullable = false)
    private String tipo;        //Terrestre o Maritimo
    private String descripcion;
    @NotEmpty(message = "No puede ir vacia la direccion")
    @Column(nullable = false)
    private String direccion;
    private String origen;          //Nacional o internacional
    @NotEmpty(message = "No puede ir vacia, la disponibilidad del almacen")
    @Column(nullable = false)
    private Boolean disponibilidad;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
