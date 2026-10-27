/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.conexion;
import java.io.IOException;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
/**
 *
 * @author Juanita Cortes
 */
@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("proveedor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre   = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");

        try (Connection con = conexion.conectar()) {
            String sql = "INSERT INTO proveedor (nombre, telefono) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al guardar proveedor en MySQL: " + e.getMessage());
        }
        response.sendRedirect("ProveedorServlet");
    }
}
