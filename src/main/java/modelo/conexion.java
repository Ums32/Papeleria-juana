package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    private static final String URL =
            "jdbc:mysql://127.0.0.1:3306/papeleria_juana";
    private static final String USER = "root";
    private static final String PASS = System.getenv("DB_PASSWORD");

    public static Connection conectar() {
        Connection con = null;

        if (PASS == null || PASS.isBlank()) {
            System.err.println(
                    "No se ha configurado la variable DB_PASSWORD.");
            return null;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa con MySQL.");

        } catch (ClassNotFoundException e) {
            System.err.println(
                    "No se encontró el controlador JDBC de MySQL.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("Error de conexión con MySQL:");
            e.printStackTrace();
        }

        return con;
    }
}