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
@WebServlet("/DetalleVentaServlet")
public class DetalleVentaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("detalle_venta.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idVenta     = Integer.parseInt(request.getParameter("id_venta"));
        int idProducto  = Integer.parseInt(request.getParameter("id_producto"));
        double subtotal = Double.parseDouble(request.getParameter("subtotal"));

        try (Connection con = conexion.conectar()) {
            String sql = "INSERT INTO detalle_venta (id_venta, id_producto, subtotal) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ps.setInt(2, idProducto);
            ps.setDouble(3, subtotal);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al guardar el detalle de venta: " + e.getMessage());
        }
        response.sendRedirect("DetalleVentaServlet");
    }
}
