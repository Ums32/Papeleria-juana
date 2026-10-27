<%-- 
    Document   : usuario
    Created on : 20/09/2026, 2:31:33 p. m.
    Author     : Juanita Cortes
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>

    <body>
        <h2>Registro Usuario</h2>
        <form action="UsuarioServlet" method="post">
            Nombre: <input type="text" name="txtNombre" maxlength="25" required> <br><br>
            Apellido: <input type="text" name="txtApellido" maxlength="25" required> <br><br>
            Telefono: <input type="tel" name="txtTelefono" maxlength="10" pattern="[0-9]{10}" required> <br><br>
            Correo: <input type="email" name="txtEmail" maxlength="100" required> <br><br>
            <button type="submit">Guardar</button>
        </form>
        <br>
        <a href="index.jsp">Volver al menu</a> 
<%-- Todo el bloque de codigo indica los Atributos de la tabla Usuario, con sus debidos rangos y tipos de datos --%>
    </body>
</html>
