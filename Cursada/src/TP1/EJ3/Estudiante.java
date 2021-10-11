package TP1.EJ3;

public class Estudiante {
    
    String nombre, apellido, comision, email, direccion;

    public Estudiante(String nombre, String apellido, String comision, String email, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.comision = comision;
        this.email = email;
        this.direccion = direccion;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }
    public String getComision() {
        return comision;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String tusDatos()
    {
        
        return "Nombre: " + this.getNombre() + "  Apellido: " + this.getApellido() + "  Email: " + this.getEmail() + "  Comision: " + this.getComision() + " Direccion: " + this.getDireccion();
    }
}
