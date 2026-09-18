package com.perfumeria.modelo;

import java.time.LocalDate;

public class Formula {

    private int idFormula;
    private String nombreFormula;
    private String version;
    private LocalDate fechaCreacion;
    private String observaciones;
    private int idPerfume;

    public Formula() {
    }

    public Formula(int idFormula, String nombreFormula, String version, LocalDate fechaCreacion, String observaciones, int idPerfume) {
        this.idFormula = idFormula;
        this.nombreFormula = nombreFormula;
        this.version = version;
        this.fechaCreacion = fechaCreacion;
        this.observaciones = observaciones;
        this.idPerfume = idPerfume;
    }

    public int getIdFormula() {
        return idFormula;
    }

    public void setIdFormula(int idFormula) {
        this.idFormula = idFormula;
    }

    public String getNombreFormula() {
        return nombreFormula;
    }

    public void setNombreFormula(String nombreFormula) {
        this.nombreFormula = nombreFormula;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdPerfume() {
        return idPerfume;
    }

    public void setIdPerfume(int idPerfume) {
        this.idPerfume = idPerfume;
    }
}
