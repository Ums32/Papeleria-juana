<%-- 
    Document   : detalle_venta
    Created on : 20/09/2026, 2:32:43 p. m.
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
        <h2> Detalle de Venta </h2>
        <form action="Detalle VentaServlet" method= "post">
            ID Venta: <input type="text" name="id_venta" min="1" step="1" required><br></br>
            ID Producto: <input type="text" name="id_producto" min="1" step="1" required><br></br>
            Subtotal: <input type="number" name="txtSubtotal" min="0.01" step="0.01" required><br></br>
            <button type="submit"> Guardar </button>
        <a href="index.jsp"> Volver al menu </a>
 <%-- 
Todo el bloque de codigo indica los Atributos de la tabla Detalle Venta, con 
sus debidos rangos, sus foreing keys y tipos de datos
--%>
        </br>
        </form>
    </body>
</html>
