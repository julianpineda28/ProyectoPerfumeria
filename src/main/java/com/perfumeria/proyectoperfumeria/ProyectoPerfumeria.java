package com.perfumeria.proyectoperfumeria;

import com.perfumeria.dao.ClienteDAO;
import com.perfumeria.modelo.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ProyectoPerfumeria {

    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();

        try {
            // Insertar un cliente de prueba
            Cliente nuevo = new Cliente();
            nuevo.setNombre("Julian Pineda");
            nuevo.setDocumento("1122334455");
            nuevo.setTelefono("3009998877");
            nuevo.setCorreo("julian@test.com");

            clienteDAO.insertar(nuevo);
            System.out.println("Cliente insertado correctamente");

            // Consultar todos los clientes
            List<Cliente> clientes = clienteDAO.consultarTodos();
            System.out.println("Lista de clientes:");
            for (Cliente c : clientes) {
                System.out.println(c.getIdCliente() + " - " + c.getNombre() + " - " + c.getDocumento());
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
