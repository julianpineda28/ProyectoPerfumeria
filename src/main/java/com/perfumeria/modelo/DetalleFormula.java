package com.perfumeria.modelo;

public class DetalleFormula {

    private int idDetalle;
    private int idFormula;
    private int idInsumo;
    private double cantidad;

    public DetalleFormula() {
    }

    public DetalleFormula(int idDetalle, int idFormula, int idInsumo, double cantidad) {
        this.idDetalle = idDetalle;
        this.idFormula = idFormula;
        this.idInsumo = idInsumo;
        this.cantidad = cantidad;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}