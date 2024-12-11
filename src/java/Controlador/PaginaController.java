package Controlador;

import Model.Empleado;
import ModelDAO.EmpleadoDAO;
import Config.Conexion;
import Model.Carrito;
import Model.Registro;
import ModelDAO.CarritoDAO;
import ModelDAO.RegistroDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pagina/*")
public class PaginaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo(); // Obtén la acción de la URL

        if (action == null || action.equals("/inicio")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (action.equals("/carrito")) {
            request.getRequestDispatcher("/vistas/carrito.jsp").forward(request, response);
        } else if (action.equals("/factura")) {
            request.getRequestDispatcher("/vistas/factura.jsp").forward(request, response);
        } else if (action.equals("/dashboard")) {
            request.getRequestDispatcher("/vistas/dashboard.jsp").forward(request, response);
        } else if (action.startsWith("/empleados")) {
            try {
                procesarRutasEmpleados(action, request, response);
            } catch (SQLException ex) {
                ex.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la ruta de empleados.");
            }
        } else if (action.equals("/usuarios/index")) { // Ruta nueva para usuarios
            
                // Crear la conexión antes de pasarla al DAO
                Conexion conexion = new Conexion();
                Connection con = conexion.getConexion(); // Obtener la conexión
                RegistroDao usuarioDAO = new RegistroDao(); // Asegúrate de tener el DAO correspondiente
                List<Registro> usuarios = usuarioDAO.getAll(); // Obtener la lista de usuarios
                request.setAttribute("usuarios", usuarios); // Agregar los usuarios al request
                request.getRequestDispatcher("/vistas/usuarios/index.jsp").forward(request, response); // Redirigir a la vista
             
        }else if (action.equals("/logout")) {
    System.out.println("Se ha solicitado el logout.");
    if (request.getSession(false) != null) {
        System.out.println("Sesión existente. Invalidadando...");
        request.getSession().invalidate();
    }
    response.sendRedirect(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/index.jsp");

}
 else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void procesarRutasEmpleados(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String empleadoAction = action.substring("/empleados".length());

        // Crear la conexión antes de pasarla al DAO
        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion(); // Obtener la conexión

        if (empleadoAction.equals("") || empleadoAction.equals("/listar")) {
            try {
                EmpleadoDAO empleadoDAO = new EmpleadoDAO(con);
                List<Empleado> empleados = empleadoDAO.listar();
                request.setAttribute("empleados", empleados);  // Asegúrate de usar el nombre correcto
                request.getRequestDispatcher("/vistas/empleados/index.jsp").forward(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener los empleados.");
            }
        } else if (empleadoAction.equals("/crear")) {
            request.getRequestDispatcher("/vistas/empleados/crear.jsp").forward(request, response);
        } else if (empleadoAction.startsWith("/editar")) {
            String idEmpleadoStr = request.getParameter("id");
            if (idEmpleadoStr != null && !idEmpleadoStr.isEmpty()) {
                try {
                    int idEmpleado = Integer.parseInt(idEmpleadoStr);
                    EmpleadoDAO empleadoDAO = new EmpleadoDAO(con);
                    Empleado empleado = empleadoDAO.obtenerPorId(idEmpleado);
                    if (empleado != null) {
                        request.setAttribute("empleado", empleado);
                        request.getRequestDispatcher("/vistas/empleados/editar.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Empleado no encontrado.");
                    }
                } catch (SQLException | NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener el empleado.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de empleado no proporcionado.");
            }
        } else if (empleadoAction.startsWith("/eliminar")) {
            String idEmpleadoStr = request.getParameter("id");
            if (idEmpleadoStr != null && !idEmpleadoStr.isEmpty()) {
                try {
                    int idEmpleado = Integer.parseInt(idEmpleadoStr);
                    EmpleadoDAO empleadoDAO = new EmpleadoDAO(con);
                    boolean eliminado = empleadoDAO.eliminar(idEmpleado); // Método que elimina al empleado
                    if (eliminado) {
                        response.sendRedirect(request.getContextPath() + "/pagina/empleados/listar");
                    } else {
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el empleado.");
                    }
                } catch (SQLException | NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el empleado.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de empleado no proporcionado.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");

    if (action != null) {
        try {
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            EmpleadoDAO empleadoDAO = new EmpleadoDAO(con);

            if (action.equals("almacenar")) {
                // Almacenar un nuevo empleado
                Empleado empleado = new Empleado();
                empleado.setNombre(request.getParameter("nombre"));
                empleado.setApellido(request.getParameter("apellido"));
                empleado.setSalario(Double.parseDouble(request.getParameter("salario")));
                empleado.setFecha_contratacion(Date.valueOf(request.getParameter("fecha_contratacion")));
                empleado.setRol_usuario(request.getParameter("rol_usuario"));
                empleado.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
                empleadoDAO.agregar(empleado);
                response.sendRedirect(request.getContextPath() + "/pagina/empleados/listar");
                return;  // Asegúrate de salir después de la redirección

            } else if (action.equals("actualizar")) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(Integer.parseInt(request.getParameter("idEmpleado")));
                empleado.setNombre(request.getParameter("nombre"));
                empleado.setApellido(request.getParameter("apellido"));
                empleado.setSalario(Double.parseDouble(request.getParameter("salario")));
                empleado.setFecha_contratacion(Date.valueOf(request.getParameter("fecha_contratacion")));
                empleado.setRol_usuario(request.getParameter("rol_usuario"));
                empleado.setId_usuario(Integer.parseInt(request.getParameter("id_usuario")));
                empleadoDAO.actualizar(empleado);
                response.sendRedirect(request.getContextPath() + "/pagina/empleados/listar");
                return;  // Asegúrate de salir después de la redirección

            } else if (action.equals("eliminar")) {
                String idEmpleadoStr = request.getParameter("id");
                if (idEmpleadoStr != null && !idEmpleadoStr.isEmpty()) {
                    try {
                        int idEmpleado = Integer.parseInt(idEmpleadoStr);
                        boolean eliminado = empleadoDAO.eliminar(idEmpleado);
                        if (eliminado) {
                            response.sendRedirect(request.getContextPath() + "/pagina/empleados/listar");
                        } else {
                            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el empleado.");
                        }
                    } catch (SQLException | NumberFormatException e) {
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el empleado.");
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID de empleado no proporcionado.");
                }
                return;  // Asegúrate de salir después de la respuesta

            } else if (action.equals("store")) {
                try {
                    // Guardar factura
                    String fechaPago = request.getParameter("FechaPago");
                    String metodoPago = request.getParameter("MetodoPago");
                    double costoEnvio = Double.parseDouble(request.getParameter("CostoEnvio"));
                    double subtotal = Double.parseDouble(request.getParameter("subtotal"));
                    double iva = Double.parseDouble(request.getParameter("IVA"));
                    double valorPago = Double.parseDouble(request.getParameter("valor_pago"));
                    int idVenta = Integer.parseInt(request.getParameter("IdVenta"));
                    int numeroEnvio = Integer.parseInt(request.getParameter("numero_Envio"));

                    // Crear objeto Carrito
                    Carrito carrito = new Carrito();
                    carrito.setFechaPago(Date.valueOf(fechaPago));
                    carrito.setMetodoPago(metodoPago);
                    carrito.setCostoEnvio(costoEnvio);
                    carrito.setSubtotal(subtotal);
                    carrito.setIva(iva);
                    carrito.setValorPago(valorPago);
                    carrito.setIdVenta(idVenta);
                    carrito.setNumeroEnvio(numeroEnvio);

                    // Guardar en la base de datos
                    CarritoDAO carritoDAO = new CarritoDAO(con);
                    carritoDAO.guardar(carrito);

                    // Redirigir con mensaje de éxito
                    response.sendRedirect(request.getContextPath() + "/pagina/factura");
                    return;  // Asegúrate de salir después de la redirección

                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al guardar la factura.");
                    return;  // Asegúrate de salir después del error
                }

            } else if (action.equals("eliminarUsuario")) {
                String email = request.getParameter("email");
                if (email != null && !email.isEmpty()) {
                    RegistroDao registroDao = new RegistroDao();
                    boolean eliminado = registroDao.delete(email);

                    if (eliminado) {
                        response.sendRedirect(request.getContextPath() + "/pagina/usuarios/index");
                    } else {
                        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar el usuario.");
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Email no proporcionado.");
                }
                return;  // Asegúrate de salir después de la redirección
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida.");
                return;  // Asegúrate de salir después del error
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error en el procesamiento de datos.");
        }
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no especificada.");
    }
}
}