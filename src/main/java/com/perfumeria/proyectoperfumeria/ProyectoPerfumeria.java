package com.perfumeria.proyectoperfumeria;

import com.perfumeria.dao.*;
import com.perfumeria.modelo.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ProyectoPerfumeria {

    public static void main(String[] args) {
        try {
            probarUsuario();
            probarPerfume();
            probarInsumo();
            probarFormula();
            probarOrden();
            probarDetalleFormula();
            probarDetalleOrden();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void probarUsuario() throws SQLException {
        System.out.println("=== USUARIO ===");
        UsuarioDAO dao = new UsuarioDAO();

        Usuario nuevo = new Usuario();
        nuevo.setNombre("Prueba Usuario");
        nuevo.setUsuario("pruebaUser");
        nuevo.setContrasena("clave123");
        nuevo.setRol("Vendedor");
        // dao.insertar(nuevo); // ya se probo antes, se comenta para evitar duplicados

        List<Usuario> lista = dao.consultarTodos();
        for (Usuario u : lista) {
            System.out.println(u.getIdUsuario() + " - " + u.getNombre() + " - " + u.getRol());
        }
    }

    static void probarPerfume() throws SQLException {
        System.out.println("=== PERFUME ===");
        PerfumeDAO dao = new PerfumeDAO();

        Perfume nuevo = new Perfume();
        nuevo.setNombre("Perfume de Prueba");
        nuevo.setDescripcion("Fragancia de prueba");
        nuevo.setTipo("Eau de Toilette");
        nuevo.setPrecio(99000.0);
        nuevo.setFechaRegistro(LocalDate.now());
        // dao.insertar(nuevo); // ya se probo antes

        List<Perfume> lista = dao.consultarTodos();
        for (Perfume p : lista) {
            System.out.println(p.getIdPerfume() + " - " + p.getNombre() + " - " + p.getPrecio());
        }
    }

    static void probarInsumo() throws SQLException {
        System.out.println("=== INSUMO ===");
        InsumoDAO dao = new InsumoDAO();

        Insumo nuevo = new Insumo();
        nuevo.setNombre("Esencia de Prueba");
        nuevo.setUnidadMedida("ml");
        nuevo.setCantidadDisponible(150.0);
        nuevo.setEstado("disponible");
        // dao.insertar(nuevo); // ya se probo antes

        List<Insumo> lista = dao.consultarTodos();
        for (Insumo i : lista) {
            System.out.println(i.getIdInsumo() + " - " + i.getNombre() + " - " + i.getCantidadDisponible());
        }
    }

    static void probarFormula() throws SQLException {
        System.out.println("=== FORMULA ===");
        FormulaDAO dao = new FormulaDAO();

        Formula nueva = new Formula();
        nueva.setNombreFormula("Formula de Prueba");
        nueva.setVersion("1.0");
        nueva.setFechaCreacion(LocalDate.now());
        nueva.setObservaciones("Formula creada para pruebas");
        nueva.setIdPerfume(1);
        dao.insertar(nueva); // primera vez, se deja activo

        List<Formula> lista = dao.consultarTodos();
        for (Formula f : lista) {
            System.out.println(f.getIdFormula() + " - " + f.getNombreFormula() + " - idPerfume:" + f.getIdPerfume());
        }
    }

    static void probarOrden() throws SQLException {
        System.out.println("=== ORDEN ===");
        OrdenDAO dao = new OrdenDAO();

        Orden nueva = new Orden();
        nueva.setFechaOrden(LocalDate.now());
        nueva.setEstado("pendiente");
        nueva.setObservaciones("Orden de prueba");
        nueva.setIdCliente(1);
        nueva.setIdUsuario(1);
        dao.insertar(nueva); // primera vez, se deja activo

        List<Orden> lista = dao.consultarTodos();
        for (Orden o : lista) {
            System.out.println(o.getIdOrden() + " - " + o.getEstado() + " - idCliente:" + o.getIdCliente());
        }
    }

    static void probarDetalleFormula() throws SQLException {
        System.out.println("=== DETALLE FORMULA ===");
        DetalleFormulaDAO dao = new DetalleFormulaDAO();

        DetalleFormula nuevo = new DetalleFormula();
        nuevo.setIdFormula(1);
        nuevo.setIdInsumo(1);
        nuevo.setCantidad(25.0);
        dao.insertar(nuevo); // primera vez, se deja activo

        List<DetalleFormula> lista = dao.consultarTodos();
        for (DetalleFormula d : lista) {
            System.out.println(d.getIdDetalle() + " - Formula:" + d.getIdFormula() + " - Insumo:" + d.getIdInsumo() + " - Cant:" + d.getCantidad());
        }
    }

    static void probarDetalleOrden() throws SQLException {
        System.out.println("=== DETALLE ORDEN ===");
        DetalleOrdenDAO dao = new DetalleOrdenDAO();

        DetalleOrden nuevo = new DetalleOrden();
        nuevo.setIdOrden(1);
        nuevo.setIdPerfume(1);
        nuevo.setCantidad(2);
        dao.insertar(nuevo); // primera vez, se deja activo

        List<DetalleOrden> lista = dao.consultarTodos();
        for (DetalleOrden d : lista) {
            System.out.println(d.getIdDetalleOrden() + " - Orden:" + d.getIdOrden() + " - Perfume:" + d.getIdPerfume() + " - Cant:" + d.getCantidad());
        }
    }
}