package com.perfumeria.modelo;

public class Insumo {

    private int idInsumo;
    private String nombre;
    private String unidadMedida;
    private double cantidadDisponible;
    private String estado;

    public Insumo() {
    }

    public Insumo(int idInsumo, String nombre, String unidadMedida, double cantidadDisponible, String estado) {
        this.idInsumo = idInsumo;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.cantidadDisponible = cantidadDisponible;
        this.estado = estado;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}