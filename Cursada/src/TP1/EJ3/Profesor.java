package TP1.EJ3;

public class Profesor {
    

    String nombre, apellido, email, catedra, facultad;

    public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.catedra = catedra;
        this.facultad = facultad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getFacultad() {
        return facultad;
    }

    public String tusDatos()
    {
        
        return "Nombre: " + this.getNombre() + "  Apellido: " + this.getApellido() + "  Email: " + this.getEmail() + "  Catedra: " + this.getCatedra() + " Facultad: " + this.getFacultad();
    }


}
