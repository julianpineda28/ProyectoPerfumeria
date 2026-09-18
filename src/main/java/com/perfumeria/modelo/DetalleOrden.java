package com.perfumeria.modelo;

public class DetalleOrden {

    private int idDetalleOrden;
    private int cantidad;
    private int idOrden;
    private int idPerfume;

    public DetalleOrden() {
    }

    public DetalleOrden(int idDetalleOrden, int cantidad, int idOrden, int idPerfume) {
        this.idDetalleOrden = idDetalleOrden;
        this.cantidad = cantidad;
        this.idOrden = idOrden;
        this.idPerfume = idPerfume;
    }

    public int getIdDetalleOrden() {
        return idDetalleOrden;
    }

    public void setIdDetalleOrden(int idDetalleOrden) {
        this.idDetalleOrden = idDetalleOrden;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdPerfume() {
        return idPerfume;
    }

    public void setIdPerfume(int idPerfume) {
        this.idPerfume = idPerfume;
    }
}