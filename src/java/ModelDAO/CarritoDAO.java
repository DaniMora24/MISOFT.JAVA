/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;


import Model.Carrito;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CarritoDAO {
    private final Connection con;

    public CarritoDAO(Connection con) {
        this.con = con;
    }

    public void guardar(Carrito carrito) throws SQLException {
        String sql = "INSERT INTO Pago (FechaPago, MetodoPago, CostoEnvio, subtotal, IVA, valor_pago, IdVenta, numero_Envio) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, carrito.getFechaPago());
            ps.setString(2, carrito.getMetodoPago());
            ps.setDouble(3, carrito.getCostoEnvio());
            ps.setDouble(4, carrito.getSubtotal());
            ps.setDouble(5, carrito.getIva());
            ps.setDouble(6, carrito.getValorPago());
            ps.setInt(7, carrito.getIdVenta());
            ps.setInt(8, carrito.getNumeroEnvio());
            ps.executeUpdate();
        }
    }
}
