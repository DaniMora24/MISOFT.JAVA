<%-- 
    Document   : dashboard
    Created on : 7/12/2024, 12:47:17 a. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Css/dashboard.css">
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
        <li><a href="{{ asset('catalogo') }}">Inicio</a></li>
        <li>
            <a href="#" class="dropdown-toggle" onclick="toggleDropdown(event)">Registros</a>
            <ul class="dropdown">
                <li><a href="${pageContext.request.contextPath}/pagina/usuarios/index">Usuarios</a></li>
                <li><a href="${pageContext.request.contextPath}/pagina/empleados/listar">Empleados</a></li>
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
    </form>
</li>
    </ul>
</div>
        <main>
            <section class="container1">
                <div class="welcome">
                <h2>¡Una michibienvenida!</h2>
                <p>Este es tu panel de control, donde podrás gestionar todo lo que necesites</p>
                </div>

           
                <div class="welcome1">
                <h2>¿Usos?</h2>
                <p>Aqui podras ver, eliminar o actualizar la informacion necesaria </p>
                </div>

                <div class="welcome3">
                <h2>Ejemplo:</h2>
                <p>La tabla de abajo es una representacion de como se te mostrara la información </p>
                </div>
            </section>
            

            <section class="data-table">
                <h2>Datos de la Base de Datos</h2>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Email</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Aquí se insertarán los datos de los usuarios -->
                        <tr>
                            <td>1</td>
                            <td>Ejemplo Usuario</td>
                            <td>ejemplo@correo.com</td>
                            <td>
                                <a href="#" class="btn">Actualizar</a>
                                <button type="submit" class="btn delete">Eliminar</button>
                            </td>
                        </tr>
                        <!-- Repite el bloque anterior para más usuarios -->
                    </tbody>
                </table>
                <a href="#" class="btn create">Crear Nuevo Usuario</a>
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
