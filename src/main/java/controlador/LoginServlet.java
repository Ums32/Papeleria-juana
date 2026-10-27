/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 *
 * @author Juanita Cortes
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    // Credenciales temporales para probar el inicio de sesión.
    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "admin123";

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene las credenciales enviadas desde login.jsp.
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        // Compara las credenciales ingresadas con las de prueba.
        if (USUARIO.equals(usuario) && CONTRASENA.equals(password)) {
            // Crea una sesión para el usuario autenticado.
            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioAutenticado", usuario);
            // Devuelve el mensaje de autenticación satisfactoria.
            response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().println(
                    "Autenticación satisfactoria."
            );

        } else {
            // Muestra un mensaje si las credenciales son incorrectas.
            request.setAttribute(
                    "error",
                    "Error en la autenticación. Verifica tu usuario y contraseña."
            );
            // Devuelve al usuario al formulario de inicio de sesión.
            request.getRequestDispatcher("/login.jsp")
                   .forward(request, response);
        }
    }
}
