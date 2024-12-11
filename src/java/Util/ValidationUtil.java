// Util/ValidationUtil.java
package Util;

import javax.servlet.http.HttpServletRequest;

public class ValidationUtil {

    public boolean validateUserFields(String nombres, String apellidos, String tipoDocumento, String numeroDocumento,
                                       String edadStr, String telefono, String email, String password, HttpServletRequest request) {
        if (nombres == null || nombres.isEmpty() ||
            apellidos == null || apellidos.isEmpty() ||
            tipoDocumento == null || tipoDocumento.isEmpty() ||
            numeroDocumento == null || numeroDocumento.isEmpty() ||
            edadStr == null || edadStr.isEmpty() ||
            telefono == null || telefono.isEmpty() ||
            email == null || email.isEmpty() ||
            password == null || password.isEmpty()) {
                
            request.setAttribute("error", "Todos los campos son obligatorios.");
            return false;
        }
        // Agrega más validaciones si es necesario (ej. validación de correo electrónico, formato de teléfono, etc.)
        return true;
    }
}
