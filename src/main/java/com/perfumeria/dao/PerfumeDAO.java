package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.Perfume;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerfumeDAO {

    public void insertar(Perfume perfume) throws SQLException {
        String sql = "INSERT INTO Perfume (Nombre, Descripcion, Tipo, precio, FechaRegistro) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, perfume.getNombre());
            ps.setString(2, perfume.getDescripcion());
            ps.setString(3, perfume.getTipo());
            ps.setDouble(4, perfume.getPrecio());
            ps.setDate(5, Date.valueOf(perfume.getFechaRegistro()));

            ps.executeUpdate();
        }
    }

    public List<Perfume> consultarTodos() throws SQLException {
        List<Perfume> lista = new ArrayList<>();
        String sql = "SELECT * FROM Perfume";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Perfume perfume = new Perfume();
                perfume.setIdPerfume(rs.getInt("idPerfume"));
                perfume.setNombre(rs.getString("Nombre"));
                perfume.setDescripcion(rs.getString("Descripcion"));
                perfume.setTipo(rs.getString("Tipo"));
                perfume.setPrecio(rs.getDouble("precio"));
                perfume.setFechaRegistro(rs.getDate("FechaRegistro").toLocalDate());
                lista.add(perfume);
            }
        }
        return lista;
    }

    public void actualizar(Perfume perfume) throws SQLException {
        String sql = "UPDATE Perfume SET Nombre = ?, Descripcion = ?, Tipo = ?, precio = ?, FechaRegistro = ? WHERE idPerfume = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, perfume.getNombre());
            ps.setString(2, perfume.getDescripcion());
            ps.setString(3, perfume.getTipo());
            ps.setDouble(4, perfume.getPrecio());
            ps.setDate(5, Date.valueOf(perfume.getFechaRegistro()));
            ps.setInt(6, perfume.getIdPerfume());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idPerfume) throws SQLException {
        String sql = "DELETE FROM Perfume WHERE idPerfume = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPerfume);
            ps.executeUpdate();
        }
    }
}
