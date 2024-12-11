package Controlador;

import Model.Envio;
import Services.EnvioService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios/envios")
public class DomiciliarioController extends HttpServlet {
    private EnvioService envioService;

    @Override
    public void init() {
        envioService = new EnvioService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null || action.equals("list")) {
                List<Envio> envios = envioService.listarEnvios();
                request.setAttribute("envios", envios);
                request.getRequestDispatcher("/vistas/usuarios/domiciliario.jsp").forward(request, response);
            } else if (action.equals("edit")) {
                String numeroEnvio = request.getParameter("numero");
                Envio envio = envioService.obtenerEnvio(numeroEnvio);
                request.setAttribute("envio", envio);
                request.getRequestDispatcher("/vistas/usuarios/editarenv.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp"); // Si no se encuentra la acción
            }
        } catch (Exception e) {
            e.printStackTrace(); // Puedes usar un logger para esto en vez de printStackTrace
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String action = request.getParameter("action");

            if (action != null && action.equals("update")) {
                Envio envio = new Envio();
                envio.setNumeroEnvio(request.getParameter("numeroEnvio"));
                envio.setCostoEnvio(Double.parseDouble(request.getParameter("costoEnvio")));
                envio.setDireccionDestino(request.getParameter("direccionDestino"));
                envio.setTiempoEntrega(request.getParameter("tiempoEntrega"));
                envio.setEstadoEnvio(request.getParameter("estadoEnvio"));
                envio.setIdVenta(Integer.parseInt(request.getParameter("IdVenta")));
                envio.setIdDomiciliario(Integer.parseInt(request.getParameter("IdDomiciliario")));
                envio.setIdEmpleado(Integer.parseInt(request.getParameter("IdEmpleado")));

                envioService.actualizarEnvio(envio);

                response.sendRedirect(request.getContextPath() + "/usuarios/envios?action=list");
            } else {
                response.sendRedirect(request.getContextPath() + "/error.jsp"); // Si la acción no es update
            }
        } catch (Exception e) {
            e.printStackTrace(); // Usar un logger para mejores prácticas
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
