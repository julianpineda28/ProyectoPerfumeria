package com.perfumeria.modelo;

import java.time.LocalDate;

public class Orden {

    private int idOrden;
    private LocalDate fechaOrden;
    private String estado;
    private String observaciones;
    private int idCliente;
    private int idUsuario;

    public Orden() {
    }

    public Orden(int idOrden, LocalDate fechaOrden, String estado, String observaciones, int idCliente, int idUsuario) {
        this.idOrden = idOrden;
        this.fechaOrden = fechaOrden;
        this.estado = estado;
        this.observaciones = observaciones;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public LocalDate getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}