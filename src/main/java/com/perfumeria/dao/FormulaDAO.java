package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.Formula;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormulaDAO {

    public void insertar(Formula formula) throws SQLException {
        String sql = "INSERT INTO Formula (NombreFormula, VersionFormula, FechaCreacion, Observaciones, idPerfume) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, formula.getNombreFormula());
            ps.setString(2, formula.getVersion());
            ps.setDate(3, Date.valueOf(formula.getFechaCreacion()));
            ps.setString(4, formula.getObservaciones());
            ps.setInt(5, formula.getIdPerfume());

            ps.executeUpdate();
        }
    }

    public List<Formula> consultarTodos() throws SQLException {
        List<Formula> lista = new ArrayList<>();
        String sql = "SELECT * FROM Formula";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Formula formula = new Formula();
                formula.setIdFormula(rs.getInt("IdFormula"));
                formula.setNombreFormula(rs.getString("NombreFormula"));
                formula.setVersion(rs.getString("VersionFormula"));
                formula.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
                formula.setObservaciones(rs.getString("Observaciones"));
                formula.setIdPerfume(rs.getInt("idPerfume"));
                lista.add(formula);
            }
        }
        return lista;
    }

    public void actualizar(Formula formula) throws SQLException {
        String sql = "UPDATE Formula SET NombreFormula = ?, VersionFormula = ?, FechaCreacion = ?, Observaciones = ?, idPerfume = ? WHERE IdFormula = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, formula.getNombreFormula());
            ps.setString(2, formula.getVersion());
            ps.setDate(3, Date.valueOf(formula.getFechaCreacion()));
            ps.setString(4, formula.getObservaciones());
            ps.setInt(5, formula.getIdPerfume());
            ps.setInt(6, formula.getIdFormula());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idFormula) throws SQLException {
        String sql = "DELETE FROM Formula WHERE IdFormula = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idFormula);
            ps.executeUpdate();
        }
    }
}