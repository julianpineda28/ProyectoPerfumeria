package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.DetalleOrden;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleOrdenDAO {

    public void insertar(DetalleOrden detalle) throws SQLException {
        String sql = "INSERT INTO DetalleOrden (Cantidad, idOrden, idPerfume) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getCantidad());
            ps.setInt(2, detalle.getIdOrden());
            ps.setInt(3, detalle.getIdPerfume());

            ps.executeUpdate();
        }
    }

    public List<DetalleOrden> consultarTodos() throws SQLException {
        List<DetalleOrden> lista = new ArrayList<>();
        String sql = "SELECT * FROM DetalleOrden";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DetalleOrden detalle = new DetalleOrden();
                detalle.setIdDetalleOrden(rs.getInt("idDetalleOrden"));
                detalle.setCantidad(rs.getInt("Cantidad"));
                detalle.setIdOrden(rs.getInt("idOrden"));
                detalle.setIdPerfume(rs.getInt("idPerfume"));
                lista.add(detalle);
            }
        }
        return lista;
    }

    public void actualizar(DetalleOrden detalle) throws SQLException {
        String sql = "UPDATE DetalleOrden SET Cantidad = ?, idOrden = ?, idPerfume = ? WHERE idDetalleOrden = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getCantidad());
            ps.setInt(2, detalle.getIdOrden());
            ps.setInt(3, detalle.getIdPerfume());
            ps.setInt(4, detalle.getIdDetalleOrden());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idDetalleOrden) throws SQLException {
        String sql = "DELETE FROM DetalleOrden WHERE idDetalleOrden = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idDetalleOrden);
            ps.executeUpdate();
        }
    }
}