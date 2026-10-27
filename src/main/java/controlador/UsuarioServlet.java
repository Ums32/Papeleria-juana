
package controlador;

import modelo.conexion;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("usuario.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        String telefono = request.getParameter("txtTelefono");
        String email = request.getParameter("txtEmail");

        String sql = "INSERT INTO usuario (nombre, apellido, telefono, email) "
                   + "VALUES (?, ?, ?, ?)";

        try (Connection con = conexion.conectar()) {

            if (con == null) {
                throw new SQLException("No se pudo establecer la conexión con MySQL.");
            }

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setString(2, apellido);
                ps.setString(3, telefono);
                ps.setString(4, email);

                int filas = ps.executeUpdate();

                if (filas > 0) {
                    System.out.println("Usuario guardado correctamente.");
                } else {
                    throw new SQLException("No se insertó ningún usuario.");
                }
            }

            response.sendRedirect("UsuarioServlet");

        } catch (SQLException e) {
            e.printStackTrace();

            response.setContentType("text/plain;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println(
                "Error SQL al guardar usuario: " + e.getMessage()
            );

        } catch (Exception e) {
            e.printStackTrace();

            response.setContentType("text/plain;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println(
                "Error al guardar usuario: " + e.getMessage()
            );
        }
    }
}
