package ModelDAO;

import Config.Conexion;
import Model.Registro;
import Model.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class RegistroDao {

    private Connection connection;

    public RegistroDao() {
        Conexion conexion = new Conexion();
        this.connection = conexion.getConexion();
    }

    // Crear registro de usuario
    public boolean create(Registro registro) {
        return insert(registro);  // Redirige al método insert()
    }

    // Insertar usuario
   public boolean insert(Registro registro) {
    String sql = "INSERT INTO usuario (Numero_documento, Tipo_documento, Nombres, Apellidos, Telefono, Edad, Email, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, registro.getNumero_documento());
        statement.setString(2, registro.getTipo_documento());
        statement.setString(3, registro.getNombres());
        statement.setString(4, registro.getApellidos());
        statement.setLong(5, registro.getTelefono());
        statement.setString(6, registro.getEdad());
        statement.setString(7, registro.getEmail());
        
        // Encriptar la contraseña antes de guardarla
        String hashedPassword = BCrypt.hashpw(registro.getPassword(), BCrypt.gensalt());
        System.out.println("Hash generado: " + hashedPassword);  // Verifica el hash generado
        statement.setString(8, hashedPassword);
        

        
        statement.executeUpdate();
        return true;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    


    // Obtener usuario por ID
    public Registro getById(int idUsuario) {
        String sql = "SELECT * FROM usuario WHERE Id_usuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Registro(
                    resultSet.getString("Nombres"),
    resultSet.getString("Apellidos"),
    resultSet.getString("Tipo_documento"),
    resultSet.getString("Numero_documento"),
    resultSet.getString("Edad"),
    resultSet.getString("Telefono"),  // Asumiendo que tienes esta columna
    resultSet.getString("Email"),
    resultSet.getString("Password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // No se encontró
    }

    // Obtener empleado por ID de usuario
    public Empleado getEmpleadoByIdUsuario(int idUsuario) {
    String sql = "SELECT * FROM empleado WHERE Id_usuario = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, idUsuario);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            // Verificar el rol del empleado
            String rol = resultSet.getString("rol_usuario");
            System.out.println("Rol del empleado: " + rol); // Depuración
            return new Empleado(
                resultSet.getInt("IdEmpleado"),
                resultSet.getInt("Id_usuario"),
                resultSet.getString("nombre"),
                resultSet.getString("apellido"),
                resultSet.getDouble("salario"),
                resultSet.getDate("fecha_contratacion"),
                rol
            );
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;  // No se encontró
}
    
    

       
    // Comprobar las credenciales de inicio de sesión
   public boolean checkCredentials(String email, String password) {
    String sql = "SELECT Password FROM usuario WHERE Email = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String hashedPassword = resultSet.getString("Password");
            return BCrypt.checkpw(password, hashedPassword);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Credenciales inválidas o error en la consulta
}



    // Comprobar el rol del usuario
    public boolean checkRole(String email, String role) {
        String sql = "SELECT * FROM usuario WHERE Email = ? AND Role = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, role);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Retorna true si existe el rol asociado
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener hash de la base de datos para la contraseña
    public String obtenerHashDeLaBaseDeDatos(String email) throws SQLException {
        String sql = "SELECT Password FROM usuario WHERE Email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("Password");
            }
        }
        return null; // Si no se encuentra el usuario o el hash es nulo
    }

    // Comprobar las credenciales de inicio de sesión y redirigir según el rol
    public String authenticateAndRedirect(String email, String password) {
        String sql = "SELECT usuario.Email, usuario.Password, empleado.rol_usuario " +
                     "FROM usuario " +
                     "LEFT JOIN empleado ON usuario.Id_usuario = empleado.Id_usuario " +
                     "WHERE usuario.Email = ? AND usuario.Password = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String role = resultSet.getString("rol_usuario");

                if (role != null) {
                    switch (role) {
                        case "Empleado":
                            return "/vistas/dashboard"; // Redirigir al dashboard para empleado
                        case "Domiciliario":
                            return "catalogodomi"; // Redirigir al catálogo para domiciliario
                        default:
                            return "/vistas/carrito"; // Página por defecto
                    }
                } else {
                    return "noRolePage"; // Si el usuario no tiene rol asignado
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "loginPage"; // Si las credenciales son incorrectas
    }

    // Obtener todos los usuarios
    public List<Registro> getAll() {
        List<Registro> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Registro registro = new Registro(

    resultSet.getString("Nombres"),
    resultSet.getString("Apellidos"),
    resultSet.getString("Tipo_documento"),
    resultSet.getString("Numero_documento"),
    resultSet.getString("Edad"),
    resultSet.getString("Telefono"),  // Asumiendo que tienes esta columna
    resultSet.getString("Email"),
    resultSet.getString("Password")   // Asegúrate de que esta columna exista en tu base de datos
);

                usuarios.add(registro);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los usuarios: " + e.getMessage());
            e.printStackTrace();
        }
        return usuarios;
    }

    // Eliminar un usuario por ID
    public boolean delete(String email) {
    String sql = "DELETE FROM usuario WHERE Email = ?";
    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, email); // Establece el email como parámetro
        statement.executeUpdate(); // Ejecuta la consulta
        return true; // Retorna true si la operación fue exitosa
    } catch (SQLException e) {
        e.printStackTrace(); // Imprime el error en la consola
        return false; // Retorna false si hubo un error
    }
}

}

