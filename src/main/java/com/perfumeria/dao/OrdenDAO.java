package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.Orden;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenDAO {

    public void insertar(Orden orden) throws SQLException {
        String sql = "INSERT INTO Orden (FechaOrden, Estado, Observaciones, IdCliente, IdUsuario) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(orden.getFechaOrden()));
            ps.setString(2, orden.getEstado());
            ps.setString(3, orden.getObservaciones());
            ps.setInt(4, orden.getIdCliente());
            ps.setInt(5, orden.getIdUsuario());

            ps.executeUpdate();
        }
    }

    public List<Orden> consultarTodos() throws SQLException {
        List<Orden> lista = new ArrayList<>();
        String sql = "SELECT * FROM Orden";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Orden orden = new Orden();
                orden.setIdOrden(rs.getInt("idOrden"));
                orden.setFechaOrden(rs.getDate("FechaOrden").toLocalDate());
                orden.setEstado(rs.getString("Estado"));
                orden.setObservaciones(rs.getString("Observaciones"));
                orden.setIdCliente(rs.getInt("IdCliente"));
                orden.setIdUsuario(rs.getInt("IdUsuario"));
                lista.add(orden);
            }
        }
        return lista;
    }

    public void actualizar(Orden orden) throws SQLException {
        String sql = "UPDATE Orden SET FechaOrden = ?, Estado = ?, Observaciones = ?, IdCliente = ?, IdUsuario = ? WHERE idOrden = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(orden.getFechaOrden()));
            ps.setString(2, orden.getEstado());
            ps.setString(3, orden.getObservaciones());
            ps.setInt(4, orden.getIdCliente());
            ps.setInt(5, orden.getIdUsuario());
            ps.setInt(6, orden.getIdOrden());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idOrden) throws SQLException {
        String sql = "DELETE FROM Orden WHERE idOrden = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idOrden);
            ps.executeUpdate();
        }
    }
}