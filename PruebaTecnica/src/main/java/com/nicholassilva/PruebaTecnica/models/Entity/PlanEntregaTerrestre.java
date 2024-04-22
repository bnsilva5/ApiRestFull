package com.nicholassilva.PruebaTecnica.models.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static java.time.temporal.WeekFields.ISO;

@Entity
@Table(name="planEntregaTerrestre")
public class PlanEntregaTerrestre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "No puede ir vacio, la cantidad de productos a enviar")
    @Column(nullable = false)
    private Long cantidadProductos;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "No puede ir vacio la fecha de registro")
    @Column(nullable = false)
    private LocalDate fechaRegistro;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "No puede ir vacio la fecha de entrega")
    @Column(nullable = false)
    private LocalDate fechaEntrega;
    @NotNull(message = "No puede ir vacio el precio de envio")
    @Column(nullable = false)
    private Long precioEnvio;


    private double descuento;

    private double totalEnvio;
    @NotEmpty(message = "No puede ir vacio la placa del vehiculo")
    @Column(nullable = false)
    private String placaVehiculo;
    @NotNull(message = "No puede ir vacio el numero de guia")
    @Column(nullable = false)
    private long numeroGuia;
    @ManyToOne
    @JoinColumn(name = "tipoProducto")
    private TipoProducto tipoProductoEntrega;
    @ManyToOne
    @JoinColumn(name = "tipoAlmacenamiento")
    private Almacenamiento almacenamiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(Long cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(Long precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    public Long getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Long numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public TipoProducto getTipoProductoEntrega() {
        return tipoProductoEntrega;
    }

    public void setTipoProductoEntrega(TipoProducto tipoProductoEntrega) {
        this.tipoProductoEntrega = tipoProductoEntrega;
    }

    public Almacenamiento getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(Almacenamiento almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setTotalEnvio(double totalEnvio) {
        this.totalEnvio = totalEnvio;
    }

    public void calcularDescuento() {
        if(this.cantidadProductos > 10) {
            if(this.almacenamiento.getTipo().equals("Terrestre")) {
                Long descuento = (long) ((this.precioEnvio * 5)/100);
                this.setDescuento(descuento);
            } else if (this.almacenamiento.getTipo().equals("Maritimo")) {
                Long descuento = (long) ((this.precioEnvio * 3)/100);
                this.setDescuento(descuento);
            }
        }else {
            this.setDescuento(0L);
        }
    }

    public void totalEnvio() {
        Long base = this.precioEnvio;
        double descuento = this.descuento;
        this.setTotalEnvio(base-descuento);
    }


}
