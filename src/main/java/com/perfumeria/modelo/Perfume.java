package com.perfumeria.modelo;

import java.time.LocalDate;

public class Perfume {

    private int idPerfume;
    private String nombre;
    private String descripcion;
    private String tipo;
    private double precio;
    private LocalDate fechaRegistro;

    public Perfume() {
    }

    public Perfume(int idPerfume, String nombre, String descripcion, String tipo, double precio, LocalDate fechaRegistro) {
        this.idPerfume = idPerfume;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdPerfume() {
        return idPerfume;
    }

    public void setIdPerfume(int idPerfume) {
        this.idPerfume = idPerfume;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}