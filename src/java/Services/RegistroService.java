package Services;

import Model.Registro;
import ModelDAO.RegistroDao;
import Config.Conexion;
import Model.Empleado;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RegistroService {

    private RegistroDao registroDao = new RegistroDao();
    private Conexion conexion = new Conexion(); // Instancia de la clase Conexion
    private Connection connection; // Conexión a la base de datos

    // Crear un nuevo usuario (asegurarse de encriptar la contraseña)
    public boolean create(Registro registro) {
        // Generar el hash de la contraseña
        String hashedPassword = BCrypt.hashpw(registro.getPassword(), BCrypt.gensalt());
        registro.setPassword(hashedPassword); // Establecer la contraseña encriptada
        return registroDao.insert(registro);
    }

    // Obtener el hash de la base de datos por email
    public String obtenerHashDeLaBaseDeDatos(String email) throws SQLException {
        String hash = null;
        connection = conexion.getConexion(); // Obtener conexión
        String query = "SELECT Password FROM usuario WHERE Email = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    hash = rs.getString("Password");
                }
            }
        }
        return hash;
    }

    // Obtener un usuario completo por email, incluyendo su empleado asociado
public Registro obtenerUsuario(String email) throws SQLException {
    Registro usuario = null;
    connection = conexion.getConexion();
    String query = "SELECT * FROM usuario WHERE Email = ?";
    try (PreparedStatement ps = connection.prepareStatement(query)) {
        ps.setString(1, email);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                usuario = new Registro();
                // Mapear los datos de la base de datos a tu clase Registro
                usuario.setEmail(rs.getString("Email"));
                usuario.setPassword(rs.getString("Password"));
                // Mapear otros campos según la estructura de tu modelo Registro

                // Obtener el empleado asociado y asignarlo al usuario
                Empleado empleado = obtenerEmpleado(rs.getInt("Id_usuario"));
                usuario.setEmpleado(empleado); // Asignar el empleado al usuario
            }
        }
    }
    return usuario;
}

    
    
    
        private Empleado obtenerEmpleado(int Id_usuario) throws SQLException {
    Empleado empleado = null;
    String sql = "SELECT * FROM empleado WHERE Id_usuario = ?";  // Relación con la tabla empleado
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, Id_usuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            // Aquí debes obtener todos los campos de la tabla 'empleado'
            empleado = new Empleado(
                rs.getInt("IdEmpleado"),           // Asegúrate de tener todos los campos
                rs.getInt("Id_usuario"),
                rs.getString("Nombre"),
                rs.getString("Apellido"),
                rs.getDouble("Salario"),
                rs.getDate("Fecha_contratacion"),
                rs.getString("Rol_usuario")
            );
        }
    }
    return empleado;
}


    // Verificar credenciales (email, contraseña, y hash almacenado)
    public boolean login(String email, String password, String storedHash) {
        try {
            if (storedHash != null && storedHash.startsWith("$2y$")) {
                storedHash = storedHash.replaceFirst("\\$2y\\$", "\\$2a\\$");
            }
            return BCrypt.checkpw(password, storedHash);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al verificar el hash: " + e.getMessage());
            return false;
        }
    }

    // Actualizar la contraseña si el hash es inválido
    public boolean updatePasswordIfInvalid(String email, String password) {
        try {
            String storedPassword = obtenerHashDeLaBaseDeDatos(email);
            if (!isValidHash(storedPassword)) {
                String newHashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                updatePasswordInDatabase(email, newHashedPassword);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Verificar si el hash es válido
    private boolean isValidHash(String hash) {
        return hash != null && (hash.startsWith("$2a$") || hash.startsWith("$2y$"));
    }

    // Actualizar la contraseña en la base de datos
    private void updatePasswordInDatabase(String email, String newHashedPassword) {
        String query = "UPDATE usuario SET Password = ? WHERE Email = ?";
        try (PreparedStatement ps = conexion.getConexion().prepareStatement(query)) {
            ps.setString(1, newHashedPassword);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos auxiliares de roles
    public boolean isEmpleado(String email) {
        return registroDao.checkRole(email, "Empleado");
    }

    public boolean isDomiciliario(String email) {
        return registroDao.checkRole(email, "Domiciliario");
    }

    // Obtener todos los usuarios
    public List<Registro> getAllUsuarios() {
        return registroDao.getAll();
    }

    
}
