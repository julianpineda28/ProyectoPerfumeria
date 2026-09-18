package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void insertar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO Usuario (Nombre, Usuario, Contrasena, Rol) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());

            ps.executeUpdate();
        }
    }

    public List<Usuario> consultarTodos() throws SQLException {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setContrasena(rs.getString("Contrasena"));
                usuario.setRol(rs.getString("Rol"));
                lista.add(usuario);
            }
        }
        return lista;
    }

    public void actualizar(Usuario usuario) throws SQLException {
        String sql = "UPDATE Usuario SET Nombre = ?, Usuario = ?, Contrasena = ?, Rol = ? WHERE idUsuario = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getRol());
            ps.setInt(5, usuario.getIdUsuario());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idUsuario) throws SQLException {
        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        }
    }
}