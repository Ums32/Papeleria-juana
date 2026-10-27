<%-- 
    Document   : venta
    Created on : 20/09/2026, 2:32:35 p. m.
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
        <h2> Venta </h2>
        <form action="VentaServlet" method= "post">
            Fecha: <input type="date" name="txtFecha" required><br></br>
            Total: <input type="number" name="txtTotal" min="0.01" step="0.01" required><br></br>>
            ID Usuario: <input type="number" name="IdUsuario" min="1" step="1" required><br></br>
        <br>
        <a href="index.jsp"> Volver al menu </a>
<%--
Todo el bloque de codigo indica los Atributos de la tabla Venta, con 
sus debidos rangos, sus foreing keys y tipos de datos
--%>
        </br>
        </form>
    </body>
</html>
