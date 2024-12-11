document.addEventListener('DOMContentLoaded', () => {
    mostrarProductosFactura();
    generarValoresAutomaticos(); // Llamar a la función para generar IDs
});

function mostrarProductosFactura() {
    let productosCarrito = JSON.parse(localStorage.getItem('productosCarrito')) || [];
    const cartItems = document.getElementById('cart-items');
    let subtotal = 0;

    productosCarrito.forEach(producto => {
        const total = parseFloat(producto.precio.replace('$', '').replace(',', '')) * producto.cantidad;
        subtotal += total;

        const row = document.createElement('tr');
        row.innerHTML = `<td>${producto.titulo}</td>
                         <td>${producto.cantidad}</td>
                         <td>${producto.precio}</td>
                         <td>$${total.toFixed(2)}</td>`;
        cartItems.appendChild(row);
    });

    const tax = subtotal * 0.21;
    const total = subtotal + tax;

    // Actualizar el texto en la vista
    document.getElementById('subtotal').textContent = `$${subtotal.toFixed(2)}`;
    document.getElementById('tax').textContent = `$${tax.toFixed(2)}`;
    document.getElementById('total').textContent = `$${total.toFixed(2)}`;

    // Calcular costo de envío
    let costoEnvio = total > 150 ? 0 : 10000; // Cambiado a mayor que 150
    document.getElementById('costo-envio').value = costoEnvio.toFixed(2);

    // Llenar los campos ocultos para enviar al servidor
    document.getElementById('hidden-subtotal').value = subtotal.toFixed(2);
    document.getElementById('hidden-iva').value = tax.toFixed(2);
    document.getElementById('hidden-total').value = (total + costoEnvio).toFixed(2);
}

// Establecer la fecha actual en el campo de fecha de pago y deshabilitar la selección
document.addEventListener('DOMContentLoaded', function() {
    var today = new Date().toISOString().split('T')[0];
    const fechaPagoInput = document.getElementById('fecha-pago');
    fechaPagoInput.value = today; // Asignar la fecha actual
    fechaPagoInput.setAttribute('readonly', true); // Deshabilitar la edición
});

// Nueva función para generar los valores automáticos
function generarValoresAutomaticos() {
    // Obtener los valores actuales de los IDs desde localStorage
    let idVenta = parseInt(localStorage.getItem('idVenta')) || 1; // Comienza en 1
    let numeroEnvio = parseInt(localStorage.getItem('numeroEnvio')) || 1; // Comienza en 1

    // Asignar los valores generados a los campos de entrada
    document.getElementById('id-venta').value = idVenta;
    document.getElementById('numero-envio').value = numeroEnvio;

    // Incrementar y almacenar los nuevos valores en localStorage
    localStorage.setItem('idVenta', idVenta + 1);
    localStorage.setItem('numeroEnvio', numeroEnvio + 1);
}

function finalizarCompra() {
    alert('Compra finalizada. ¡Gracias por tu compra!');
    localStorage.removeItem('productosCarrito'); // Limpiar carrito
}
