/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Date;
/**
 *
 * @author User
 */
public class Carrito {
    
    private int idPago; // Clave primaria
    private Date fechaPago;
    private String metodoPago;
    private double costoEnvio;
    private double subtotal;
    private double iva;
    private double valorPago;
    private int idVenta;
    private int numeroEnvio;

    // Constructor vacío
    public Carrito() {}

    // Constructor con parámetros
    public Carrito(int idPago, Date fechaPago, String metodoPago, double costoEnvio, double subtotal, double iva, double valorPago, int idVenta, int numeroEnvio) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.costoEnvio = costoEnvio;
        this.subtotal = subtotal;
        this.iva = iva;
        this.valorPago = valorPago;
        this.idVenta = idVenta;
        this.numeroEnvio = numeroEnvio;
    }

    // Getters y Setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getNumeroEnvio() {
        return numeroEnvio;
    }

    public void setNumeroEnvio(int numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }

    
}

