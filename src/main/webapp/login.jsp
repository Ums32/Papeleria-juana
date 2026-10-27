<%-- 
    Document   : login
    Created on : 27/10/2026, 2:13:18 p. m.
    Author     : Juanita Cortes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Iniciar sesión - Papelería Juana</title>
        <!<!-- CSS en nuestro archivo HTML -->
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                background-color: #f4f4f4;
                color: #333333;
            }

            .encabezado {
                background-color: #eeeeee;
                text-align: center;
                padding: 30px;
            }

            h1 {
                margin-bottom: 10px;
            }

            main {
                width: 90%;
                max-width: 900px;
                margin: 30px auto;
            }

            .login {
                background-color: white;
                padding: 25px;
                margin: 30px auto;
                max-width: 400px;
                border-radius: 10px;
            }
            .login h2 {
                margin-top: 0;
                text-align: center;
            }
            
            .login label {
                display: block;
                margin-bottom: 8px;
            }
            
            .login input {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #cccccc;
                border-radius: 5px;
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }
            
            .login button {
                width: 100%;
                padding: 12px;
                background-color: #1565c0;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-family: Arial, sans-serif;
                font-size: 16px;
            }
            
            .login button:hover {
                background-color: #0d47a1;
            }
            
            .error {
                color: #c62828;
                text-align: center;
            }
            
            footer {
                text-align: center;
                padding: 20px;
                background-color: #eeeeee;
            }
        </style>
    </head>
<!-- Cuerpo del documento (Acciones que tomarán los modulos) -->
    <body>
        <header class="encabezado">
            <h1>Papelería Juana</h1>
            <p>Sistema de gestión de la papelería</p>
        </header>
        <main>

            <section class="login">
                <h2>Iniciar sesión</h2>

                <form action="${pageContext.request.contextPath}/LoginServlet"
                      method="post">

                    <label for="usuario">Usuario:</label>
                    <input type="text"
                           id="usuario"
                           name="usuario"
                           placeholder="Ingresa tu usuario"
                           autocomplete="username"
                           required>

                    <label for="password">Contraseña:</label>
                    <input type="password"
                           id="password"
                           name="password"
                           placeholder="Ingresa tu contraseña"
                           autocomplete="current-password"
                           required>

                    <button type="submit">Ingresar</button>
                </form>
                <% if (request.getAttribute("error") != null) { %>
                    <p class="error">
                        <%= request.getAttribute("error") %>
                    </p>
                <% } %>
            </section>
        </main>
        <footer>
            <p>Papelería Juana</p>
        </footer>
    </body>
</html>