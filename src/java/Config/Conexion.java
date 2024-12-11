package Config;

import java.sql.*;

public class Conexion {

    // Crear la conexión
    public Connection getConexion() {
        Connection con = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver"); // Uso del driver adecuado
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/misoftdatabase", "root", "");

            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e);
        }
        return con;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
    Connection con = conexion.getConexion(); // Llamada al método de conexión

    if (con != null) {
        System.out.println("Conexión exitosa.");

        // Realizar una consulta sencilla para comprobar la conexión
        String query = "SELECT * FROM usuario LIMIT 1";  // Usa una tabla existente
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                System.out.println("Consulta exitosa. Datos de usuario: ");
                System.out.println("Email: " + rs.getString("Email"));
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e.getMessage());
        }
    } else {
        System.out.println("No se pudo conectar a la base de datos.");
    }
    }
}
