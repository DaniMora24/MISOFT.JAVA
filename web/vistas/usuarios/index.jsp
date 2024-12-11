<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Css/dashboard.css">
    <title>Dashboard</title>
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
                <h2>Datos de Usuarios</h2>
                <table>
                    <thead>
                        <tr>
                           
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Email</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuarios}">
                            <tr>
                                
                                <td>${usuario.nombres}</td>
                                <td>${usuario.apellidos}</td>
                                <td>${usuario.email}</td>

                                <td>
                                    <form action="${pageContext.request.contextPath}/pagina/usuarios/delete" method="POST"
                                    onsubmit="return confirm('¿Estás seguro de eliminar este usuario?');" style="display:inline;">
                                    <input type="hidden" name="action" value="eliminarUsuario">
                                    <input type="hidden" name="email" value="${usuario.email}"> <!-- Aquí se agrega el email -->
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                    </form>
                                    
                                    <a  class="btn" onclick="imprimirReporte()">Reporte</a>
                                    

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </main>
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
