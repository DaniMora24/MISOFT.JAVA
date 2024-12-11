<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Empleado</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('img/patitas.jpg');
            background-size: cover;
            background-position: center;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            width: 90%;
            max-width: 600px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
            color: #fc6998;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #fc6998;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block; 
            margin-left: auto; 
            margin-right: auto; 
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #e04877;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Editar Empleado</h2>
        <!-- Mostrar mensajes de error si existen -->
        <c:if test="${not empty requestScope.errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach var="error" items="${requestScope.errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <!-- Formulario de edición -->
        <form action="<%= request.getContextPath() + "/pagina/empleados/editar" %>" method="POST">
            
    <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}" />

    <label for="nombre">Nombre:</label>
    <input type="text" name="nombre" value="${empleado.nombre}" required />

    <label for="apellido">Apellido:</label>
    <input type="text" name="apellido" value="${empleado.apellido}" required />
    
    <label for="salario">Salario:</label>
    <input type="number" name="salario" value="${empleado.salario}" required />
    
    <label for="fecha_contratacion">Fecha de Contratación:</label>
    <input type="date" name="fecha_contratacion" value="${empleado.fecha_contratacion}" required />
    
    <label for="rol_usuario">Rol:</label>
    <select name="rol_usuario" name="rol_usuario" required>
    <option value="Empleado" ${empleado.rol_usuario == 'Empleado' ? 'selected' : ''}>Empleado</option>
    <option value="Domiciliario" ${empleado.rol_usuario == 'Domiciliario' ? 'selected' : ''}>Domiciliario</option>
    </select>

    <label for="id_usuario">ID Usuario:</label>
    <input type="number" name="id_usuario" value="${empleado.id_usuario}" required />
    
    <button type="submit" name="action" value="actualizar" onclick="return confirm('¿Estás seguro de Actualizar este Empleado?');">Actualizar</button>
</form>


    </div>
</body>
</html>
