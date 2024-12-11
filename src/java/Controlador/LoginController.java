package Controlador;

import Model.Registro;
import Services.RegistroService;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controlador para manejar el inicio de sesión de los usuarios
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

    private RegistroService registroService = new RegistroService();

    // Mostrar el formulario de inicio de sesión
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
    }

    // Procesar el inicio de sesión
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String email = request.getParameter("Email");
    String password = request.getParameter("Password");

    try {
        // Obtener el hash almacenado desde la base de datos
        RegistroService registroService = new RegistroService();
        String storedHash = registroService.obtenerHashDeLaBaseDeDatos(email);

        // Validar si el hash es nulo
        if (storedHash == null) {
            request.setAttribute("error", "Usuario no encontrado o contraseña no configurada.");
            request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
            return;
        }

        // Validar si las credenciales son correctas
        boolean isAuthenticated = registroService.login(email, password, storedHash);

        if (isAuthenticated) {
            // Credenciales correctas, obtener el usuario completo
            Registro usuario = registroService.obtenerUsuario(email);

            // Crear sesión y guardar el usuario
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            // Verificar el rol del usuario y redirigir a la página correspondiente
            if (usuario.getEmpleado() != null) {
    // Obtener el rol del empleado
    String rol = usuario.getEmpleado().getRol_usuario();
    if ("Empleado".equals(rol)) {
        response.sendRedirect(request.getContextPath() + "/vistas/catalogoadmi.jsp");
    } else if ("Domiciliario".equals(rol)) {
        response.sendRedirect(request.getContextPath() + "/vistas/catalogodomi.jsp");
    } else {
        // Si el rol no coincide con "Empleado" o "Domiciliario", puedes manejarlo de otra manera.
        response.sendRedirect(request.getContextPath() + "/vistas/catalogo.jsp");
    }
} else {
    // Si el usuario no tiene un empleado asociado, redirigir al carrito
    response.sendRedirect(request.getContextPath() + "/vistas/catalogo.jsp");
}
            
        } else {
            // Contraseña incorrecta
            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
        }
    } catch (Exception e) {
        // Registro del error para depuración
        e.printStackTrace(); // Mostrará detalles en la consola del servidor
        request.setAttribute("error", "Error interno: " + e.getMessage()); // Proporciona más detalles
        request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
    }
}
}

