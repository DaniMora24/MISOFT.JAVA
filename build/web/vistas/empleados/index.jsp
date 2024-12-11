<%@ page import="java.util.List" %>
<%@ page import="Model.Empleado" %> <!-- Ajusta el paquete según tu estructura -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Css/dashboard.css">
    <title>Lista de Empleados</title>
</head>
<body>
    <div class="container">
        <header>
            <button class="menu-toggle" onclick="toggleMenu()">☰</button>
        </header>
        <div class="banner">
            <h1>Panel De Control</h1>
        </div>
        <div class="sidebar">
            <ul class="menu">
                <li><a href="${pageContext.request.contextPath}/catalogo">Inicio</a></li>
                <li>
                    <a href="#" class="dropdown-toggle" onclick="toggleDropdown(event)">Registros</a>
                    <ul class="dropdown">
                        <li><a href="${pageContext.request.contextPath}/pagina/usuarios/index">Usuarios</a></li>
                        <li><a href="${pageContext.request.contextPath}/pagina/empleados/listar">Empleados</a></li>
                        <li><a href="${pageContext.request.contextPath}/movimientos">Movimientos Inventario</a></li>
                        <li><a href="${pageContext.request.contextPath}/proveedores">Proveedores</a></li>
                        <li><a href="${pageContext.request.contextPath}/productos">Productos</a></li>
                        <li><a href="${pageContext.request.contextPath}/envio">Envio</a></li>
                        <li><a href="${pageContext.request.contextPath}/equipo">Equipo</a></li>
                        <li><a href="${pageContext.request.contextPath}/pqrs">PQRS</a></li>
                        <li><a href="#">Compras</a></li>
                    </ul>
                </li>
                <li><a href="#">Configuración</a></li>
                <li><a href="#">Estadisticas</a></li>
                <li><a href="#">Notificaciones</a></li>
                <li>
                    <form action="${pageContext.request.contextPath}/pagina/logout" method="GET">
        <button type="submit" class="btn btn-danger">Cerrar sesión</button>
    </form>
                </li>
            </ul>
        </div>
        <main>
            <section class="data-table">
                <h2>Lista de Empleados</h2>
                <table>
                    <thead>
                        <tr>
                            <th>Id Empleado</th> 
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Salario</th>
                            <th>Fecha de Contratación</th>
                            <th>Rol de Usuario</th>
                            <th>Id Usuario</th> 
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
    <c:forEach var="empleado" items="${empleados}">
        <tr>
            <td>${empleado.idEmpleado}</td>
            <td>${empleado.nombre}</td>
            <td>${empleado.apellido}</td>
            <td>${empleado.salario}</td>
            <td>${empleado.fecha_contratacion}</td>
            <td>${empleado.rol_usuario}</td>
            <td>${empleado.id_usuario}</td>
            <td>
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/pagina/empleados/editar?id=${empleado.idEmpleado}">Editar</a>
                
                <form action="${pageContext.request.contextPath}/pagina/empleados/eliminar" method="POST" onclick="return confirm('¿Estás seguro de Eliminar este Empleado?');" style="display:inline;">
        <input type="hidden" name="id" value="${empleado.idEmpleado}">
        <input type="hidden" name="action" value="eliminar">
        <button type="submit" class="btn btn-danger">Eliminar</button>
                </form>

                <a class="btn btn-danger" href="${pageContext.request.contextPath}/pagina/empleados/crear">Registrar</a>
                <a  class="btn" onclick="imprimirReporte()">Reporte</a>
            </td>
        </tr>
    </c:forEach>
</tbody>

                </table>
            </section>
        </main>

        <!-- Mostrar mensaje de éxito si está presente en la sesión -->
        <c:if test="${not empty sessionScope.success}">
            <div class="alert alert-success">
                ${sessionScope.success}
            </div>
        </c:if>

        <!-- Mostrar errores si están presentes -->
        <c:if test="${not empty requestScope.errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach var="error" items="${requestScope.errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
    </div>
    <script>
        function toggleMenu() {
            const sidebar = document.querySelector('.sidebar');
            sidebar.classList.toggle('show');
        }

        function toggleDropdown(event) {
            event.preventDefault();
            const dropdown = event.target.nextElementSibling;
            dropdown.classList.toggle('show');
        }
        
        function imprimirReporte() {
            window.print();
        }

        // Cerrar el menú al hacer clic fuera de él
        window.onclick = function(event) {
            const sidebar = document.querySelector('.sidebar');
            if (!sidebar.contains(event.target) && !document.querySelector('.menu-toggle').contains(event.target)) {
                sidebar.classList.remove('show');
            }
        }
    </script>
</body>
</html>
