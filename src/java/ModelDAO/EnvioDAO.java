/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModelDAO;

/**
 *
 * @author User
 */
import Config.Conexion;
import Model.Envio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnvioDAO {
    private Connection con;

    public EnvioDAO() {
        Conexion conexion = new Conexion();
        con = conexion.getConexion();
    }

    public List<Envio> listarEnvios() throws SQLException {
        List<Envio> lista = new ArrayList<>();
        String sql = "SELECT * FROM envios";
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Envio envio = new Envio();
                envio.setNumeroEnvio(rs.getString("Numero_envio"));
                envio.setCostoEnvio(rs.getDouble("costoEnvio"));
                envio.setDireccionDestino(rs.getString("direccionDestino"));
                envio.setTiempoEntrega(rs.getString("tiempoEntrega"));
                envio.setEstadoEnvio(rs.getString("estadoEnvio"));
                envio.setIdVenta(rs.getInt("IdVenta"));
                envio.setIdDomiciliario(rs.getInt("IdDomiciliario"));
                envio.setIdEmpleado(rs.getInt("IdEmpleado"));
                lista.add(envio);
            }
        }
        return lista;
    }

    public Envio obtenerEnvio(String numeroEnvio) throws SQLException {
        Envio envio = null;
        String sql = "SELECT * FROM envios WHERE Numero_envio = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, numeroEnvio);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    envio = new Envio();
                    envio.setNumeroEnvio(rs.getString("Numero_envio"));
                    envio.setCostoEnvio(rs.getDouble("costoEnvio"));
                    envio.setDireccionDestino(rs.getString("direccionDestino"));
                    envio.setTiempoEntrega(rs.getString("tiempoEntrega"));
                    envio.setEstadoEnvio(rs.getString("estadoEnvio"));
                    envio.setIdVenta(rs.getInt("IdVenta"));
                    envio.setIdDomiciliario(rs.getInt("IdDomiciliario"));
                    envio.setIdEmpleado(rs.getInt("IdEmpleado"));
                }
            }
        }
        return envio;
    }

    public void actualizarEnvio(Envio envio) throws SQLException {
        String sql = "UPDATE envios SET costoEnvio = ?, direccionDestino = ?, tiempoEntrega = ?, estadoEnvio = ?, IdVenta = ?, IdDomiciliario = ?, IdEmpleado = ? WHERE Numero_envio = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, envio.getCostoEnvio());
            ps.setString(2, envio.getDireccionDestino());
            ps.setString(3, envio.getTiempoEntrega());
            ps.setString(4, envio.getEstadoEnvio());
            ps.setInt(5, envio.getIdVenta());
            ps.setInt(6, envio.getIdDomiciliario());
            ps.setInt(7, envio.getIdEmpleado());
            ps.setString(8, envio.getNumeroEnvio());
            ps.executeUpdate();
        }
    }

    public void crearEnvio(Envio envio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
