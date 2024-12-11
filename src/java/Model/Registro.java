package Model;

public class Registro {
    private int Id_usuario;
    private String Numero_documento;
    private String Tipo_documento;
    private String Nombres;
    private String Apellidos;
    private long Telefono;  // El tipo es long
    private String Edad;
    private String Email;
    private String Password;
    private Empleado empleado; // Relación con la clase Empleado

    // Constructor con todos los parámetros necesarios
// Constructor con todos los parámetros necesarios
public Registro(String nombres, String apellidos, String tipoDocumento, String numeroDocumento, String fechaNacimiento, String telefono, String email, String password) {
    this.Nombres = nombres;
    this.Apellidos = apellidos;
    this.Tipo_documento = tipoDocumento;
    this.Numero_documento = numeroDocumento;
    this.Edad = fechaNacimiento; // Guardar la fecha de nacimiento directamente
    this.Telefono = Long.parseLong(telefono); // Se convierte el teléfono en Long
    this.Email = email;
    this.Password = password; // Se asigna la contraseña (considera cifrarla antes de almacenarla)
}


    // Constructor por defecto (opcional)
    public Registro() {
        // Si no necesitas que haga nada aquí, puedes dejarlo vacío
    }

    // Getters y setters
    public int getId_Usuario() {
        return Id_usuario;
    }

    public void setId_Usuario(int Id_Usuario) {
        this.Id_usuario = Id_Usuario;
    }

    public String getNumero_documento() {
        return Numero_documento;
    }

    public void setNumero_documento(String Numero_documento) {
        this.Numero_documento = Numero_documento;
    }

    public String getTipo_documento() {
        return Tipo_documento;
    }

    public void setTipo_documento(String Tipo_documento) {
        this.Tipo_documento = Tipo_documento;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public long getTelefono() {
        return Telefono;
    }

    public void setTelefono(long Telefono) {
        this.Telefono = Telefono;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

    

    
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    // Método para obtener la contraseña (similar al getAuthPassword en Laravel)
    public String getAuthPassword() {
        return this.Password;
    }
}
