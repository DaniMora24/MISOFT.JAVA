/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Model.Registro;
import Services.RegistroService;
import Util.ValidationUtil;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet("/registro")
public class RegistroController extends HttpServlet {

    private RegistroService registroService = new RegistroService();
    private ValidationUtil validationUtil = new ValidationUtil();

    // Mostrar el formulario de registro
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vistas/registro.jsp").forward(request, response);
    }

    // Procesar el formulario de registro
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombres = request.getParameter("Nombres");
        String apellidos = request.getParameter("Apellidos");
        String tipoDocumento = request.getParameter("Tipo_documento");
        String numeroDocumento = request.getParameter("Numero_documento");
        String fechaNacimientoStr = request.getParameter("Edad"); // Aquí recibimos la fecha de nacimiento
        String telefono = request.getParameter("Telefono");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        // Validar los campos
        if (!validationUtil.validateUserFields(nombres, apellidos, tipoDocumento, numeroDocumento, fechaNacimientoStr, telefono, email, password, request)) {
            request.getRequestDispatcher("/vistas/registro.jsp").forward(request, response);
            return;
        }

        // Validar que la fecha de nacimiento no sea nula o vacía
        if (fechaNacimientoStr == null || fechaNacimientoStr.isEmpty()) {
            request.setAttribute("errorMessage", "La fecha de nacimiento es obligatoria.");
            request.getRequestDispatcher("/vistas/registro.jsp").forward(request, response);
            return;
        }

        // Convertir la fecha de nacimiento a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaNacimiento;
        try {
            fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
        } catch (DateTimeParseException e) {
            request.setAttribute("errorMessage", "La fecha de nacimiento no tiene el formato correcto.");
            request.getRequestDispatcher("/vistas/registro.jsp").forward(request, response);
            return;
        }

        // Calcular la edad
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();

        // Validar que el usuario tenga al menos 14 años
        if (edad < 14) {
            request.setAttribute("errorMessage", "Debes tener al menos 14 años para registrarte.");
            request.getRequestDispatcher("/vistas/registro.jsp").forward(request, response);
            return;
        }

        // Crear el registro del usuario y guardar la fecha de nacimiento
        
    Registro registro = new Registro(nombres, apellidos, tipoDocumento, numeroDocumento, fechaNacimientoStr, telefono, email, password);
    boolean success = registroService.create(registro);


        if (success) {
            request.setAttribute("success", "Registro completado con éxito.");
            // Redirige al inicio de sesión
             request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Error al registrar el usuario.");
            request.getRequestDispatcher("/vistas/registro.jsp").forward(request, response);
        }
    }
}