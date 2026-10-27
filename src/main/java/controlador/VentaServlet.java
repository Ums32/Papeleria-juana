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
@WebServlet("/VentaServlet")
public class VentaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("producto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double total = Double.parseDouble(request.getParameter("total"));
        int idUsuario = Integer.parseInt(request.getParameter("id_usuario"));
        
        try (Connection con = conexion.conectar()) {
            String sql = "INSERT INTO venta (fecha, total, id_usuario) VALUES (CURDATE(), ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, total);
            ps.setInt(2, idUsuario);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al registrar venta en MySQL: " + e.getMessage());
        }
        response.sendRedirect("VentaServlet");
    }
}
