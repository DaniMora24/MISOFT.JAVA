/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



public class Envio {
    private String numeroEnvio;
    private double costoEnvio;
    private String direccionDestino;
    private String tiempoEntrega;
    private String estadoEnvio;
    private int idVenta;
    private int idDomiciliario;
    private int idEmpleado;

    // Getters y setters
    public String getNumeroEnvio() {
        return numeroEnvio;
    }

    public void setNumeroEnvio(String numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(int idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
