package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.DetalleFormula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleFormulaDAO {

    public void insertar(DetalleFormula detalle) throws SQLException {
        String sql = "INSERT INTO DetalleFormula (IdFormula, IdInsumo, Cantidad) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getIdFormula());
            ps.setInt(2, detalle.getIdInsumo());
            ps.setDouble(3, detalle.getCantidad());

            ps.executeUpdate();
        }
    }

    public List<DetalleFormula> consultarTodos() throws SQLException {
        List<DetalleFormula> lista = new ArrayList<>();
        String sql = "SELECT * FROM DetalleFormula";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DetalleFormula detalle = new DetalleFormula();
                detalle.setIdDetalle(rs.getInt("idDetalle"));
                detalle.setIdFormula(rs.getInt("IdFormula"));
                detalle.setIdInsumo(rs.getInt("IdInsumo"));
                detalle.setCantidad(rs.getDouble("Cantidad"));
                lista.add(detalle);
            }
        }
        return lista;
    }

    public void actualizar(DetalleFormula detalle) throws SQLException {
        String sql = "UPDATE DetalleFormula SET IdFormula = ?, IdInsumo = ?, Cantidad = ? WHERE idDetalle = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getIdFormula());
            ps.setInt(2, detalle.getIdInsumo());
            ps.setDouble(3, detalle.getCantidad());
            ps.setInt(4, detalle.getIdDetalle());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idDetalle) throws SQLException {
        String sql = "DELETE FROM DetalleFormula WHERE idDetalle = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDetalle);
            ps.executeUpdate();
        }
    }
}