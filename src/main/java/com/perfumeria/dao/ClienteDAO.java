package com.perfumeria.dao;

import com.perfumeria.conexion.ConexionBD;
import com.perfumeria.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void insertar(Cliente cliente) throws SQLException {

        String sql = "INSERT INTO Cliente "
                + "(Nombre, Documento, Telefono, Correo) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDocumento());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());

            ps.executeUpdate();
        }
    }

    public List<Cliente> consultarTodos() throws SQLException {

        List<Cliente> lista = new ArrayList<>();

        String sql = "SELECT * FROM Cliente";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setDocumento(rs.getString("Documento"));
                cliente.setTelefono(rs.getString("Telefono"));
                cliente.setCorreo(rs.getString("Correo"));

                lista.add(cliente);
            }
        }

        return lista;
    }

    public void actualizar(Cliente cliente) throws SQLException {

        String sql = "UPDATE Cliente SET "
                + "Nombre = ?, Documento = ?, Telefono = ?, Correo = ? "
                + "WHERE idCliente = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDocumento());
            ps.setString(3, cliente.getTelefono());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getIdCliente());

            ps.executeUpdate();
        }
    }

    public void eliminar(int idCliente) throws SQLException {

        String sql = "DELETE FROM Cliente WHERE idCliente = ?";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            ps.executeUpdate();
        }
    }
}