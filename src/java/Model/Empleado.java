package Model;

import ModelDAO.RegistroDao;
import java.sql.Date;

public class Empleado {
    private int IdEmpleado;
    private int Id_usuario;  // Referencia a la clave foránea de usuario
    private String nombre;
    private String apellido;
    private double salario;
    private Date fecha_contratacion;
    private String rol_usuario;

    // Constructor sin parámetros
    public Empleado() {}

    // Constructor con todos los parámetros (solo si es necesario)
    public Empleado(int idEmpleado, int idUsuario, String nombre, String apellido, 
                    double salario, Date fechaContratacion, String rolUsuario) {
        this.IdEmpleado = idEmpleado;
        this.Id_usuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.fecha_contratacion = fechaContratacion;
        this.rol_usuario = rolUsuario;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public int getId_usuario() {
        return Id_usuario;
    }

    public void setId_usuario(int Id_usuario) {
        this.Id_usuario = Id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    

    public String getRol_usuario() {
        return rol_usuario;
    }

    public void setRol_usuario(String rol_usuario) {
        this.rol_usuario = rol_usuario;
    }

    // Relación de pertenencia a un Registro (usuario)
    public Registro getUsuario(RegistroDao registroDao) {
        return registroDao.getById(this.Id_usuario);
    }
}
