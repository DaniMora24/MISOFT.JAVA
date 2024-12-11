package ModelDAO;

import Model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    private Connection connection;

    // Constructor con inicialización de conexión interna
   

    // Constructor que recibe una conexión externa
    public EmpleadoDAO(Connection connection) {
        this.connection = connection;
    }

    // Listar empleados
    public List<Empleado> listar() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setFecha_contratacion(rs.getDate("fecha_Contratacion"));
                empleado.setRol_usuario(rs.getString("rol_Usuario"));
                empleado.setId_usuario(rs.getInt("id_Usuario"));
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    // Agregar empleado
    public void agregar(Empleado empleado) throws SQLException {
        String query = "INSERT INTO empleado (nombre, apellido, salario, fecha_Contratacion, rol_Usuario, id_Usuario) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setDouble(3, empleado.getSalario());
            pstmt.setDate(4, empleado.getFecha_contratacion());
            pstmt.setString(5, empleado.getRol_usuario());
            pstmt.setInt(6, empleado.getId_usuario());
            pstmt.executeUpdate();
        }
    }

    // Actualizar empleado
    public void actualizar(Empleado empleado) throws SQLException {
        String query = "UPDATE empleado SET nombre = ?, apellido = ?, salario = ?, fecha_Contratacion = ?, rol_Usuario = ?, id_Usuario = ? WHERE idEmpleado = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setDouble(3, empleado.getSalario());
            pstmt.setDate(4, empleado.getFecha_contratacion());
            pstmt.setString(5, empleado.getRol_usuario());
            pstmt.setInt(6, empleado.getId_usuario());
            pstmt.setInt(7, empleado.getIdEmpleado());
            pstmt.executeUpdate();
        }
    }

   

    // Obtener empleado por ID
    public Empleado obtenerPorId(int id) throws SQLException {
        String sql = "SELECT * FROM empleado WHERE idEmpleado = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Empleado empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                    empleado.setNombre(rs.getString("nombre"));
                    empleado.setApellido(rs.getString("apellido"));
                    empleado.setSalario(rs.getDouble("salario"));
                    empleado.setFecha_contratacion(rs.getDate("fecha_Contratacion"));
                    empleado.setRol_usuario(rs.getString("rol_Usuario"));
                    empleado.setId_usuario(rs.getInt("id_Usuario"));
                    return empleado;
                }
            }
        }
        return null;
    }
    
    public boolean eliminar(int idEmpleado) throws SQLException {
    String query = "DELETE FROM empleado WHERE idEmpleado = ?";
    boolean eliminado = false;

    // Usar try-with-resources para manejar automáticamente los recursos
    try (PreparedStatement pstmt = connection.prepareStatement(query)) {
        pstmt.setInt(1, idEmpleado);

        // Ejecutar la actualización
        int rowsAffected = pstmt.executeUpdate();
        // Si rowsAffected es mayor que 0, la eliminación fue exitosa
        if (rowsAffected > 0) {
            eliminado = true;
        }
    } catch (SQLException e) {
        // Puedes registrar la excepción o lanzar una nueva
        throw new SQLException("Error al eliminar el empleado: " + e.getMessage());
    }

    return eliminado;  // Retornar true si se eliminó correctamente, de lo contrario false
}

}

