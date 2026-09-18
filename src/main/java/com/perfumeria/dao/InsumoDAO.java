package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.Insumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsumoDAO {

    public void insertar(Insumo insumo) throws SQLException {
        String sql = "INSERT INTO Insumo (Nombre, UnidadMedida, CantidadDisponible, Estado) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, insumo.getNombre());
            ps.setString(2, insumo.getUnidadMedida());
            ps.setDouble(3, insumo.getCantidadDisponible());
            ps.setString(4, insumo.getEstado());

            ps.executeUpdate();
        }
    }

    public List<Insumo> consultarTodos() throws SQLException {
        List<Insumo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Insumo";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Insumo insumo = new Insumo();
                insumo.setIdInsumo(rs.getInt("idInsumo"));
                insumo.setNombre(rs.getString("Nombre"));
                insumo.setUnidadMedida(rs.getString("UnidadMedida"));
                insumo.setCantidadDisponible(rs.getDouble("CantidadDisponible"));
                insumo.setEstado(rs.getString("Estado"));
                lista.add(insumo);
            }
        }
        return lista;
    }

    public void actualizar(Insumo insumo) throws SQLException {
        String sql = "UPDATE Insumo SET Nombre = ?, UnidadMedida = ?, CantidadDisponible = ?, Estado = ? WHERE idInsumo = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, insumo.getNombre());
            ps.setString(2, insumo.getUnidadMedida());
            ps.setDouble(3, insumo.getCantidadDisponible());
            ps.setString(4, insumo.getEstado());
            ps.setInt(5, insumo.getIdInsumo());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idInsumo) throws SQLException {
        String sql = "DELETE FROM Insumo WHERE idInsumo = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idInsumo);
            ps.executeUpdate();
        }
    }
}