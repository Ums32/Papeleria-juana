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
@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("producto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre      = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        double precio      = Double.parseDouble(request.getParameter("precio"));
        int stock          = Integer.parseInt(request.getParameter("stock"));
        int idProveedor    = Integer.parseInt(request.getParameter("id_proveedor"));

        try (Connection con = conexion.conectar()) {
            String sql = "INSERT INTO producto (nombre, descripcion, precio, stock, id_proveedor) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setInt(4, stock);
            ps.setInt(5, idProveedor);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al guardar producto en MySQL: " + e.getMessage());
        }
        response.sendRedirect("ProductoServlet");
    }
}
