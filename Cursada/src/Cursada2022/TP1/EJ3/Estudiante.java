package Cursada2022.TP1.EJ3;

public class Estudiante{

    String nombre, apellido, comision, email, direccion;
    
    public Estudiante(){
        super();
    }
    
    public Estudiante(String nombre, String apellido, String comision, String email, String direccion){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setComision(comision);
        this.setEmail(email);
        this.setDireccion(direccion);
    }

    private String getNombre(){
        return this.nombre;
    }
    
    private String getApellido(){
        return this.apellido;
    }

    private String getComision(){
        return this.comision;
    }

    private String getEmail(){
        return this.email;
    }

    private String getDireccion(){
        return this.direccion;
    }

    private void setNombre(String nombre){
        this.nombre = nombre;
    }

    private void setApellido(String apellido){
        this.apellido = apellido;
    }

    private void setComision(String comision){
        this.comision = comision;
    }

    private void setEmail(String email){
        this.email = email;
    }

    private void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String tusDatos(){
        return "Nombre: " + this.getNombre() + "\nApellido: " + this.getApellido() + "\nComision: " + this.getComision() + "\nEmail: " + this.getEmail() + "\nDireccion: " + this.getDireccion();
    }


}
