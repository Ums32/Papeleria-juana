package modelo;
import java.sql.Connection;

public class TestConexion {

    public static void main(String[] args) {

        String pass = System.getenv("DB_PASSWORD");
        System.out.println("¿Java recibió DB_PASSWORD?: "
                + (pass != null && !pass.isEmpty()));
        System.out.println("Longitud de la contraseña recibida: "
                + (pass == null ? 0 : pass.length()));

        System.out.println("Variable recibida: " + (pass != null));
        System.out.println("Longitud recibida: "
        + (pass == null ? 0 : pass.length()));
        System.out.println("Tiene espacios al inicio o al final: "
        + (pass != null && !pass.equals(pass.trim())));
        java.io.Console consola = System.console();

        if (consola != null) {
        char[] entrada = consola.readPassword(
                "Introduce la contraseña de MySQL para comparar: ");
        String escrita = new String(entrada);

        System.out.println("¿Coinciden las contraseñas?: "
                + escrita.equals(pass));
        java.util.Arrays.fill(entrada, '\0');
       }
        Connection con = conexion.conectar();

        if (con != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No se pudo conectar");
        }
    }
}