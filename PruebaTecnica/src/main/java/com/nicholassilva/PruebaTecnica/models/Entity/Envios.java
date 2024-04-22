package com.nicholassilva.PruebaTecnica.models.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Envios")
public class Envios {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
    @ManyToOne
    @JoinColumn(name = "plan_entrega_id")
    private PlanEntregaTerrestre planEntregaTerrestre;
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitudEnvio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public PlanEntregaTerrestre getPlanEntregaTerrestre() {
        return planEntregaTerrestre;
    }

    public void setPlanEntregaTerrestre(PlanEntregaTerrestre planEntregaTerrestre) {
        this.planEntregaTerrestre = planEntregaTerrestre;
    }

    public Date getFechaSolicitudEnvio() {
        return fechaSolicitudEnvio;
    }

    public void setFechaSolicitudEnvio(Date fechaSolicitudEnvio) {
        this.fechaSolicitudEnvio = fechaSolicitudEnvio;
    }

}
