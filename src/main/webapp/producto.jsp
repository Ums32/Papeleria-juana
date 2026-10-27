<%-- 
    Document   : producto
    Created on : 20/09/2026, 2:32:20 p. m.
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
        <h2>Registro Producto</h2>
        <form action="ProductoServlet" method= "post">
            Nombre: <input type="text" name="txtNombre" maxlength="40" required><br></br>
            Descripcion: <input type="text" name="txtDescripcion" maxlength="100" required><br></br>
            Precio: <input type="number" name="txtPrecio" min="0.01" step="0.01" required><br></br>
            Stock: <input type="number" name="txtStock" min="0.01" step="0.01" required><br></br>
            ID Proveedor: <input type="number" name="txtIdProveedor" min="1" step="1" required><br></br>
            <button type="submit">Guardar</button>
        </form>
        <br>
        <a href="index.jsp"> Volver al menu </a>
<%--
Todo el bloque de codigo indica los Atributos de la tabla Producto, con sus debidos rangos y tipos de datos
--%>
    </body>
</html>
