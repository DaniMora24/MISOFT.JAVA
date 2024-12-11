<%-- 
    Document   : editarenv
    Created on : 8/12/2024, 5:23:24 p. m.
    Author     : User
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Envío</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('Img/patitas gato.jpg');
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
            padding: 15px;
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
            margin-bottom: 5px;
            color: #fc6998;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        button, .button {
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
            text-align: center;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        button:hover, .button:hover {
            background-color: #e04877; 
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Editar Envío</h2>
        <form action="${pageContext.request.contextPath}/usuarios/envios?action=update" method="POST">
    <input type="hidden" name="action" value="update" />
    <input type="hidden" name="numeroEnvio" value="${envio.numeroEnvio}" />

    <label for="costoEnvio">Costo de Envío:</label>
    <input type="number" name="costoEnvio" value="${envio.costoEnvio}" required step="0.01" min="0" />

    <label for="direccionDestino">Dirección de Destino:</label>
    <input type="text" name="direccionDestino" value="${envio.direccionDestino}" required />

    <label for="tiempoEntrega">Tiempo de Entrega:</label>
    <input type="text" name="tiempoEntrega" value="${envio.tiempoEntrega}" required />

    <label for="estadoEnvio">Estado del Envío:</label>
<select id="estadoEnvio" name="estadoEnvio" required>
    <option value="Pendiente" ${envio.getEstadoEnvio().equals("Pendiente") ? "selected" : "" }>Pendiente</option>
    <option value="En camino" ${ envio.getEstadoEnvio().equals("En camino") ? "selected" : "" }>En camino</option>
    <option value="Entregado" ${ envio.getEstadoEnvio().equals("Entregado") ? "selected" : "" }>Entregado</option>
    <option value="Finalizado" ${ envio.getEstadoEnvio().equals("Finalizado") ? "selected" : "" }>Finalizado</option>
</select>



    <label for="IdVenta">ID Venta:</label>
    <input type="number" name="IdVenta" value="${envio.idVenta}" required />

    <label for="IdDomiciliario">ID Domiciliario:</label>
    <input type="number" name="IdDomiciliario" value="${envio.idDomiciliario}" required />

    <label for="IdEmpleado">ID Empleado:</label>
    <input type="number" name="IdEmpleado" value="${envio.idEmpleado}" required />

    <button type="submit" class="btn" onclick="return confirm('¿Estás seguro de Actualizar este Envío?');">Actualizar Envío</button>

    <a href="${pageContext.request.contextPath}/usuarios/envios?action=list" class="button" >Cancelar</a>
</form>

    </div>
</body>
</html>
