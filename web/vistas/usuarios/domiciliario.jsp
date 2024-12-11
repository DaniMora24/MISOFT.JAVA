<%-- 
    Document   : domiciliario
    Created on : 8/12/2024, 5:22:59 p. m.
    Author     : User
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Css/dashboard.css">
    <title>Lista de Envíos</title>
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
        <li><a href="{{ asset('catalogo') }}">Inicio</a></li>
        <li>
            <a href="#" class="dropdown-toggle" onclick="toggleDropdown(event)">Registros</a>
            <ul class="dropdown">
                <li><a href="{{ route('usuarios.index') }}">Usuarios</a></li>
                <li><a href="{{ route('empleados.index') }}">Empleados</a></li>
                <li><a href="{{ route('movimientos.index') }}">Movimientos Inventario</a></li>
                <li><a href="{{ route('proveedores.index') }}">Proveedores</a></li>
                <li><a href="{{ route('productos.index') }}">Productos</a></li>
                <li><a href="{{ route('envio.index') }}">Envio</a></li>
                <li><a href="{{ route('equipo.index') }}">Equipo</a></li>
                <li><a href="{{ route('pqrs.index') }}">PQRS</a></li>
                <li><a href="{{ route('pqrs.index') }}">Facturas</a></li>
            </ul>
        </li>
        <li><a href="#">Configuración</a></li>
        <li><a href="#">Estadisticas</a></li>
        <li><a href="#">Notificaciones</a></li>
        <li>
     <form action="${pageContext.request.contextPath}/pagina/logout" method="GET">
        <button type="submit" class="btn btn-danger">Cerrar sesión</button>
    </form>>
</li>
    </ul>
</div>
        <main>
            <section class="data-table">
                <h2>Lista de Envíos</h2>
                
                <table>
                    <thead>
                        <tr>
                            <th>Número de Envío</th>
                            <th>Costo de Envío</th>
                            <th>Dirección de Destino</th>
                            <th>Tiempo de Entrega</th>
                            <th>Estado Envio</th>
                            <th>Id Venta</th>
                            <th>Id Domiciliario</th>
                            <th>Id Empleado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Usar JSTL para iterar sobre los envíos -->
                        <c:forEach var="domiciliario" items="${envios}">
                            <tr>
                                <td>${domiciliario.numeroEnvio}</td>
                                <td>${domiciliario.costoEnvio}</td>
                                <td>${domiciliario.direccionDestino}</td>
                                <td>${domiciliario.tiempoEntrega}</td>
                                <td>${domiciliario.estadoEnvio}</td>
                                <td>${domiciliario.idVenta}</td>
                                    <td>${domiciliario.idDomiciliario}</td>
                                <td>${domiciliario.idEmpleado}</td>
                                <td class="button-group">
                                    <a href="/Crud1/usuarios/envios?action=edit&numero=${domiciliario.numeroEnvio}"class="btn">Editar</a>
                                      <a  class="btn" onclick="imprimirReporte()">Reporte</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
        </main>

        <!-- Mensajes de éxito y error -->
        <c:if test="${not empty sessionScope.success}">
            <div class="alert alert-success">
                ${sessionScope.success}
            </div>
        </c:if>

        <c:if test="${not empty sessionScope.errors}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach var="error" items="${sessionScope.errors}">
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
