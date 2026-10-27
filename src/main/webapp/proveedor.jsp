<%-- 
    Document   : proveedor
    Created on : 20/09/2026, 2:31:43 p. m.
    Author     : Juanita Cortes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Registro Proveedor</h2>
        <form action="ProveedorServlet" method= "post">
            Nombre: <input type="text" name="txtNombre" maxlength="40" required><br></br>
            Telefono: <input type="number" name="txtTelefono" maxlength="10" required><br></br>
            <button type="submit"> Guardar </button>
        </form>
        <br>
        <a href="index.jsp"> Volver al menu </a>
<%-- 
Todo el bloque de codigo indica los Atributos de la tabla Proveedor, con sus debidos rangos y tipos de datos
--%>
    </body>
</html>
