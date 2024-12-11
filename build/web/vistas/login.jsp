<%-- 
    Document   : login
    Created on : 6/12/2024, 10:08:34 p. m.
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de sesión</title>
    <link rel="stylesheet" href="./Css/InicioSesion.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
<body>
    <div class="Register">
        <h1>Inicio de sesión</h1>
        <!-- El formulario apunta al servlet que gestionará el inicio de sesión -->
        <form action="login" method="POST">
            <div class="Email">
                <input name="Email" id="Email" type="email" required placeholder=" ">
                <label><i class='bx bx-user'></i> Nombre de usuario o E-mail</label>
            </div>
            <div class="Password">
                <input id="Password" name="Password" type="password" required placeholder=" ">
                <label><i class='bx bxs-key'></i> Contraseña</label>
            </div>
            <div class="Remember">
                <input type="checkbox" class="checkbox">
                Recordar cuenta
            </div><br>
            <div class="forget">
                <a href="#">¿Olvidaste tu contraseña?</a>
            </div><br>
            <div class="Registrarse"> ¿No tienes cuenta?
                <a href="registro">Regístrate</a>
            </div><br>
            <button type="submit" class="btn">Iniciar sesión</button>
        </form><br>
    </div>
    
    <footer>
        <ul class="botones">
            <li><a href="#"><i class='bx bx-help-circle'></i></a></li>
            <li><a href="#"><i class='bx bxl-whatsapp'></i></a></li>
        </ul>
    </footer>

    <!-- Mostrar mensajes de error si existen -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            <p>${error}</p>
        </div>
    </c:if>
</body>
</html>
