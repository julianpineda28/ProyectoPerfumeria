package com.perfumeria.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/perfumeria_db";

    private static final String USUARIO = "root";

    private static final String CONTRASENA = "JulianPineda0828";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(
                URL,
                USUARIO,
                CONTRASENA
        );
    }
}
